
package no.hiof.danielch.jsontofirestore.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Charger {

    @SerializedName("Provider")
    @Expose
    private String provider;
    @SerializedName("Rights")
    @Expose
    private String rights;
    @SerializedName("apiver")
    @Expose
    private String apiver;
    @SerializedName("chargerstations")
    @Expose
    private List<no.hiof.danielch.jsontofirestore.model.Chargerstation> chargerstations = null;

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getRights() {
        return rights;
    }

    public void setRights(String rights) {
        this.rights = rights;
    }

    public String getApiver() {
        return apiver;
    }

    public void setApiver(String apiver) {
        this.apiver = apiver;
    }

    public List<no.hiof.danielch.jsontofirestore.model.Chargerstation> getChargerstations() {
        return chargerstations;
    }

    public void setChargerstations(List<no.hiof.danielch.jsontofirestore.model.Chargerstation> chargerstations) {
        this.chargerstations = chargerstations;
    }

}
