package com.bishu.jasbir_singh.nits_conclave;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by Jasbir_Singh on 21-03-2017.
 */

public class Team extends android.support.v4.app.Fragment {
    ListView listView;
    Team_heads_custom team_heads_custom;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
       View root= inflater.inflate(R.layout.team,container,false);
        listView=(ListView)root.findViewById(R.id.team_head_list);
        team_heads_custom=new Team_heads_custom(getActivity().getApplicationContext(),R.layout.team);
        /*team_heads_custom.add(new Info("Patron",null,"patron"));
        team_heads_custom.add(new Info("Institute Body",null,"institute"));
        team_heads_custom.add(new Info("Founding Body",null,"foundation"));
        team_heads_custom.add(new Info("Alumni Conveners",null,"alumni"));
        team_heads_custom.add(new Info("Conveners","","covener"));
        team_heads_custom.add(new Info("Technical Heads","","technical"));
        team_heads_custom.add(new Info("Marketing Head",null,"marketing1"));
        team_heads_custom.add(new Info("Publicity Head",null,"public1"));
        team_heads_custom.add(new Info("Hospitality Heads",null,"hospitality"));
        team_heads_custom.add(new Info("Infra Heads",null,"infra"));
        team_heads_custom.add(new Info("Nodal Officers",null,"nodal"));
*/
        team_heads_custom.add(new Member("MEMBER1","default_profile"));
        team_heads_custom.add(new Member("MEMBER2","default_profile"));
        team_heads_custom.add(new Member("MEMBER3","default_profile"));
        team_heads_custom.add(new Member("MEMBER4","default_profile"));
        team_heads_custom.add(new Member("MEMBER5","default_profile"));
        team_heads_custom.add(new Member("MEMBER6","default_profile"));
        team_heads_custom.add(new Member("MEMBER7","default_profile"));
        team_heads_custom.add(new Member("MEMBER8","default_profile"));
        team_heads_custom.add(new Member("MEMBER9","default_profile"));
        team_heads_custom.add(new Member("MEMBER10","default_profile"));
        team_heads_custom.add(new Member("MEMBER11","default_profile"));





        listView.setAdapter(team_heads_custom);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    position++;
                    Toast.makeText(getActivity().getApplicationContext(),"Member"+position+" is selected ",Toast.LENGTH_LONG).show();
                    //ondisplayswitch(position);
                }
                if(position==1){
                    position++;Toast.makeText(getActivity().getApplicationContext(),"Member"+position+" is selected ",Toast.LENGTH_LONG).show();
                   // ondisplayswitch(position);
                }
                if(position==2){
                    position++;
                    Toast.makeText(getActivity().getApplicationContext(),"Member"+position+" is selected ",Toast.LENGTH_LONG).show();
                    //ondisplayswitch(position);
                }
                if(position==3){
                    position++;
                    Toast.makeText(getActivity().getApplicationContext(),"Member"+position+" is selected ",Toast.LENGTH_LONG).show();
                    //ondisplayswitch(position);
                }
                if(position==4){
                    position++;
                    Toast.makeText(getActivity().getApplicationContext(),"Member"+position+" is selected ",Toast.LENGTH_LONG).show();
                   // ondisplayswitch(position);
                }
                 if(position==5){
                     position++;
                     Toast.makeText(getActivity().getApplicationContext(),"Member"+position+" is selected ",Toast.LENGTH_LONG).show();
                       // ondisplayswitch(position);
                 }
                if(position==6){
                    position++;
                    Toast.makeText(getActivity().getApplicationContext(),"Member"+position+" is selected ",Toast.LENGTH_LONG).show();
                    //ondisplayswitch(position);
                }
                if(position==7){
                    position++;
                    Toast.makeText(getActivity().getApplicationContext(),"Member"+position+" is selected ",Toast.LENGTH_LONG).show();
                   // ondisplayswitch(position);
                }
                if(position==8){
                    position++;
                    Toast.makeText(getActivity().getApplicationContext(),"Member"+position+" is selected ",Toast.LENGTH_LONG).show();
                    //ondisplayswitch(position);
                }
                if(position==9){
                    position++;
                    Toast.makeText(getActivity().getApplicationContext(),"Member"+position+" is selected ",Toast.LENGTH_LONG).show();
                    //ondisplayswitch(position);
                }
                if(position==10){
                    position++;
                    Toast.makeText(getActivity().getApplicationContext(),"Member"+position+" is selected ",Toast.LENGTH_LONG).show();
                    //ondisplayswitch(position);
                }
                if(position==11){
                    position++;
                    Toast.makeText(getActivity().getApplicationContext(),"Member"+position+" is selected ",Toast.LENGTH_LONG).show();
                    //ondisplayswitch(position);
                }
            }
        });
        return  root;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("MEMBERS");
    }
    public void ondisplayswitch(int id) {

        android.support.v4.app.Fragment fragment = null;
        if (id == 0) {
            fragment = new Patron();
            // Handle the camera action
        }
        if (id == 1) {
            fragment = new InstituteBody();
            // Handle the camera action
        }
        if (id == 2) {
            fragment = new FoundingBody();
            // Handle the camera action
        }
        if (id == 3) {
            fragment = new AlumniConveners();
            // Handle the camera action
        }
        if (id == 4) {
            fragment = new Convenors();
            // Handle the camera action
        }
        if (id == 5) {
            fragment = new Technical();
            // Handle the camera action
        }
        if (id == 6) {
            fragment = new Marketing();
            // Handle the camera action
        }
        if (id == 7) {
            fragment = new Publicity();
            // Handle the camera action
        }
        if (id == 8) {
            fragment = new Hospitality();
            // Handle the camera action
        }
        if (id == 9) {
            fragment = new Infra();
            // Handle the camera action
        }
        if (id == 10) {
            fragment = new Nodal();
            // Handle the camera action
        }

        if (fragment != null) {
            FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.content_main, fragment).addToBackStack(null).commit();

        }
    }


}
