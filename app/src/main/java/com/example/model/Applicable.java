
package com.example.model;

import java.util.List;
import com.google.gson.annotations.Expose;

public class Applicable {

    @Expose
    private String code;
    @Expose
    private String grouping;
    @Expose
    private List<InputElement> inputElements;
    @Expose
    private String label;
    @Expose
    private Links links;
    @Expose
    private String method;
    @Expose
    private String operationType;
    @Expose
    private String recurrence;
    @Expose
    private Boolean redirect;
    @Expose
    private String registration;
    @Expose
    private Boolean selected;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getGrouping() {
        return grouping;
    }

    public void setGrouping(String grouping) {
        this.grouping = grouping;
    }

    public List<InputElement> getInputElements() {
        return inputElements;
    }

    public void setInputElements(List<InputElement> inputElements) {
        this.inputElements = inputElements;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public String getRecurrence() {
        return recurrence;
    }

    public void setRecurrence(String recurrence) {
        this.recurrence = recurrence;
    }

    public Boolean getRedirect() {
        return redirect;
    }

    public void setRedirect(Boolean redirect) {
        this.redirect = redirect;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public Boolean getSelected() {
        return selected;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }

}
