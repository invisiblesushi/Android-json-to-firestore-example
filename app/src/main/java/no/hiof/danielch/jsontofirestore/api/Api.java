package no.hiof.danielch.jsontofirestore.api;

import no.hiof.danielch.jsontofirestore.model.Charger;
import no.hiof.danielch.jsontofirestore.model.Chargerstation;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {

    //Base url
    String ELBIL_URL = "https://xxxxxxxx.xxxxxx/xxxxxxxxxxxxxxxx/";

    //Places
    @GET("elbil.json")
    Call<Charger> getCharger(
            @Query("alt") String location,
            @Query("token") String radius
    );

}
