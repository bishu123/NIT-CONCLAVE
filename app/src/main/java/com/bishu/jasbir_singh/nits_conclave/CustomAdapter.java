package com.bishu.jasbir_singh.nits_conclave;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jasbir_Singh on 22-03-2017.
 */

public class CustomAdapter extends ArrayAdapter {
    Context context;

    List<COLLEGE> l=new ArrayList<>();





    public CustomAdapter(@NonNull Context context, @LayoutRes int resource) {
        super(context, resource);
        this.context=context;

    }

    @Override
    public void add(@Nullable Object object) {
        super.add(object);
        l.add((COLLEGE)object);
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @Nullable
    @Override
    public Object getItem(int position) {
       // return super.getItem(position);
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
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view=convertView;
        class Myview{
            TextView name_nit;
            ImageView logo_nit;


        }
        Myview myview;
        if(view==null){
            LayoutInflater layoutInflator = (LayoutInflater)getContext().getSystemService(getContext().LAYOUT_INFLATER_SERVICE);
            view=layoutInflator.inflate(R.layout.custom_layout,parent,false);
            myview=new Myview();
            myview.name_nit=(TextView)view.findViewById(R.id.name_nit);
            myview.logo_nit=(ImageView) view.findViewById(R.id.logo_nit);

            view.setTag(myview);
        }else {
            myview=(Myview) view.getTag();
        }
        COLLEGE college=(COLLEGE) l.get(position);

    ///myview.name_nit.setText("ffsrsrf");
   /* int id=getId(college.getCollege_logo(),R.drawable.class);
        Bitmap bitmap= BitmapFactory.decodeResource(context.getResources(),id);
        RoundedBitmapDrawable roundedBitmapDrawable= RoundedBitmapDrawableFactory.create(context.getResources(),bitmap);
        roundedBitmapDrawable.setCircular(true);
        myview.logo_nit.setBackground(roundedBitmapDrawable);


*/
       int id= getId(college.getCollege_logo(), R.drawable.class);
        myview.logo_nit.setBackgroundResource(id);


        myview.name_nit.setText(college.getCollege_name());

       /* myview.logo_nit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                COLLEGE college=(COLLEGE)l.get(position);
                String link=college.getLink();
                Toast.makeText(getContext(),"MMl"+position,Toast.LENGTH_LONG).show();
                context.startActivity(new Intent(getContext(),Conclave_SignUp.class));


                // Start the activity

            }
        });
        myview.go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                COLLEGE college=(COLLEGE)l.get(position);
                String link=college.getLink();
                //Intent intent = gotosearch(link);
                Toast.makeText(getContext(),"MMl"+position,Toast.LENGTH_LONG).show();
                //context.startActivity(intent);
                // Start the activity

            }
        });*/

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
