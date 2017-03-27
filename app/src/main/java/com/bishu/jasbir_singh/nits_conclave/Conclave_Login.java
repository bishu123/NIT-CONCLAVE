package com.bishu.jasbir_singh.nits_conclave;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;

public class Conclave_Login extends AppCompatActivity implements View.OnClickListener,GoogleApiClient.OnConnectionFailedListener{


    LoginButton loginButton;
    CallbackManager callbackManager;

    // View root;


    public ProgressDialog progressDialog;


    private Button signin;
    private TextView forgot,create,or,dont;
    FirebaseAuth firebaseAuth;
    DatabaseReference databaseReference;
    StorageReference storageReference;
    private SignInButton SIB;
    private EditText p_email,p_pass;
    //private ImageView p_img;

    private GoogleApiClient googleApiClient;
    private static final int REQ_CODE = 9001;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_conclave__login);
        firebaseAuth = FirebaseAuth.getInstance();

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.BLUE));
        databaseReference = FirebaseDatabase.getInstance().getReference();
        storageReference = FirebaseStorage.getInstance().getReference();
        SIB = (SignInButton)findViewById(R.id.google_login);
        p_email = (EditText) findViewById(R.id.name);
        p_pass = (EditText) findViewById(R.id.pass);
        signin = (Button)findViewById(R.id.login);


        forgot = (TextView)findViewById(R.id.forgot);
        forgot.setVisibility(View.INVISIBLE);
        or = (TextView)findViewById(R.id.or);
        dont = (TextView)findViewById(R.id.dont);
        create = (TextView)findViewById(R.id.create);
        progressDialog = new ProgressDialog(this);
        //p_img = (ImageView)findViewById(R.id.imageView);
        SIB.setOnClickListener(this);

        loginButton = (LoginButton)findViewById(R.id.fb_id);
        loginButton.setReadPermissions(Arrays.asList("public_profile, email, user_birthday"));//Facebook
        callbackManager = CallbackManager.Factory.create();
