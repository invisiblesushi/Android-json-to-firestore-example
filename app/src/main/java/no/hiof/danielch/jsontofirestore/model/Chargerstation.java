
package no.hiof.danielch.jsontofirestore.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Chargerstation {

    @SerializedName("csmd")
    @Expose
    private no.hiof.danielch.jsontofirestore.model.Csmd csmd;
    @SerializedName("attr")
    @Expose
    private no.hiof.danielch.jsontofirestore.model.Attr attr;

    public no.hiof.danielch.jsontofirestore.model.Csmd getCsmd() {
        return csmd;
    }

    public void setCsmd(no.hiof.danielch.jsontofirestore.model.Csmd csmd) {
        this.csmd = csmd;
    }

    public no.hiof.danielch.jsontofirestore.model.Attr getAttr() {
        return attr;
    }

    public void setAttr(no.hiof.danielch.jsontofirestore.model.Attr attr) {
        this.attr = attr;
    }

}
