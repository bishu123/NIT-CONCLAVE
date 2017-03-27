package com.bishu.jasbir_singh.nits_conclave;

/**
 * Created by Jasbir_Singh on 23-03-2017.
 */

public class EVENTS_DATA {
    public String image="";
    public String des="";
    public  String date="";

    public EVENTS_DATA(String image, String des, String date) {
        this.image = image;
        this.des = des;
        this.date = date;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