////////////////////////////////////////////////////////////////////////////////////////////////



        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(final  LoginResult loginResult) {
                //updateUI(true);
                fb_invisi();
                progressDialog.setMessage("Registering ......");
                progressDialog.show();
                GraphRequest request = GraphRequest.newMeRequest(
                        loginResult.getAccessToken(),
                        new GraphRequest.GraphJSONObjectCallback() {

                            @Override
                            public void onCompleted(JSONObject object, GraphResponse response) {
                                Log.v("Main", response.toString());

                                progressDialog.dismiss();
                                progressDialog.setMessage("Loging in...");
                                progressDialog.show();


                                //p_email.setText(loginResult.getAccessToken().getUserId());
                                //p_pass.setText(loginResult.getAccessToken().getToken());
                                setProfileToView(object);
                            }
                        });
                Bundle parameters = new Bundle();
                parameters.putString("fields","id,name,email,gender, birthday");
                request.setParameters(parameters);
                request.executeAsync();





            }


            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {

            }

        });
        // p_email.getBackground().setColorFilter(Color.BLACK, PorterDuff.Mode.SRC_IN);
        //p_pass.getBackground().setColorFilter(Color.BLACK, PorterDuff.Mode.SRC_IN);

        // p_email.setTextColor(getResources().getColor(Color.BLACK));

        signin.setOnClickListener(this);
        create.setOnClickListener(this);
        forgot.setOnClickListener(this);





        GoogleSignInOptions googleSignInOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        googleApiClient = new GoogleApiClient.Builder(this).enableAutoManage(this,this).addApi(Auth.GOOGLE_SIGN_IN_API,googleSignInOptions).build();

    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if(keyCode==KeyEvent.KEYCODE_BACK){


            moveTaskToBack(true);


        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onBackPressed() {

        super.onBackPressed();

    }
    public void fb_invisi(){
        signin.setVisibility(View.GONE);

        forgot.setVisibility(View.GONE);create.setVisibility(View.GONE);or.setVisibility(View.GONE);dont.setVisibility(View.GONE);
        SIB.setVisibility(View.GONE);
        p_email.setVisibility(View.GONE);p_pass.setVisibility(View.GONE);
        loginButton.setVisibility(View.GONE);

    }

    private void setProfileToView(final JSONObject object) {

        try {
            //p_email.setText(object.getString("name"));


            final  String email=object.getString("email").trim();
            final  String pass=object.getString("name").trim();

            ////
            final String img_uri= "https://graph.facebook.com/" + object.getString("id")+ "/picture?type=large";



            firebaseAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    //progressDialog.dismiss();
                    if(task.isSuccessful()){
                        progressDialog.setMessage("Signing in......");
                        progressDialog.show();
                        Toast.makeText(getApplicationContext(),"Created",Toast.LENGTH_LONG).show();
                        fb_sign(email,pass,img_uri);
                    }
                    else{
                        Exception exc = task.getException();
                        //  p_email.setText(task.getException().getMessage()+"1234");
                        if (exc.getMessage().contains("The email address is badly formatted.")) {
                            p_email.setText("Bad");
                        }
                        else if (exc.getMessage().contains("There is no user record corresponding to this identifier. The user may have been deleted.")) {
                            p_email.setText("No user record 2");
                        }
                        else if (exc.getMessage().contains("The password is invalid or the user does not have a password")) {
                            p_email.setText("No user record 3");
                        }
                        else if(exc.getMessage().contains("collision")||exc.getMessage().contains("The email address is already in use by another account")){
                            fb_sign(email,pass,img_uri);
                            // p_email.setText("No user record 4");
                        }

                    }
                }
            });

            //   p_pass.setText(loginResult.getAccessToken().getToken());

            // profilePictureView.setPresetSize(ProfilePictureView.NORMAL);
            //profilePictureView.setProfileId(jsonObject.getString("id"));
            //infoLayout.setVisibility(View.VISIBLE);
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }


    private void fb_sign(final String email, final String pass, final String img_uri) {
        firebaseAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressDialog.dismiss();
                progressDialog.setMessage("Loading Profile....");
                progressDialog.show();
                progressDialog.setCanceledOnTouchOutside(false);
                FirebaseUser user = firebaseAuth.getCurrentUser();
                Info info = null;
                info = new Info(pass,email,img_uri);
                databaseReference.child(user.getUid()).setValue(info);
                progressDialog.dismiss();
                startActivity(new Intent(getApplicationContext(), Conclave_Profile.class));
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(firebaseAuth.getCurrentUser()!=null){
            startActivity(new Intent(getApplicationContext(),Conclave_Profile.class));
        }
    }


    // @Override
    /*protected void onRestart() {
        super.onRestart();
        if(firebaseAuth.getCurrentUser()!=null){
            startActivity(new Intent(getApplicationContext(),Conclave_Profile.class));
        }
    }
    */

    //Register User
    public void registerUser(){
        final String U_email = p_email.getText().toString().trim();
        final String U_pass = p_pass.getText().toString().trim();
        if(U_email.length()==0){
            Toast.makeText(this, "Email Field Is Empty", Toast.LENGTH_SHORT).show();
        }
        if(U_pass.length()==0){
            Toast.makeText(this, "Password Field Is Empty", Toast.LENGTH_SHORT).show();
        }else if(U_email.length()==0||U_pass.length()==0){
            Toast.makeText(this, "Both Field Are  Empty", Toast.LENGTH_SHORT).show();
        }else {

            progressDialog.setMessage("Loging In.....");
            progressDialog.show();
            progressDialog.setCanceledOnTouchOutside(false);
        /*progressDialog.setMessage("REGISTERING USER.....");
        progressDialog.show();
        */
            firebaseAuth.signInWithEmailAndPassword(U_email, U_pass).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    progressDialog.dismiss();
                    if (task.isSuccessful()) {
                        //Info info=new Info(null,U_email,null);
                        //FirebaseUser user=firebaseAuth.getCurrentUser();

                        //databaseReference.child(user.getUid()).setValue(info);
                        startActivity(new Intent(getApplicationContext(), Conclave_Profile.class));
                    }

                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {


                    Exception exc = e;
                    Intent i = new Intent(getApplicationContext(), POP_UP.class);


                    if (exc.getMessage().contains("The email address is badly formatted.")) {
                        //p_email.setText("email bad");
                        i.putExtra("info", "bad");
                        startActivity(i);
                    } else if (exc.getMessage().contains("There is no user record corresponding to this identifier. The user may have been deleted.")) {
                        //p_email.setText("No user record");
                        i.putExtra("info", "no");
                        startActivity(i);

                    } else if (exc.getMessage().contains("The password is invalid or the user does not have a password")) {
                        //p_email.setText("Password is invalid");
                        i.putExtra("info", "p_invalid");
                        startActivity(i);
                    } else if (exc.getMessage().contains("collision") || exc.getMessage().contains("The email address is already in use by another account")) {
                        i.putExtra("info", "collision");
                        startActivity(i);
                    }

                }
            });
      /*firebaseAuth.createUserWithEmailAndPassword(U_email,U_pass).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressDialog.dismiss();
                if(task.isSuccessful()){

                    Toast.makeText(Conclave_Login.this, "Registerd Successfully", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(Conclave_Login.this, task.getException().toString()+" Register Error", Toast.LENGTH_SHORT).show();
                }
            }
        });*/
        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.google_login:
                sign_in();
                break;
            case R.id.login:
                registerUser();
                break;
            case R.id.forgot:
                break;
            case R.id.create:
                startActivity(new Intent(getApplicationContext(),Conclave_SignUp.class));
                break;

        }
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
    public void sign_in(){
        progressDialog.setMessage("Signing in ........");
        progressDialog.show();
        progressDialog.setCanceledOnTouchOutside(false);
        Intent intent = Auth.GoogleSignInApi.getSignInIntent(googleApiClient);
        startActivityForResult(intent,REQ_CODE);
    }
    public void handleResult(GoogleSignInResult result){
        if(result.isSuccess()) {
            final GoogleSignInAccount googleSignInAccount = result.getSignInAccount();
            final String email = googleSignInAccount.getEmail();
            final String name = googleSignInAccount.getDisplayName();

            final Uri img_url = Uri.parse(String.valueOf(googleSignInAccount.getPhotoUrl()));

            //Glide.with(this).load(img_url).into(loda);
          /*  firebaseAuth.createUserWithEmailAndPassword(email,name).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()) {

                    }else {
                        p_email.setText(task.getException().toString());
                    }
                }
            });
            */
            signin(email,name,img_url.toString());



        }
    }
    private  void signin(final String email, final String name, final String img_url){
        //  Toast.makeText(getApplicationContext(),"LOLWA2",Toast.LENGTH_LONG).show();
        firebaseAuth.signInWithEmailAndPassword(email,name).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()) {

                    FirebaseUser fb = firebaseAuth.getCurrentUser();

                    //  Toast.makeText(getApplicationContext(), fb.getUid(), Toast.LENGTH_LONG).show();

                    final Info info = new Info(name,email,img_url.toString());
                    databaseReference.child(fb.getUid()).setValue(info).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            p_email.setText(e.getMessage().toString());
                        }
                    });

                    progressDialog.dismiss();
                    startActivity(new Intent(getApplicationContext(),Conclave_Profile.class));

                } else {

                    //Toast.makeText(getApplicationContext(),"LOLWA3",Toast.LENGTH_LONG).show();
                    Exception exc = task.getException();

                    p_email.setText(task.getException().getMessage());

                    if (exc.getMessage().contains("The email address is badly formatted.")) {
                        p_email.setText("email bad");
                    }
                    else if (exc.getMessage().contains("There is no user record corresponding to this identifier. The user may have been deleted.")) {
                        p_email.setText("No user record");
                        create(email,name,img_url.toString());
                    }
                    else if (exc.getMessage().contains("The password is invalid or the user does not have a password")) {
                        p_email.setText("Password is invalid");
                    }







                }
            }
        }) .addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                p_email.setText(e.getMessage().toString());
            }
        });
    }

    private void create(final String email, final String name, final String img_url) {
        firebaseAuth.createUserWithEmailAndPassword(email,name).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()) {
                    signin(email,name,img_url);
                    //     sign_in();
                }
                else {
                    Exception exc = task.getException();
                    p_email.setText(task.getException().getMessage()+"1234");
                    if (exc.getMessage().contains("The email address is badly formatted.")) {
                        p_email.setText("Bad");
                    }
                    else if (exc.getMessage().contains("There is no user record corresponding to this identifier. The user may have been deleted.")) {
                        p_email.setText("No user record 2");
                    }
                    else if (exc.getMessage().contains("The password is invalid or the user does not have a password")) {
                        p_email.setText("No user record 3");
                    }
                    else if(exc.getMessage().contains("collision")){
                        signin(email,name,img_url);
                        p_email.setText("No user record 4");
                    }
                }
            }
        });

    }

    public void updateUI(boolean isLogin){
        if(isLogin){
            p_email.setVisibility(View.VISIBLE);
            p_pass.setVisibility(View.VISIBLE);
            SIB.setVisibility(View.GONE);
        }
        else {
            p_email.setVisibility(View.GONE);
            p_pass.setVisibility(View.GONE);
            SIB.setVisibility(View.VISIBLE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQ_CODE){
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            handleResult(result);
        }
    }


}