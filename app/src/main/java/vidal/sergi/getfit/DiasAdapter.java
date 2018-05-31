package vidal.sergi.getfit;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

import vidal.sergi.getfit.Objetos.DiasSemana;
import vidal.sergi.getfit.Objetos.FirebaseReferences;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import vidal.sergi.getfit.Objetos.Dieta;
import vidal.sergi.getfit.Objetos.Seguimiento;

public class DiasAdapter extends RecyclerView.Adapter<DiasAdapter.ViewHolder>  {
    private static final String TAG ="RecyclerViewAdapter";
    Intent intent;

    private ArrayList<String> mImageNames = new ArrayList<>();
    private ArrayList<String> mImages = new ArrayList<>();
    private Context mcontext;
    public String intento;

    public DiasAdapter(Context mcontext, String intento) {
        this.mcontext = mcontext;
        this.intento = intento;
    }

    public DiasAdapter() {
    }

    public DiasAdapter(ArrayList<String> mImageNames, ArrayList<String> mImages, Context mcontext, String intento) {
        this.mImageNames = mImageNames;
        this.mImages = mImages;
        this.mcontext = mcontext;
        this.intento = intento;
    }

    public String getIntento() {
        return intento;
    }

    public void setIntento(String intento) {
        this.intento = intento;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent. getContext()).inflate(R.layout.layout_listitem,parent,false);
        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called");
        Glide.with(mcontext).asBitmap().load(mImages.get(position)).into(holder.image);
        holder.imageName.setText(mImageNames.get(position));
        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: clicked on: "+ mImageNames.get(position));
                Toast.makeText(mcontext,mImageNames.get(position),Toast.LENGTH_SHORT).show();
                Log.d(TAG, "onClick: AAAAAAAAAAAAA"+getIntento().toString());

                switch (position){
                    case 0: intent = new Intent(mcontext,LunesActivity.class); intent.putExtra("c",getIntento().toString());intent.putExtra("d",mImageNames.get(position)); mcontext.startActivity(intent);break;
                    case 1: intent = new Intent(mcontext,LunesActivity.class); intent.putExtra("c",getIntento().toString()); intent.putExtra("d",mImageNames.get(position));mcontext.startActivity(intent);break;
                    case 2: intent = new Intent(mcontext,LunesActivity.class); intent.putExtra("c",getIntento().toString());intent.putExtra("d",mImageNames.get(position));mcontext.startActivity(intent);break;
                    case 3: intent = new Intent(mcontext,LunesActivity.class); intent.putExtra("c",getIntento().toString());intent.putExtra("d",mImageNames.get(position));mcontext.startActivity(intent);break;
                    case 4: intent = new Intent(mcontext,LunesActivity.class); intent.putExtra("c",getIntento().toString());intent.putExtra("d",mImageNames.get(position));mcontext.startActivity(intent);break;
                    case 5: intent = new Intent(mcontext,LunesActivity.class); intent.putExtra("c",getIntento().toString()); intent.putExtra("d",mImageNames.get(position));mcontext.startActivity(intent);break;
                    case 6: intent = new Intent(mcontext,LunesActivity.class); intent.putExtra("c",getIntento().toString()); intent.putExtra("d",mImageNames.get(position));mcontext.startActivity(intent);break;

                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return mImageNames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        CircleImageView image;
        TextView imageName;
        RelativeLayout parentLayout;
        public ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            imageName = itemView.findViewById(R.id.image_name);
            parentLayout = itemView.findViewById(R.id.parent_layout);
        }
    }
}
