package com.bishu.jasbir_singh.nits_conclave;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.facebook.login.LoginManager;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Conclave_Profile extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,View.OnClickListener {
    FirebaseAuth firebaseAuth;
    FirebaseDatabase firebaseDatabase;
    ImageView profilepic;
    TextView name,email;
    DatabaseReference db;
    String user1="name";
    static  int RESULT_LOAD_IMAGE=1;
    String uri1="lol";

    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conclave__profile);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        db=FirebaseDatabase.getInstance().getReference();
        firebaseAuth=FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.BLUE));

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View view = navigationView.inflateHeaderView(R.layout.nav_header_conclave__profile);
         profilepic = (ImageView)view.findViewById(R.id.profile_pic);
        name=(TextView)view.findViewById(R.id.name_h);
        email=(TextView)view.findViewById(R.id.email_h);
        progressDialog=new ProgressDialog(this);
        profilepic.setOnClickListener(this);
        ondisplayswitch(R.id.nav_home);
    }

    @Override
    public void onClick(View v) {
        gallery();
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
            FirebaseUser user=FirebaseAuth.getInstance().getCurrentUser();
            DatabaseReference db=FirebaseDatabase.getInstance().getReference().child(user.getUid());
            db.child("pic").setValue(uri1);
            //Toast.makeText(getApplicationContext(),""+uri1,Toast.LENGTH_LONG).show();
            //profile_uri.setText(uri1.toString());

        }
    }
    @Override
    protected void onStart() {
        super.onStart();
        /*final Resources resources =getResources();
        InputStream inputStream = resources.openRawResource(R.raw.college_data);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        */





        if(firebaseAuth.getCurrentUser()!=null) {
         /*   try {
               /* String line;
                while ((line = reader.readLine()) != null) {
                    String[] strings = line.split("-");
                    String mml=strings[0].trim();
                    //if (strings.length < 2) continue;
                    db.child("NIT_LISTS").child(strings[0]).setValue(new NITS_FIRE(mml,strings[1],strings[2]));



                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            */
            progressDialog.setMessage("Loading Profile ....");
            progressDialog.show();
            progressDialog.setCanceledOnTouchOutside(false);
            final FirebaseUser user = firebaseAuth.getCurrentUser();
            DatabaseReference mc = firebaseDatabase.getReference(user.getUid());
            mc.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    progressDialog.dismiss();
                    Info info = dataSnapshot.getValue(Info.class);
                    String uri = info.getPic();
                    //getSupportActionBar().setTitle(uri);
                    user1=info.getName();
                    name.setText(info.getName());
                    email.setText(info.getEmail());
                    if(info.getPic().equals("nhi")){
                        profilepic.setImageResource(R.drawable.default_profile);
                    }else{
                        Glide.with(getApplicationContext()).load(Uri.parse(uri)).into(profilepic);
                    }

                }


                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }



    }
// @Override
   /* protected void onResume() {
         if(firebaseAuth.getCurrentUser()!=null){
             FirebaseUser user=firebaseAuth.getCurrentUser();
             DatabaseReference mc=firebaseDatabase.getReference(user.getUid());
             mc.addValueEventListener(new ValueEventListener() {
                 @Override
                 public void onDataChange(DataSnapshot dataSnapshot) {
                     Info info=dataSnapshot.getValue(Info.class);
                     String uri=info.pic;
                     Glide.with(getApplicationContext()).load(Uri.parse(uri)).into(profilepic);
                 }

                 @Override
                 public void onCancelled(DatabaseError databaseError) {

                 }
             });
         }
    }
    */
  // @Override
 public boolean onKeyDown(int keyCode, KeyEvent event) {

        if(keyCode==KeyEvent.KEYCODE_BACK){

            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            if (drawer.isDrawerOpen(GravityCompat.START)) {
                drawer.closeDrawer(GravityCompat.START);
            } else if(getFragmentManager().getBackStackEntryCount()==0){

                this.finish();
                //moveTaskToBack(true);

                //return  false;

            }else {
                //FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction().replace(R.id.content_main,fragment,"fragment1");
                ///fragmentTransaction.replace(R.id.content_main,fragment).addToBackStack(null);
                //fragmentTransaction.commit();
                getFragmentManager().popBackStack();

            }
        }
        return super.onKeyDown(keyCode, event);
    }




    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);

        }
        else{
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.conclave__profile, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            firebaseAuth.signOut();
            LoginManager.getInstance().logOut();
            startActivity(new Intent(getApplicationContext(),Conclave_Login.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void ondisplayswitch(int id){

        android.support.v4.app.Fragment fragment=null;
        if (id == R.id.nav_account) {
            fragment=new Account();

            // Handle the camera action
        } else if (id == R.id.nav_home) {
            fragment=new Home(user1);


        } else if (id == R.id.nav_events) {
            fragment=new Events();
        } else if (id == R.id.nav_clubs) {
            fragment=new History();
        } else if (id == R.id.nav_nit_fests) {
            fragment=new NIT_LIST();
        } else if(id==R.id.nav_lost){
            fragment=new ABOUT();
        }else if(id==R.id.nav_member){
            fragment=new Team();
        }else if(id==R.id.nav_dev){
            fragment=new Developer();
        }

        else if (id == R.id.nav_logout) {
            firebaseAuth.signOut();
            LoginManager.getInstance().logOut();
            startActivity(new Intent(getApplicationContext(),Conclave_Login.class));
        }
        if(fragment!=null){
            FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();//.replace(R.id.content_main,fragment,"fragment1");
            fragmentTransaction.replace(R.id.content_main,fragment).addToBackStack(null);
            fragmentTransaction.commit();
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        ondisplayswitch(id);
        return true;


    }
}
