
package com.example.model;

import com.google.gson.annotations.Expose;

@SuppressWarnings("unused")
public class Links {

    @Expose
    private String lang;
    @Expose
    private String logo;
    @Expose
    private String operation;
    @Expose
    private String self;
    @Expose
    private String validation;

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getSelf() {
        return self;
    }

    public void setSelf(String self) {
        this.self = self;
    }

    public String getValidation() {
        return validation;
    }

    public void setValidation(String validation) {
        this.validation = validation;
    }

}
