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

public class Publicity extends Fragment {
    ImageView publicity;
    Bitmap bitmap;
    RoundedBitmapDrawable roundedBitmapDrawable;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root=inflater.inflate(R.layout.publicity,container,false);
        publicity=(ImageView)root.findViewById(R.id.publicity1);
        bitmap= BitmapFactory.decodeResource(getActivity().getResources(),R.drawable.publicity1);
        roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(getActivity().getResources(), bitmap);
        roundedBitmapDrawable.setCircular(true);
        publicity.setBackground(roundedBitmapDrawable);
        return  root;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("PUBLICITY");
    }
}
