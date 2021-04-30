
package com.example.model;

import com.google.gson.annotations.Expose;

@SuppressWarnings("unused")
public class PaymentMethods {

    @Expose
    private Identification identification;
    @Expose
    private String integrationType;
    @Expose
    private Interaction interaction;
    @Expose
    private Links linksX;
    @Expose
    private Networks networks;
    @Expose
    private String operation;
    @Expose
    private String operationType;
    @Expose
    private Payment payment;
    @Expose
    private String resultCode;
    @Expose
    private String resultInfo;
    @Expose
    private ReturnCode returnCode;
    @Expose
    private Status status;
    @Expose
    private Style style;
    @Expose
    private String timestamp;

    public Identification getIdentification() {
        return identification;
    }

    public void setIdentification(Identification identification) {
        this.identification = identification;
    }

    public String getIntegrationType() {
        return integrationType;
    }

    public void setIntegrationType(String integrationType) {
        this.integrationType = integrationType;
    }

    public Interaction getInteraction() {
        return interaction;
    }

    public void setInteraction(Interaction interaction) {
        this.interaction = interaction;
    }

    public Links getLinksX() {
        return linksX;
    }

    public void setLinksX(Links linksX) {
        this.linksX = linksX;
    }

    public Networks getNetworks() {
        return networks;
    }

    public void setNetworks(Networks networks) {
        this.networks = networks;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultInfo() {
        return resultInfo;
    }

    public void setResultInfo(String resultInfo) {
        this.resultInfo = resultInfo;
    }

    public ReturnCode getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(ReturnCode returnCode) {
        this.returnCode = returnCode;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Style getStyle() {
        return style;
    }

    public void setStyle(Style style) {
        this.style = style;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
