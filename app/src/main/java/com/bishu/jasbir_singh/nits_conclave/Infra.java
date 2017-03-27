package com.bishu.jasbir_singh.nits_conclave;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by Jasbir_Singh on 24-03-2017.
 */

public class Infra extends Fragment {
    ImageView infra1,infra2;
    Bitmap bitmap;
    RoundedBitmapDrawable roundedBitmapDrawable;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      View root= inflater.inflate(R.layout.infra,container,false);
        infra1=(ImageView)root.findViewById(R.id.infra1);
        infra2=(ImageView)root.findViewById(R.id.infra2);
        bitmap= BitmapFactory.decodeResource(getActivity().getResources(),R.drawable.infra1);
        roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(getActivity().getResources(), bitmap);
        roundedBitmapDrawable.setCircular(true);
        infra1.setBackground(roundedBitmapDrawable);
        bitmap= BitmapFactory.decodeResource(getActivity().getResources(),R.drawable.infra2);
        roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(getActivity().getResources(), bitmap);
        roundedBitmapDrawable.setCircular(true);
        infra2.setBackground(roundedBitmapDrawable);
        return root;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("INFRA");
    }
}
