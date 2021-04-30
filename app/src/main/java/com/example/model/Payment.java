
package com.example.model;

import com.google.gson.annotations.Expose;

@SuppressWarnings("unused")
public class Payment {

    @Expose
    private Long amount;
    @Expose
    private String currency;
    @Expose
    private String reference;

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

}
