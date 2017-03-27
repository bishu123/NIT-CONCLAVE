package com.bishu.jasbir_singh.nits_conclave;

/**
 * Created by Jasbir_Singh on 21-03-2017.
 */

public class Save_data  {
    public  String first_name="first_name";
    public String last_name="last_name";
    public int gender=0;
    public  int college=0;
    public String dob="";
    public  String passing_year="passing_year";

    public Save_data(String first_name,String last_name, int gender,  String dob,int college, String passing_year) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.gender = gender;
        this.college = college;
        this.dob=dob;
        this.passing_year = passing_year;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getCollege() {
        return college;
    }

    public void setCollege(int college) {
        this.college = college;
    }

    public String getPassing_year() {
        return passing_year;
    }

    public void setPassing_year(String passing_year) {
        this.passing_year = passing_year;
    }
}
