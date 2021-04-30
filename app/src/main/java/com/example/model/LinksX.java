package com.example.model;

import com.google.gson.annotations.Expose;

public class LinksX {

    @Expose
    private String lang;
    @Expose
    private String self;


    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }


    public String getSelf() {
        return self;
    }

    public void setSelf(String self) {
        this.self = self;
    }


}
