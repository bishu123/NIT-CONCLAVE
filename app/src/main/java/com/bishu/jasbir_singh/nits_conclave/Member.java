package com.bishu.jasbir_singh.nits_conclave;

/**
 * Created by Jasbir_Singh on 26-03-2017.
 */

public class Member {
    String name="";
    String pic="";

    public Member(String name, String pic) {
        this.name = name;
        this.pic = pic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }
}
