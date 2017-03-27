package com.bishu.jasbir_singh.nits_conclave;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

/**
 * Created by Jasbir_Singh on 24-03-2017.
 */

public class gallery extends Fragment{
    ListView listView;
    Custom_gallery_new c;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root= inflater.inflate(R.layout.gallery_frag,container,false);
        listView=(ListView)root.findViewById(R.id.gallery_list);
        c=new Custom_gallery_new(getContext(),R.layout.gallery_frag);
        c.add("gallery_1");c.add("gallery_2");c.add("gallery_3");c.add("gallery_4");c.add("gallery_5");
        listView.setAdapter(c);
        return  root;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
