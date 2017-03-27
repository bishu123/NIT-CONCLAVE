package com.bishu.jasbir_singh.nits_conclave;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jasbir_Singh on 24-03-2017.
 */

public class Custom_gallery_new extends ArrayAdapter {
    List<String> l=new ArrayList<String>();
    class MyView

    {
        ImageView imageView;
    }
    MyView myView;
    Context context;

    public Custom_gallery_new(@NonNull Context context, @LayoutRes int resource) {
        super(context, resource);
        this.context=context;
    }

    @Override
    public void add(@Nullable Object object) {
        super.add(object);
        l.add((String)object);
    }

    @NonNull
    @Override
    public Context getContext() {
        return super.getContext();
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        return l.get(position);
    }

    @Override
    public int getPosition(@Nullable Object item) {
        return super.getPosition(item);
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view=convertView;
        if(view==null){
            LayoutInflater layoutInflator = (LayoutInflater)getContext().getSystemService(getContext().LAYOUT_INFLATER_SERVICE);
            view=layoutInflator.inflate(R.layout.gallery,parent,false);
            myView=new MyView();
            myView.imageView=(ImageView)view.findViewById(R.id.gallery);

            view.setTag(myView);
        }else {
            myView=(MyView) view.getTag();
        }
        String college=(String)l.get(position);


        int id=getId(college,R.drawable.class);

        myView.imageView.setImageResource(id);

        return view;
    }





    public static int getId(String resourceName, Class<?> c) {
        try {
            Field idField = c.getDeclaredField(resourceName);
            return idField.getInt(idField);
        } catch (Exception e) {
            throw new RuntimeException("No resource ID found for: "
                    + resourceName + " / " + c, e);
        }
    }
}
