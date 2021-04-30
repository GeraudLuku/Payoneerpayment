
package com.example.model;

import com.google.gson.annotations.Expose;

@SuppressWarnings("unused")
public class InputElement {

    @Expose
    private String name;
    @Expose
    private String type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
