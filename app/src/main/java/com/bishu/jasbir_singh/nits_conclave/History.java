package com.bishu.jasbir_singh.nits_conclave;

import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by Jasbir_Singh on 21-03-2017.
 */

public class History extends android.support.v4.app.Fragment {
    ListView listView;
    Team_heads_custom team_heads_custom;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View root= inflater.inflate(R.layout.team,container,false);
        listView=(ListView)root.findViewById(R.id.team_head_list);
        ///int  xsd[]=getDimensions();
        //listView.setPadding(0, xsd[1]/3, 0, 0);
        team_heads_custom=new Team_heads_custom(getActivity().getApplicationContext(),R.layout.team);
        /*team_heads_custom.add(new Info("Patron",null,"patron"));
        /team_heads_custom.add(new Info("Institute Body",null,"institute"));
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
        team_heads_custom.add(new Member("Dance Club","default_profile"));
        team_heads_custom.add(new Member("Literary Club","default_profile"));
        team_heads_custom.add(new Member("Photography Club","default_profile"));
        team_heads_custom.add(new Member("Coding Club","default_profile"));
        team_heads_custom.add(new Member("Dramatics club","default_profile"));
        team_heads_custom.add(new Member("Music Club","default_profile"));
        team_heads_custom.add(new Member("Sports Club","default_profile"));
        team_heads_custom.add(new Member("Quiz Club","default_profile"));
        team_heads_custom.add(new Member("Alumni Cell","default_profile"));






        listView.setAdapter(team_heads_custom);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    position++;
                    Toast.makeText(getActivity().getApplicationContext(),"Dance club"+" is selected ",Toast.LENGTH_LONG).show();
                    //ondisplayswitch(position);
                }
                else if(position==1){
                    position++;Toast.makeText(getActivity().getApplicationContext(),"literary club "+" is selected ",Toast.LENGTH_LONG).show();
                    // ondisplayswitch(position);
                }
                else if(position==2){
                    position++;
                    Toast.makeText(getActivity().getApplicationContext(),"Photography Club"+"is selected ",Toast.LENGTH_LONG).show();
                    //ondisplayswitch(position);
                }
                else if(position==3){
                    position++;
                    Toast.makeText(getActivity().getApplicationContext(),"Coding Club" +" is selected ",Toast.LENGTH_LONG).show();
                    //ondisplayswitch(position);
                }
                else if(position==4){
                    position++;
                    Toast.makeText(getActivity().getApplicationContext(),"Dramatics club "+" is selected ",Toast.LENGTH_LONG).show();
                    // ondisplayswitch(position);
                }
               else if(position==5){
                    position++;
                    Toast.makeText(getActivity().getApplicationContext(),"Music Club" +" is selected ",Toast.LENGTH_LONG).show();
                    // ondisplayswitch(position);
                }
              else   if(position==6){
                    position++;
                    Toast.makeText(getActivity().getApplicationContext(),"Sports Club" +" is selected ",Toast.LENGTH_LONG).show();
                    //ondisplayswitch(position);
                }
                else if(position==7){
                    position++;
                    Toast.makeText(getActivity().getApplicationContext(),"Quiz Club" +" is selected ",Toast.LENGTH_LONG).show();
                    // ondisplayswitch(position);
                }
               else if(position==8){
                    position++;
                    Toast.makeText(getActivity().getApplicationContext(),"Alumni Cell"+position+" is selected ",Toast.LENGTH_LONG).show();
                    //ondisplayswitch(position);
                }
                else if(position==9){
                    position++;
                    Toast.makeText(getActivity().getApplicationContext(),"Member"+position+" is selected ",Toast.LENGTH_LONG).show();
                    //ondisplayswitch(position);
                }
               else if(position==10){
                    position++;
                    Toast.makeText(getActivity().getApplicationContext(),"Member"+position+" is selected ",Toast.LENGTH_LONG).show();
                    //ondisplayswitch(position);
                }
                else if(position==11){
                    position++;
                    Toast.makeText(getActivity().getApplicationContext(),"Member"+position+" is selected ",Toast.LENGTH_LONG).show();
                    //ondisplayswitch(position);
                }
            }
        });
        return  root;
    }
    public int[] getDimensions()
    {
        int dimensions[]=new int[2];
        WindowManager wmng=getActivity().getWindowManager();
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.HONEYCOMB_MR2)
        { Point point=new Point();
            wmng.getDefaultDisplay().getSize(point);
            dimensions[0]=point.x;
            dimensions[1]=point.y;

        }
        else
        {Display display=wmng.getDefaultDisplay();
            dimensions[0]=display.getWidth();
            dimensions[1]=display.getHeight();
        }
        return dimensions;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("CLUBS");
    }

}
