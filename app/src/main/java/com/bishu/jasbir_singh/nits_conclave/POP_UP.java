package com.bishu.jasbir_singh.nits_conclave;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.widget.TextView;

/**
 * Created by Jasbir_Singh on 20-03-2017.
 */

public class POP_UP extends Activity {
    TextView pop;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pop_window);
        pop=(TextView)findViewById(R.id.pop);
        Bundle b=getIntent().getExtras();
        String data=b.get("info").toString();
        switch (data){
            case "bad":
                pop.setText("The email address is badly formatted.");
                break;
            case "no":
                pop.setText("Account Does not Exits");
                break;
            case "p_invalid":
                pop.setText("UserName and Password Doesnot Match!!");

                break;
            case "collision":
                pop.setText("Account already exists");
                break;


        }

        DisplayMetrics displayMetrics=new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int width=displayMetrics.widthPixels;
        int height=displayMetrics.heightPixels;

        getWindow().setLayout((int)(width*0.8),(int)(height*0.3));
        getWindow().setTitle("WARNING");
        //pop.setPaddingRelative(0,(int)(height*0.3)/2,0,0);


    }
}
