package com.bishu.jasbir_singh.nits_conclave;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by Jasbir_Singh on 21-03-2017.
 */

public class NIT_LIST extends android.support.v4.app.Fragment{
    ListView listView;
    CustomAdapter customAdapter;

    DatabaseReference mc;
    FirebaseDatabase firebaseDatabase;
   // FileInputStream fileInputStream;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View root=inflater.inflate(R.layout.nit_list,container,false);
        listView=(ListView)root.findViewById(R.id.nit_lists);
        /*firebaseDatabase=FirebaseDatabase.getInstance();
        mc=FirebaseDatabase.getInstance().getReference();
        */
      customAdapter=new CustomAdapter(getActivity().getBaseContext(),R.layout.nit_list);
       /* customAdapter.add(new COLLEGE("NIT Silchar","nit_silchar","http://www.nits.ac.in/"));  customAdapter.add(new COLLEGE("MNNIT Allahabad","nit_allahabad","http://www.mnnit.ac.in/")); customAdapter.add(new COLLEGE("MANIT Bhopal","nit_bhopal","http://www.manit.ac.in/"));
        customAdapter.add(new COLLEGE("NIT Jalandhar","nit_jalandhar","http://www.nitj.ac.in/")); customAdapter.add(new COLLEGE("NIT Jamshedpur","nit_jamshedpur","http://www.nitjsr.ac.in/")); customAdapter.add(new COLLEGE("NIT Kurukshetra","nit_kurukshetra","http://www.nitkkr.ac.in/"));
        customAdapter.add(new COLLEGE("NIT Delhi","nit_delhi","http://nitdelhi.ac.in/")); customAdapter.add(new COLLEGE( "NIT Agartala","nit_agartala","http://www.nita.ac.in/")); customAdapter.add(new COLLEGE("NIT Durgapur","nit_durgapur","http://www.nitdgp.ac.in/"));
        customAdapter.add(new COLLEGE("NIT Calicut","nit_calicut","http://www.nitc.ac.in/")); customAdapter.add(new COLLEGE("NIT Durgapur","nit_durgapur","http://www.nitdgp.ac.in/")); customAdapter.add(new COLLEGE("NIT Hamirpur","nit_hamirpur","http://nith.ac.in/newweb/"));
       customAdapter.add(new COLLEGE("MNIT Jaipur","nit_jaipur","http://www.mnit.ac.in/")); customAdapter.add(new COLLEGE("VNIT Nagpur","nit_nagpur","http://www.vnit.ac.in/"));  customAdapter.add(new COLLEGE("NIT Patna","nit_patna","http://www.nitp.ac.in/php/home.php"));

       customAdapter.add(new COLLEGE("NIT Srinagar","nit_srinagar","http://www.nitsri.net/"));
        customAdapter.add(new COLLEGE("NIT Rourkela","nit_rourkela","http://nitrkl.ac.in/websiteNew/"));
        customAdapter.add(new COLLEGE("NIT Raipur","nit_raipur","http://www.nitrr.ac.in/"));
        customAdapter.add(new COLLEGE("SVNIT Surat","nit_surat","http://www.svnit.ac.in/")); customAdapter.add(new COLLEGE("NIT Surathkal","nit_suratkal","http://www.nitk.ac.in/"));  customAdapter.add(new COLLEGE("NIT Trichy","nit_trichy","https://www.nitt.edu/"));
        customAdapter.add(new COLLEGE("NIT Warangal","nit_warangal","http://www.nitw.ac.in/main/")); customAdapter.add(new COLLEGE("NIT Arunachal Pradesh","nit_arunachal","http://www.nitap.in/"));  customAdapter.add(new COLLEGE("NIT Sikkim","nit_sikkim","http://www.nitsikkim.ac.in/"));
        customAdapter.add(new COLLEGE("NIT Goa","nit_goa","http://www.nitgoa.ac.in/")); customAdapter.add(new COLLEGE("NIT Meghalaya","nit_meghalaya","http://nitmeghalaya.in/nitm_web/index.php"));  customAdapter.add(new COLLEGE("NIT Nagaland","nit_nagaland","http://nitnagaland.ac.in/homenew/"));
        customAdapter.add(new COLLEGE("NIT Manipur","nit_manipur","http://www.nitmanipur.ac.in/" )); customAdapter.add(new COLLEGE("NIT Mizoram","nit_mizoram","http://www.nitmz.ac.in/"));  customAdapter.add(new COLLEGE("NIT Uttarakhand","nit_uttarakhand","http://nituk.ac.in/"));


        customAdapter.add(new COLLEGE("NIT Pondicherry","nit_puducheerry","http://www.nitpy.ac.in/"));
        */
       customAdapter.add(new COLLEGE("TECNOESIS","tecno"));
        customAdapter.add(new COLLEGE("INCANDESCENCE","incand"));
        customAdapter.add(new COLLEGE("POSUA","posua"));


        //
        listView.setAdapter(customAdapter);

        /*listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                if(scrollState!=0){
                    listView.getAdapter();
                }
            }
            *

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

            }
        });
*/


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                COLLEGE college=(COLLEGE)customAdapter.getItem(position);

                Toast.makeText(getActivity().getApplicationContext(),college.getCollege_name()+" contents will be updated Soon",Toast.LENGTH_LONG).show();
                  /*  Intent intent = getFBIntent(getActivity(), college.getLink());


                    // Start the activity
                    if (intent != null)
                        startActivity(intent);

                    startActivity(intent);
                    */
                /*}else {
                   // String s=college.getLink();
                    FragmentTransaction fragmentTransaction=getActivity().getSupportFragmentManager().beginTransaction();//.replace(R.id.content_main,fragment,"fragment1");
                    fragmentTransaction.replace(R.id.content_main,new Others()).addToBackStack(null);
                    fragmentTransaction.commit();
                }
                */
            }
        });


        return  root;
    }
    private Intent getFBIntent(FragmentActivity activity, String facebookId) {

            // Check if FB app is even installed
            //  getContext().getPackageManager().getPackageInfo("com.facebook.katana", 0);
            String facebookProfileUri =facebookId;
            return new Intent(Intent.ACTION_VIEW, Uri.parse(facebookProfileUri));




    }



    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



        getActivity().setTitle("FESTS");



    }


}
