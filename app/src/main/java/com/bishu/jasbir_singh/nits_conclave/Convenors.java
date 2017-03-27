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
 * Created by Jasbir_Singh on 23-03-2017.
 */

public class Convenors extends Fragment {
    ImageView convenors1,convenors2,convenors3,convenors4,convenors5;
    Bitmap bitmap;
    RoundedBitmapDrawable roundedBitmapDrawable;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root=inflater.inflate(R.layout.convenors,container,false);
        convenors1=(ImageView)root.findViewById(R.id.convenor1);
        convenors2=(ImageView)root.findViewById(R.id.conenor2);
        convenors3=(ImageView)root.findViewById(R.id.convenor3);
        convenors4=(ImageView)root.findViewById(R.id.convenor4);
        convenors5=(ImageView)root.findViewById(R.id.convenor5);

        bitmap= BitmapFactory.decodeResource(getActivity().getResources(),R.drawable.convenor1);
        roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(getActivity().getResources(), bitmap);
        roundedBitmapDrawable.setCircular(true);
        convenors1.setBackground(roundedBitmapDrawable);
        bitmap= BitmapFactory.decodeResource(getActivity().getResources(),R.drawable.convenor2);
        roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(getActivity().getResources(), bitmap);
        roundedBitmapDrawable.setCircular(true);
        convenors2.setBackground(roundedBitmapDrawable);
        bitmap= BitmapFactory.decodeResource(getActivity().getResources(),R.drawable.convenor3);
        roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(getActivity().getResources(), bitmap);
        roundedBitmapDrawable.setCircular(true);
        convenors3.setBackground(roundedBitmapDrawable);
        bitmap= BitmapFactory.decodeResource(getActivity().getResources(),R.drawable.convenor4);
        roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(getActivity().getResources(), bitmap);
        roundedBitmapDrawable.setCircular(true);
        convenors4.setBackground(roundedBitmapDrawable);
        bitmap= BitmapFactory.decodeResource(getActivity().getResources(),R.drawable.convenor5);
        roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(getActivity().getResources(), bitmap);
        roundedBitmapDrawable.setCircular(true);
        convenors5.setBackground(roundedBitmapDrawable);



        return  root;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("CONVENORS");
    }
}
