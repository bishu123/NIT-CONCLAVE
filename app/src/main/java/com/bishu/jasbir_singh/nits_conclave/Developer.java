package com.bishu.jasbir_singh.nits_conclave;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by Jasbir_Singh on 21-03-2017.
 */

public class Developer extends android.support.v4.app.Fragment {
    ImageView imageView,srikar;
    ImageView bishu;
    Button jassi_linked;
    Button sri_link,sri_fb;
    Button bishu_linked,bishu_fb;


    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return  inflater.inflate(R.layout.developer,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Developers");
        imageView=(ImageView)view.findViewById(R.id.profile_jasbir);
        Bitmap bitmap= BitmapFactory.decodeResource(this.getActivity().getResources(),R.drawable.jas);
        RoundedBitmapDrawable roundedBitmapDrawable= RoundedBitmapDrawableFactory.create(getActivity().getResources(),bitmap);
        roundedBitmapDrawable.setCircular(true);
        imageView.setImageDrawable(roundedBitmapDrawable);

        bishu=(ImageView)view.findViewById(R.id.profile_bishu);
         bitmap= BitmapFactory.decodeResource(this.getActivity().getResources(),R.drawable.profile_bishu);
        roundedBitmapDrawable= RoundedBitmapDrawableFactory.create(getActivity().getResources(),bitmap);
        roundedBitmapDrawable.setCircular(true);
        bishu.setImageDrawable(roundedBitmapDrawable);
        Button f = (Button)view.findViewById(R.id.fb);
         f.setBackgroundResource(R.drawable.facebook);
        bishu_fb=(Button)view.findViewById(R.id.bishu_fb);
        bishu_linked=(Button)view.findViewById(R.id.bishu_linked);
        sri_fb=(Button)view.findViewById(R.id.sri_fb);
        sri_link=(Button)view.findViewById(R.id.sri_link);
        srikar=(ImageView)view.findViewById(R.id.sri_img);
        bitmap= BitmapFactory.decodeResource(this.getActivity().getResources(),R.drawable.srikar);
        roundedBitmapDrawable= RoundedBitmapDrawableFactory.create(getActivity().getResources(),bitmap);
        roundedBitmapDrawable.setCircular(true);
        srikar.setImageDrawable(roundedBitmapDrawable);


        f.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View arg0)
            {
                // Get the intent
                Intent intent = getFBIntent(getActivity(), "jasbir.singh.39108");

                // Start the activity
                if (intent != null)
                    startActivity(intent);
            }
        });
        jassi_linked=(Button)view.findViewById(R.id.linkedin);
        jassi_linked.setBackgroundResource(R.drawable.linkedin);
        jassi_linked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getLinkedIntent(getActivity(), "jasbir-singh-birdi-698024124/");

                // Start the activity
                if (intent != null)
                    startActivity(intent);
            }
        });
        bishu_fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getFBIntent(getActivity(), "017.bishu");

                // Start the activity
                if (intent != null)
                    startActivity(intent);
            }
        });

        bishu_linked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getLinkedIntent(getActivity(), "bishwajeet-kumar-9a0aa7122/");

                // Start the activity
                if (intent != null)
                    startActivity(intent);
            }
        });
        bishu_fb.setBackgroundResource(R.drawable.facebook);
        bishu_linked.setBackgroundResource(R.drawable.linkedin);
        sri_fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getFBIntent(getActivity(), "srikar.krishna.9");

                // Start the activity
                if (intent != null)
                    startActivity(intent);
            }
        });

        sri_link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getLinkedIntent(getActivity(), "srikar-krishna-55982a113/");

                // Start the activity
                if (intent != null)
                    startActivity(intent);
            }
        });

        sri_fb.setBackgroundResource(R.drawable.facebook);
        sri_link.setBackgroundResource(R.drawable.linkedin);



    }









    private Intent getLinkedIntent(FragmentActivity activity, String s) {
        String facebookProfileUri = "https://www.linkedin.com/in/" + s;
        return new Intent(Intent.ACTION_VIEW, Uri.parse(facebookProfileUri));

    }


    private Intent getFBIntent(FragmentActivity activity, String facebookId) {
        try {
            // Check if FB app is even installed
          //  getContext().getPackageManager().getPackageInfo("com.facebook.katana", 0);
            String facebookProfileUri = "https://www.facebook.com/" + facebookId;
            return new Intent(Intent.ACTION_VIEW, Uri.parse(facebookProfileUri));

        }
        catch(Exception e) {

            // Cache and Open a url in browser
            String facebookScheme = "fb://profile/" + facebookId;
            return new Intent(Intent.ACTION_VIEW, Uri.parse(facebookScheme));

        }


    }



    }

