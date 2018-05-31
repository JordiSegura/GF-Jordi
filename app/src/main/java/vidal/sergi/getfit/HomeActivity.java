package vidal.sergi.getfit;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;



import static android.view.View.GONE;

public class HomeActivity extends AppCompatActivity {
    private static final String TAG ="HomeActivity";
    Intent intent;
    //vars
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();
    ImageView ivLogo;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home2);
        Log.d(TAG, "onCreate: started.");
        initImageBitmaps();
        ivLogo = findViewById(R.id.ivLogo2);
        ivLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(HomeActivity.this, AjustesActivity.class);
                startActivity(intent);
            }
        });
        final BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation1);
        bottomNavigationView.setSelectedItemId(R.id.action_home);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.action_home:
                        intent = new Intent(HomeActivity.this, HomeActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.action_rutinas:
                        intent = new Intent(HomeActivity.this, RutinasActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.action_dietas:
                        intent = new Intent(HomeActivity.this, DietasActivity.class);
                        startActivity(intent);;
                        break;
                }
                return true;
            }
        });
    }
    private void initImageBitmaps(){
        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");
        mImageUrls.add("https://schools.stlucie.k12.fl.us/lpa/files/2017/09/Events-Icon.png");
        mNames.add("Semana1");

        mImageUrls.add("https://schools.stlucie.k12.fl.us/lpa/files/2017/09/Events-Icon.png");
        mNames.add("Semana2");

        mImageUrls.add("https://schools.stlucie.k12.fl.us/lpa/files/2017/09/Events-Icon.png");
        mNames.add("Semana3");

        mImageUrls.add("https://schools.stlucie.k12.fl.us/lpa/files/2017/09/Events-Icon.png");
        mNames.add("Semana4");
        initRecyclerView();
    }
    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerview");
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        AdapterHome adapter = new AdapterHome(mNames,mImageUrls,this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
    }
