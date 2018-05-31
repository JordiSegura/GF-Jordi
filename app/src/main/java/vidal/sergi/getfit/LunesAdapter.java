package vidal.sergi.getfit;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class LunesAdapter extends RecyclerView.Adapter<LunesAdapter.LunesViewHolder> {
    public static final String TAG = "LunesAdapter";
    FirebaseDatabase mFirebaseDatabase;
    DatabaseReference myRef;
    private Context mcontext;
    boolean c1 = false;
    boolean c2 = false;
    boolean c3 = false;
    boolean c4 = false;
    boolean c5 = false;
    boolean c6 = false;


    List<String> actividades;
    public String valor;
    public String dia;

    public LunesAdapter(List<String> actividades, String valor, String dia) {
        this.actividades = actividades;
        this.valor = valor;
        this.dia = dia;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }


    public LunesAdapter(List<String> actividades) {
        this.actividades = actividades;
    }

    public LunesAdapter(Context mcontext, List<String> actividades) {
        this.mcontext = mcontext;
        this.actividades = actividades;
    }
    public static class LunesViewHolder extends RecyclerView.ViewHolder{
        TextView txt_lunes;
        CheckBox cb;
         FirebaseDatabase mFirebaseDatabase;
         DatabaseReference myRef;
        public LunesViewHolder(View itemView) {
            super(itemView);
            txt_lunes = itemView.findViewById(R.id.textview_lunes3);
            cb = itemView.findViewById(R.id.checkbox);

        }
    }

    @NonNull
    @Override
    public LunesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_recycler_lunes,parent,false);
        return new LunesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final LunesViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: GETTER "+getDia());
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        myRef = mFirebaseDatabase.getReference().child("Seguimiento/"+getValor()+"/"+getDia());
        holder.cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                switch (position){
                    case 0:
                        if (isChecked){
                              myRef.child("almuerzo").setValue(true);
                            Log.d(TAG, "onCheckedChanged: CB1 Está chekeado");
                        }else{
                            myRef.child("almuerzo").setValue(false);

                            c1 = false;
                            Log.d(TAG, "onCheckedChanged: CB1 No está checkeado");
                        }
                        Log.d(TAG, "onCheckedChanged: CHECKBOX0");break;
                    case 1:
                        if (isChecked){
                            myRef.child("cena").setValue(true);
                            Log.d(TAG, "onCheckedChanged: CB1Está chekeado");
                        }else{
                            myRef.child("cena").setValue(false);
                            Log.d(TAG, "onCheckedChanged: CB1 No está checkeado");
                        }
                        Log.d(TAG, "onCheckedChanged: CHECKBOX1");break;
                    case 2:
                        if (isChecked){
                            myRef.child("comida").setValue(true);
                            Log.d(TAG, "onCheckedChanged: CB1Está chekeado");
                        }else{
                            myRef.child("comida").setValue(false);
                            Log.d(TAG, "onCheckedChanged: CB1 No está checkeado");
                        }
                        Log.d(TAG, "onCheckedChanged: CHECKBOX2");break;
                    case 3:
                        if (isChecked){
                            myRef.child("desayuno").setValue(true);
                            Log.d(TAG, "onCheckedChanged: CB1Está chekeado");
                        }else{
                            myRef.child("desayuno").setValue(false);
                            Log.d(TAG, "onCheckedChanged: CB1 No está checkeado");
                        }
                        Log.d(TAG, "onCheckedChanged: CHECKBOX3");break;
                    case 4:
                        if (isChecked){
                            myRef.child("merienda").setValue(true);
                            Log.d(TAG, "onCheckedChanged: CB1Está chekeado");
                        }else{
                            myRef.child("merienda").setValue(false);
                            Log.d(TAG, "onCheckedChanged: CB1 No está checkeado");
                        }
                        Log.d(TAG, "onCheckedChanged: CHECKBOX4");break;
                    case 5:
                        if (isChecked){
                            myRef.child("rutina").setValue(true);
                            Log.d(TAG, "onCheckedChanged: CB1Está chekeado");
                        }else{
                            myRef.child("rutina").setValue(false);
                            Log.d(TAG, "onCheckedChanged: CB1 No está checkeado");
                        }
                        Log.d(TAG, "onCheckedChanged: CHECKBOX5");break;


                }
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (position) {
                    case 0:
                      /*  Intent intent = new Intent(mcontext,LunesActivity.class);
                        mcontext.startActivity(intent);*/

                        Log.d(TAG, "onClick: Pos0");
                        break;

                    case 1:
                        Log.d(TAG, "onClick: Pos1");
                        break;
                    case 2:
                        Log.d(TAG, "onClick: Pos2");
                        break;
                    case 3:
                        Log.d(TAG, "onClick: Pos3");
                        break;
                    case 4:
                        Log.d(TAG, "onClick: Pos4");
                        break;
                    case 5:
                        Log.d(TAG, "onClick: Pos5");
                        break;

                }
            }
        });
        holder.txt_lunes.setText(actividades.get(position));

    }

    @Override
    public int getItemCount() {
        return actividades.size();
    }




}
