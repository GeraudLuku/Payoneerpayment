
package com.example.model;

import com.google.gson.annotations.Expose;

@SuppressWarnings("unused")
public class ReturnCode {

    @Expose
    private String name;
    @Expose
    private String source;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

}
