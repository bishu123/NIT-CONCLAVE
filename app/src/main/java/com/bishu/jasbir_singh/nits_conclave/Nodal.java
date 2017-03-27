package com.bishu.jasbir_singh.nits_conclave;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by Jasbir_Singh on 24-03-2017.
 */

public class Nodal extends android.support.v4.app.Fragment {
    ImageView nodal1,nodal2,nodal3,nodal4,nodal5;
    Bitmap bitmap;
    RoundedBitmapDrawable roundedBitmapDrawable;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
         View root=inflater.inflate(R.layout.nodal,container,false);
        nodal1=(ImageView)root.findViewById(R.id.nodal1);
        nodal2=(ImageView)root.findViewById(R.id.nodal2);
        nodal3=(ImageView)root.findViewById(R.id.nodal3);
        nodal4=(ImageView)root.findViewById(R.id.nodal4);
        nodal5=(ImageView)root.findViewById(R.id.nodal5);
     bitmap= BitmapFactory.decodeResource(getActivity().getResources(),R.drawable.nodal1);
        roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(getActivity().getResources(), bitmap);
        roundedBitmapDrawable.setCircular(true);
        nodal1.setBackground(roundedBitmapDrawable);

        bitmap= BitmapFactory.decodeResource(getActivity().getResources(),R.drawable.nodal2);
        roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(getActivity().getResources(), bitmap);
        roundedBitmapDrawable.setCircular(true);
        nodal2.setBackground(roundedBitmapDrawable);

        bitmap= BitmapFactory.decodeResource(getActivity().getResources(),R.drawable.nodal3);
        roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(getActivity().getResources(), bitmap);
        roundedBitmapDrawable.setCircular(true);
        nodal3.setBackground(roundedBitmapDrawable);
        bitmap= BitmapFactory.decodeResource(getActivity().getResources(),R.drawable.nodal4);
        roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(getActivity().getResources(), bitmap);
        roundedBitmapDrawable.setCircular(true);
        nodal4.setBackground(roundedBitmapDrawable);
        bitmap= BitmapFactory.decodeResource(getActivity().getResources(),R.drawable.nodal5);
        roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(getActivity().getResources(), bitmap);
        roundedBitmapDrawable.setCircular(true);
        nodal5.setBackground(roundedBitmapDrawable);
        return  root;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("NODAL OFFICERS");
    }
}
