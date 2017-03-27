package com.bishu.jasbir_singh.nits_conclave;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Conclave_SignUp extends AppCompatActivity implements View.OnClickListener {
    private Button Signup,choose;
    private EditText signup_email,signup_pass,signup_cpass,username,profile_uri;
    FirebaseAuth firebaseAuth;
    DatabaseReference db;
    ProgressDialog progressDialog;
    static   String uri1="nhi";
    private static final int RESULT_LOAD_IMAGE=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conclave__sign_up);
        firebaseAuth = FirebaseAuth.getInstance();
        getSupportActionBar().setTitle("Gymkhana/SignUp");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.BLUE));
        //getSupportActionBar().setBackgroundDrawable(new ColorDrawable(0xCCCC0000));
        signup_email = (EditText)findViewById(R.id.signup_email);
        signup_pass = (EditText)findViewById(R.id.signup_pass);
        signup_cpass = (EditText)findViewById(R.id.signup_cpass);
        Signup = (Button)findViewById(R.id.Signup);
        username=(EditText)findViewById(R.id.username);
        profile_uri=(EditText)findViewById(R.id.profile_uri);
        choose=(Button)findViewById(R.id.choose);
        choose.setOnClickListener(this);

        profile_uri.setClickable(false);
        profile_uri.setFocusable(false);
        profile_uri.setFocusableInTouchMode(false);


        Signup.setOnClickListener(this);
        progressDialog = new ProgressDialog(this);
        db= FirebaseDatabase.getInstance().getReference();
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.Signup){
            final String S_email = signup_email.getText().toString().trim();
            final String S_pass = signup_pass.getText().toString().trim();
            String S_cpass = signup_cpass.getText().toString().trim();
            final  String usernam=username.getText().toString().trim();
            if(TextUtils.isEmpty(S_email)||TextUtils.isEmpty(S_pass)||TextUtils.isEmpty(S_cpass)){
                Toast.makeText(this, "Fields are Empty", Toast.LENGTH_SHORT).show();
            }
            else if(!S_pass.equals(S_cpass)) {
                Toast.makeText(this, "Recheck Password", Toast.LENGTH_SHORT).show();
            }
            else {
                progressDialog.setMessage("Registering....");
                progressDialog.show();
                progressDialog.setCanceledOnTouchOutside(false);
                firebaseAuth.createUserWithEmailAndPassword(S_email,S_pass).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();
                        if(task.isSuccessful()){
                            FirebaseUser user=firebaseAuth.getCurrentUser();
                            progressDialog.setMessage("Loading Profile....");
                            progressDialog.show();
                            progressDialog.setCanceledOnTouchOutside(false);
                             Info info = new Info(usernam,S_email,uri1);
                            db.child(user.getUid()).setValue(info).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {

                                }
                            }).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    progressDialog.dismiss();
                                }
                            });
                            startActivity(new Intent(getApplicationContext(),Conclave_Login.class));

                        }
                        else {
                            String[] s=task.getException().toString().split(":");

                            Toast.makeText(Conclave_SignUp.this,"Signup Error"+s[1], Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        }
        else if(v.getId()==R.id.choose){

            gallery();

        }
    }

    private void gallery() {
        Intent intent=new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent,RESULT_LOAD_IMAGE);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==RESULT_LOAD_IMAGE && resultCode==RESULT_OK && null!=data){

            uri1= String.valueOf(data.getData());
            //Toast.makeText(getApplicationContext(),""+uri1,Toast.LENGTH_LONG).show();
            profile_uri.setText(uri1.toString());

        }
    }
}
