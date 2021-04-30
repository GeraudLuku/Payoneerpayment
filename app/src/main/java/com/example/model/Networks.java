
package com.example.model;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;

@SuppressWarnings("unused")
public class Networks {

    @Expose
    private ArrayList<Applicable> applicable;

    public ArrayList<Applicable> getApplicable() {
        return applicable;
    }

    public void setApplicable(ArrayList<Applicable> applicable) {
        this.applicable = applicable;
    }

}
