package com.example.missuniverse;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class ListMissUniverseAdapter extends RecyclerView.Adapter<ListMissUniverseAdapter.CategoryViewHolder> {

    private Context context;

    public ListMissUniverseAdapter(Context context) {
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
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemRow = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_missuniverse, viewGroup, false);
        return new CategoryViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder categoryViewHolder, int position) {
        categoryViewHolder.tvName.setText(getListMissUniverse().get(position).getName());
        categoryViewHolder.tvRemarks.setText(getListMissUniverse().get(position).getRemarks());
        Glide.with(context)
                .load(getListMissUniverse().get(position).getPhoto())
                .apply(new RequestOptions().override(55, 55))
                .into(categoryViewHolder.imgPhoto);
    }

    @Override
    public int getItemCount() {
        return getListMissUniverse().size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvRemarks;
        ImageView imgPhoto;

        CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvRemarks = itemView.findViewById(R.id.tv_item_remarks);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
        }
    }
}

