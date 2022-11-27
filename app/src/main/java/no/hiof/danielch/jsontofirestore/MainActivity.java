package no.hiof.danielch.jsontofirestore;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

import no.hiof.danielch.jsontofirestore.model.Charger;
import no.hiof.danielch.jsontofirestore.model.Chargerstation;
import no.hiof.danielch.jsontofirestore.model.Csmd;
import no.hiof.danielch.jsontofirestore.api.Api;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    Retrofit retrofit = new Retrofit.Builder()
                            .baseUrl(Api.ELBIL_URL)
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();

                    Api api = retrofit.create(Api.class);
                    Call<no.hiof.danielch.jsontofirestore.model.Charger> callNext;
                    callNext = api.getCharger(
                            "media",
                            "xxxxxxx-xxxx-xxxx-xxxx-xxxxxxxxxxx");


                    callNext.enqueue(new Callback<no.hiof.danielch.jsontofirestore.model.Charger>() {
                        @Override
                        public void onResponse(Call<no.hiof.danielch.jsontofirestore.model.Charger> callNext, Response<no.hiof.danielch.jsontofirestore.model.Charger> response) {

                            FirebaseFirestore db = FirebaseFirestore.getInstance();

                            for(int i=0; i < 10 ; i++){

                                Chargerstation chargerstation = response.body().getChargerstations().get(i);
                                db.collection("chargerstation").add(chargerstation);
                                Log.d(TAG, "onResponse: " + chargerstation.getCsmd().getName());
                                //Log.d(TAG, "onResponse: " + i + " of " + response.body());

                                chargerstation.getCsmd().getName();
                                chargerstation.getAttr().getSt().get2();
                                chargerstation.getAttr().getSt().get24();
                            }


                        }

                        @Override
                        public void onFailure(Call<Charger> call, Throwable t) {
                            Log.e(TAG, "onFailure: ", t );

                        }

                    });
                }




        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
