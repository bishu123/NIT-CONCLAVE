package com.bishu.jasbir_singh.nits_conclave;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

/**
 * Created by Jasbir_Singh on 21-03-2017.
 */

public class Events extends android.support.v4.app.Fragment {
    ListView listView;
    Custom_Events custom_events;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
       View root=inflater.inflate(R.layout.events,container,false);
       listView=(ListView)root.findViewById(R.id.event_list);
        custom_events=new Custom_Events(getActivity(),R.layout.custom_events);
        custom_events.add(new EVENTS_DATA("event_one","Event1","Comming Soon"));
        custom_events.add(new EVENTS_DATA("event2","Event2","Comming Soon"));
        custom_events.add(new EVENTS_DATA("event3","Event3","Comming Soon"));


        listView.setAdapter(custom_events);
        return root;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Events");




    }
}
