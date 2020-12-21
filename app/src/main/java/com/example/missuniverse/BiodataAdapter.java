/* package com.example.missuniverse;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class BiodataAdapter extends RecyclerView.Adapter<BiodataAdapter.BioViewHolder>{
    private Context context;

    public BiodataAdapter(Context context) {
        this.context = context;
    }

    private ArrayList<Biodata> listBiodata;

    public ArrayList<Biodata> getListBiodata() {
        return listBiodata;
    }

    public void setListBiodata(ArrayList<Biodata> listBiodata) {
        this.listBiodata = listBiodata;
    }

    @NonNull
    @Override
    public BioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int ViewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_biodata, parent, false);
        return new BiodataAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BioViewHolder holder, int position) {
        Glide.with(context)
                .load(getListBiodata().get(position).getPhoto())
                .apply(new RequestOptions().override(88, 88))
                .into(holder.imgPhoto);
    }

    @Override
    public int getItemCount() {
        return getListBiodata().size();
    }

    public class BioViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;

        public BioViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
        }
    }
} */
