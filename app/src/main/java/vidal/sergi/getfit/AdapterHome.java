package vidal.sergi.getfit;

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

public class AdapterHome extends RecyclerView.Adapter<AdapterHome.ViewHolder>  {
    private static final String TAG ="RecyclerViewAdapter";
    Intent intent;

    private ArrayList<String> mImageNames = new ArrayList<>();
    private ArrayList<String> mImages = new ArrayList<>();
    private Context mcontext;

    public AdapterHome(ArrayList<String> mImageNames, ArrayList<String> mImages, Context context) {
        this.mImageNames = mImageNames;
        this.mImages = mImages;
        this.mcontext = context;
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
                switch (position){
                    case 0:
                        Intent intent = new Intent(mcontext,DiasActivity.class);
                        intent.putExtra("semana1", mImageNames.get(position));
                        mcontext.startActivity(intent);
                        Log.d(TAG, "onClick: Corresponde a Semana1");
                    case 1:
                        Intent intent2 = new Intent(mcontext,DiasActivity.class);
                        intent2.putExtra("semana1", mImageNames.get(position));
                        mcontext.startActivity(intent2);
                        Log.d(TAG, "onClick: Corresponde a Semana2");

                    case 2:
                        Intent intent3 = new Intent(mcontext,DiasActivity.class);
                        intent3.putExtra("semana1", mImageNames.get(position));
                        mcontext.startActivity(intent3);
                        Log.d(TAG, "onClick: Corresponde a Semana3");

                    case 3:
                        Intent intent4 = new Intent(mcontext,DiasActivity.class);
                        intent4.putExtra("semana1", mImageNames.get(position));
                        mcontext.startActivity(intent4);
                        Log.d(TAG, "onClick: Corresponde a Semana4");



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
