package com.bishu.jasbir_singh.nits_conclave;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

/**
 * Created by Jasbir_Singh on 21-03-2017.
 */

public class Account extends android.support.v4.app.Fragment {

    EditText f_name,l_name,passing_year;
    static  TextView dob;
    Button Save;
    Spinner gender;//nit_list;
    private DatePicker datePicker;
    private Calendar calendar;
    ArrayAdapter<CharSequence> arrayAdapter1,arrayAdapter2;
    FirebaseAuth firebaseAuth;
    DatabaseReference databaseReference;
    FirebaseDatabase firebaseDatabase;
    FirebaseUser user;
    SharedPreferences sp;

    static  int year,month,day;
    static int gender_int=0,nit_int=0;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        firebaseAuth=FirebaseAuth.getInstance();
        firebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference= FirebaseDatabase.getInstance().getReference();
        calendar = Calendar.getInstance();

        }



    @Override
    public void onResume() {
        super.onResume();
        /*
        */
    }

    @Override
    public void onStop() {
        super.onStop();


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return  inflater.inflate(R.layout.account_test,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        f_name=(EditText)view.findViewById(R.id.f_name);
        l_name=(EditText)view.findViewById(R.id.l_name);
        passing_year=(EditText)view.findViewById(R.id.passing_year);
        dob=(TextView) view.findViewById(R.id.dob);
        user=firebaseAuth.getCurrentUser();
        f_name.setHintTextColor(Color.BLACK);
        l_name.setHintTextColor(Color.BLACK);
        //f_name.setHintTextColor(getResources().getColor(R.color.black_overlay));
        //editText.setHintTextColor(getResources().getColor(R.color.white));
        gender=(Spinner)view.findViewById(R.id.gender);
        Save=(Button)view.findViewById(R.id.save);
        //nit_list=(Spinner)view.findViewById(R.id.nit_list);

        arrayAdapter1=ArrayAdapter.createFromResource(getContext(),R.array.gender,android.R.layout.simple_spinner_item);
        arrayAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        gender.setAdapter(arrayAdapter1);
        final String[] genders = {""};
        gender.setSelection(gender_int);
        //nit_list.setSelection(nit_int);

        gender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                genders[0] =""+parent.getItemAtPosition(position);
                 gender_int=position;

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        gender.setPrompt("Gender");
        final String[] nits={""};


        arrayAdapter2=ArrayAdapter.createFromResource(getContext(),R.array.nit_list,android.R.layout.simple_spinner_item);
        arrayAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        /*nit_list.setAdapter(arrayAdapter2);
        nit_list.setSelection(nit_int);
        nit_list.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                nits[0]=""+parent.getItemAtPosition(position);
                nit_int=position;

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        */

        sp=this.getActivity().getSharedPreferences("mypref", Context.MODE_PRIVATE);

        getActivity().setTitle("Account");
        //final String last_name=l_name.getText().toString().trim();

        //////////////////////////////////////////////////////






        dob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment picker = new DatePickerFragment();
                picker.show(getActivity().getFragmentManager(),"datePicker");
            }
        });



        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //f_name.setText("betichod");
                //l_name.setText(last_name);
                //gender.setPrompt(genders[0]);
                //nit_list.setPrompt(nits[0]);
                if(f_name.getText().toString().trim().length()==0){
                    Toast.makeText(getContext(),"FIRST NAME CAN NOT BE EMPTY",Toast.LENGTH_LONG).show();
                }else{
                String date_of_birth=""+year+"/"+month+"/"+day;
                Save_data save_data=new Save_data(f_name.getText().toString().trim(),l_name.getText().toString(), gender_int,date_of_birth,nit_int,passing_year.getText().toString().trim()
                );
                passing_year.setText(passing_year.getText().toString().trim());
                databaseReference.child(user.getUid()).child("DATA").setValue(save_data);
                databaseReference.child(user.getUid()).child("name").setValue(f_name.getText().toString().trim()+" "+l_name.getText().toString().trim());
               /*ome fragment1 = new Home();

                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.account, fragment1);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
*/              }
            }
        });


    }
    public static class DatePickerFragment extends DialogFragment
            implements DatePickerDialog.OnDateSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            year = c.get(Calendar.YEAR);
            month = c.get(Calendar.MONTH);
            day = c.get(Calendar.DAY_OF_MONTH);

            // Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        public void onDateSet(DatePicker view, int year, int month, int day) {
            // Do something with the date chosen by the user
            showDate(year, month+1, day);
        }
        private void showDate(int year, int i, int day) {
            dob.setText(new StringBuilder().append(day).append("/")
                    .append(i).append("/").append(year));
        }
    }




}
