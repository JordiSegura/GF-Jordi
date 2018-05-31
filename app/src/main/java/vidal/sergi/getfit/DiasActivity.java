package vidal.sergi.getfit;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import vidal.sergi.getfit.Objetos.DiasSemana;

public class DiasActivity extends AppCompatActivity {
    public final String TAG ="DiasActivity";
    Intent intent;




    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home2);
        Log.d(TAG, "onCreate: started.");

        initImageBitmaps();


    }

    private void initImageBitmaps(){
        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");
        mImageUrls.add("https://schools.stlucie.k12.fl.us/lpa/files/2017/09/Events-Icon.png");
        mNames.add("Lunes");

        mImageUrls.add("https://schools.stlucie.k12.fl.us/lpa/files/2017/09/Events-Icon.png");
        mNames.add("Martes");

        mImageUrls.add("https://schools.stlucie.k12.fl.us/lpa/files/2017/09/Events-Icon.png");
        mNames.add("Miercoles");

        mImageUrls.add("https://schools.stlucie.k12.fl.us/lpa/files/2017/09/Events-Icon.png");
        mNames.add("Jueves");

        mImageUrls.add("https://schools.stlucie.k12.fl.us/lpa/files/2017/09/Events-Icon.png");
        mNames.add("Viernes");

        mImageUrls.add("https://schools.stlucie.k12.fl.us/lpa/files/2017/09/Events-Icon.png");
        mNames.add("Sábado");

        mImageUrls.add("https://schools.stlucie.k12.fl.us/lpa/files/2017/09/Events-Icon.png");
        mNames.add("Domingo");

        initRecyclerView();
    }
    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerview");
        Bundle extras2 = getIntent().getExtras();
            String value = extras2.getString("semana1");
            String contador2 = value;
            Log.d(TAG, "onCreate: VALOR:) "+contador2);
            String val = contador2;



        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        DiasAdapter adapter = new DiasAdapter(mNames,mImageUrls,this,contador2);
        adapter.setIntento(val);
        Log.d(TAG, "initRecyclerView: En DiasActivity pilla ESTO:"+adapter.getIntento());

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }




}
