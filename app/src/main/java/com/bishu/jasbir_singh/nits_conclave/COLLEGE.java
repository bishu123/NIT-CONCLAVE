package com.bishu.jasbir_singh.nits_conclave;

/**
 * Created by Jasbir_Singh on 22-03-2017.
 */

public class COLLEGE {
    public String college_name="NITS";
    public  String College_logo="";


    public COLLEGE(String college_name, String college_logo ) {
        this.college_name = college_name;
        this.College_logo = college_logo;

    }

    public String getCollege_name() {
        return college_name;
    }

    public void setCollege_name(String college_name) {
        this.college_name = college_name;
    }

    public String getCollege_logo() {
        return College_logo;
    }

    public void setCollege_logo(String college_logo) {
        College_logo = college_logo;
    }


}
