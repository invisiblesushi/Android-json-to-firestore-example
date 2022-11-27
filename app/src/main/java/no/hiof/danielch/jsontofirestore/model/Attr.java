
package no.hiof.danielch.jsontofirestore.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Attr {

    @SerializedName("st")
    @Expose
    private no.hiof.danielch.jsontofirestore.model.St st;

    public no.hiof.danielch.jsontofirestore.model.St getSt() {
        return st;
    }

    public void setSt(no.hiof.danielch.jsontofirestore.model.St st) {
        this.st = st;
    }


}
