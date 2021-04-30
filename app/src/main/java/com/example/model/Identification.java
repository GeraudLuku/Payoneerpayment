
package com.example.model;

import com.google.gson.annotations.Expose;

public class Identification {

    @Expose
    private String longId;
    @Expose
    private String shortId;
    @Expose
    private String transactionId;

    public String getLongId() {
        return longId;
    }

    public void setLongId(String longId) {
        this.longId = longId;
    }

    public String getShortId() {
        return shortId;
    }

    public void setShortId(String shortId) {
        this.shortId = shortId;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

}
