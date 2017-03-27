package com.bishu.jasbir_singh.nits_conclave;

/**
 * Created by Jasbir_Singh on 23-03-2017.
 */

public class NITS_FIRE {
    public String name="";
    public String photo="";
    public String uri="";

    public NITS_FIRE(String name,String photo, String uri) {
        this.name=name;
        this.photo = photo;
        this.uri = uri;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }
}
