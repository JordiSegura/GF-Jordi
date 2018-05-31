package vidal.sergi.getfit;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import vidal.sergi.getfit.Objetos.Dia;
import vidal.sergi.getfit.Objetos.FirebaseReferences;
import vidal.sergi.getfit.Objetos.Seguimiento;
import vidal.sergi.getfit.Objetos.Semana;
import vidal.sergi.getfit.Objetos.Usuario;


public class LoginActivity extends AppCompatActivity {
    List<Seguimiento> seguimientoList;
    List<Semana> semanaList;
    List<Dia> diaList;

    EditText email, password;
    TextView btnRegistrar, btnLogin;
    final FirebaseDatabase database=FirebaseDatabase.getInstance();
    DatabaseReference seguimento = database.getReference(FirebaseReferences.SEGUIMIENTO);
    DatabaseReference usersRef = database.getReference(FirebaseReferences.USERS);



    String emailRegistro, passwordRegistro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        btnLogin = findViewById(R.id.login);
        btnRegistrar = findViewById(R.id.registrar);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                emailRegistro = email.getText().toString();
                passwordRegistro = password.getText().toString();
                iniciarSesion(emailRegistro, passwordRegistro);
            }
        });
        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegistroActivity.class);
                startActivity(intent);
            }
        });
    }
    @Override
    protected void onStart() {
        super.onStart();
        seguimientoList = new ArrayList<>();
        final Seguimiento semana1 = new Seguimiento( "Semana1",crearRutina1());
        final Seguimiento semana2 = new Seguimiento( "Semana2",crearRutina1());
        final Seguimiento semana3 = new Seguimiento( "Semana3",crearRutina1());
        final Seguimiento semana4 = new Seguimiento( "Semana4",crearRutina1());


        seguimientoList.add(semana1);
        seguimientoList.add(semana2);
        seguimientoList.add(semana3);
        seguimientoList.add(semana4);
    }

    private List<Semana> crearRutina1(){
        semanaList = new ArrayList<>();
        diaList = new ArrayList<>();

        //Grupo 1
        Dia desayuno = new Dia(false,false,false,false,false,false);
        diaList.add(desayuno);
        Dia almuerzo = new Dia(false,false,false,false,false,false);
        diaList.add(almuerzo);
        Dia comida = new Dia(false,false,false,false,false,false);
        diaList.add(comida);
        Dia merienda = new Dia(false,false,false,false,false,false);
        diaList.add(merienda);
        Dia cena = new Dia(false,false,false,false,false,false);
        diaList.add(cena);

        Semana semana1 = new Semana(diaList);
        semanaList.add(semana1);

        seguimento.child("Semana1").child("Lunes").setValue(diaList.get(0));
        seguimento.child("Semana1").child("Martes").setValue(diaList.get(1));
        seguimento.child("Semana1").child("Miercoles").setValue(diaList.get(2));
        seguimento.child("Semana1").child("Jueves").setValue(diaList.get(3));
        seguimento.child("Semana1").child("Viernes").setValue(diaList.get(3));
        seguimento.child("Semana1").child("Sábado").setValue(diaList.get(3));
        seguimento.child("Semana1").child("Domingo").setValue(diaList.get(3));

        //Grupo 2
        diaList = new ArrayList<>();

        Dia desayun1o = new Dia(false,false,false,false,false,false);
        diaList.add(desayun1o);
        Dia almuerzo1 = new Dia(false,false,false,false,false,false);
        diaList.add(almuerzo1);
        Dia comida1 = new Dia(false,false,false,false,false,false);
        diaList.add(comida1);
        Dia merienda1 = new Dia(false,false,false,false,false,false);
        diaList.add(merienda1);
        Dia cena1 = new Dia(false,false,false,false,false,false);
        diaList.add(cena1);


        Semana semana2 = new Semana(diaList);
        semanaList.add(semana2);

        seguimento.child("Semana2").child("Lunes").setValue(diaList.get(0));
        seguimento.child("Semana2").child("Martes").setValue(diaList.get(1));
        seguimento.child("Semana2").child("Miercoles").setValue(diaList.get(2));
        seguimento.child("Semana2").child("Jueves").setValue(diaList.get(3));
        seguimento.child("Semana2").child("Viernes").setValue(diaList.get(3));
        seguimento.child("Semana2").child("Sábado").setValue(diaList.get(3));
        seguimento.child("Semana2").child("Domingo").setValue(diaList.get(3));


        //Grupo 3
        diaList = new ArrayList<>();

        Dia desayuno2 = new Dia(false,false,false,false,false,false);
        diaList.add(desayuno2);
        Dia almuerzo2 = new Dia(false,false,false,false,false,false);
        diaList.add(almuerzo2);
        Dia comida2 = new Dia(false,false,false,false,false,false);
        diaList.add(comida2);
        Dia merienda2 = new Dia(false,false,false,false,false,false);
        diaList.add(merienda2);
        Dia cena2 = new Dia(false,false,false,false,false,false);
        diaList.add(cena2);


        Semana semana3 = new Semana(diaList);
        semanaList.add(semana3);
        seguimento.child("Semana3").child("Lunes").setValue(diaList.get(0));
        seguimento.child("Semana3").child("Martes").setValue(diaList.get(1));
        seguimento.child("Semana3").child("Miercoles").setValue(diaList.get(2));
        seguimento.child("Semana3").child("Jueves").setValue(diaList.get(3));
        seguimento.child("Semana3").child("Viernes").setValue(diaList.get(3));
        seguimento.child("Semana3").child("Sábado").setValue(diaList.get(3));
        seguimento.child("Semana3").child("Domingo").setValue(diaList.get(3));

        //Grupo 4
        diaList = new ArrayList<>();

        Dia desayuno3 = new Dia(false,false,false,false,false,false);
        diaList.add(desayuno3);
        Dia almuerzo3 = new Dia(false,false,false,false,false,false);
        diaList.add(almuerzo3);
        Dia comida3= new Dia(false,false,false,false,false,false);
        diaList.add(comida3);
        Dia merienda3 = new Dia(false,false,false,false,false,false);
        diaList.add(merienda3);
        Dia cena3 = new Dia(false,false,false,false,false,false);
        diaList.add(cena3);


        Semana semana4 = new Semana(diaList);
        semanaList.add(semana4);

        seguimento.child("Semana4").child("Lunes").setValue(diaList.get(0));
        seguimento.child("Semana4").child("Martes").setValue(diaList.get(1));
        seguimento.child("Semana4").child("Miercoles").setValue(diaList.get(2));
        seguimento.child("Semana4").child("Jueves").setValue(diaList.get(3));
        seguimento.child("Semana4").child("Viernes").setValue(diaList.get(3));
        seguimento.child("Semana4").child("Sábado").setValue(diaList.get(3));
        seguimento.child("Semana4").child("Domingo").setValue(diaList.get(3));

        return semanaList;
    }
    private void iniciarSesion(final String email, String pass){
        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()) {
                    String username = emailRegistro.split("@")[0];
                    usersRef.child(username).setValue(new Usuario(" ", " ", 0, " ", 0, 0));
                    Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                    intent.putExtra("user", username);
                    startActivity(intent);
                    Log.d("SESION", "Usuario creado correctamente");
                }else {
                    Log.d("SESION", task.getException().getMessage()+"");
                }
            }
        });
    }


}
