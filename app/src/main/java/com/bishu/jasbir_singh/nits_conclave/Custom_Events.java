package com.bishu.jasbir_singh.nits_conclave;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jasbir_Singh on 23-03-2017.
 */

public class Custom_Events  extends ArrayAdapter {
    List<EVENTS_DATA> l = new ArrayList<EVENTS_DATA>();

    public Custom_Events(@NonNull Context context, @LayoutRes int resource) {
        super(context, resource);
    }

    @Override
    public void add(@Nullable Object object) {
        super.add(object);
        l.add((EVENTS_DATA) object);
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        return super.getItem(position);
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
        View view = convertView;
        class ViewHolder {
            Button imageView;
            TextView textView, textView1;
        }
        ViewHolder holder;
        if (view == null) {
            LayoutInflater layoutInflator = (LayoutInflater) getContext().getSystemService(getContext().LAYOUT_INFLATER_SERVICE);
            view = layoutInflator.inflate(R.layout.custom_events, parent, false);
            holder = new ViewHolder();
            holder.imageView = (Button) view.findViewById(R.id.event_image);
            holder.textView = (TextView) view.findViewById(R.id.event_des);
            holder.textView1 = (TextView) view.findViewById(R.id.event_date);

            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        EVENTS_DATA events_data = (EVENTS_DATA) l.get(position);
        int id=getId(events_data.getImage(),R.drawable.class);
        holder.imageView.setBackgroundResource(id);

        holder.textView.setText(events_data.getDes());
        holder.textView1.setText(events_data.getDate());


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
