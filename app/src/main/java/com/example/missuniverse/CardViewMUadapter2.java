package com.example.missuniverse;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class CardViewMUadapter2 extends RecyclerView.Adapter<com.example.missuniverse.CardViewMUadapter2.CardView2ViewHolder>  {
    private Context context;

    public CardViewMUadapter2(Context context) {
        this.context = context;
    }

    private ArrayList<MissUniverse> listMissUniverse;

    public ArrayList<MissUniverse> getListMissUniverse() {
        return listMissUniverse;
    }

    public void setListMissUniverse(ArrayList<MissUniverse> listMissUniverse) {
        this.listMissUniverse = listMissUniverse;
    }

    @NonNull
    @Override
    public CardViewMUadapter2.CardView2ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_biodata_missuniverse, viewGroup, false);
        return new CardViewMUadapter2.CardView2ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewMUadapter2.CardView2ViewHolder holder, int position) {
        Glide.with(context)
                .load(getListMissUniverse().get(position).getPhoto())
                .apply(new RequestOptions().override(350, 550))
                .into(holder.imgPhoto);

    }

    @Override
    public int getItemCount() {
        return getListMissUniverse().size();
    }

    public class CardView2ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;

        public CardView2ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);        }
    }
}


