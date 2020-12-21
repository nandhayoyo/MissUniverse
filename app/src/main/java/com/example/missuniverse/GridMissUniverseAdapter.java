package com.example.missuniverse;

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

public class GridMissUniverseAdapter extends RecyclerView.Adapter<GridMissUniverseAdapter.GridViewHolder> {

    private Context context;

    public GridMissUniverseAdapter(Context context) {
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
    public GridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grid_missuniverse, parent, false);
        return new GridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GridViewHolder holder, int position) {
        Glide.with(context)
                .load(getListMissUniverse().get(position).getPhoto())
                .apply(new RequestOptions().override(350, 550))
                .into(holder.imgPhoto);
    }

    @Override
    public int getItemCount() {
        return getListMissUniverse().size();
    }

    public class GridViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;

        GridViewHolder(View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
        }
    }
}
