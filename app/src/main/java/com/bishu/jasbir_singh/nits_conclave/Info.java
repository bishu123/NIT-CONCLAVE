package com.bishu.jasbir_singh.nits_conclave;

/**
 * Created by Jasbir_Singh on 19-03-2017.
 */

public class Info
{
    public String name="name";
    public String email="email";
    public  String pic="nhi";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    Info(){

    }
    Info(String name,String email,String pic){
        this.name=name;
       this.pic=pic;
        this.email=email;
    }
}
