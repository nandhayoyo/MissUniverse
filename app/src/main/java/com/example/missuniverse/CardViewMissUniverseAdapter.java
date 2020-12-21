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


public class CardViewMissUniverseAdapter extends RecyclerView.Adapter<CardViewMissUniverseAdapter.CardViewViewHolder> implements View.OnClickListener{
    private Context context;
    private ArrayList<MissUniverse> listMissUniverse;
    private ArrayList<MissUniverse> getListMissUniverse() {
        return listMissUniverse;
    }
    public void setListMissUniverse(ArrayList<MissUniverse> listMissUniverse) {
        this.listMissUniverse = listMissUniverse;
    }
    public CardViewMissUniverseAdapter(Context context) {
        this.context = context;
    }


    @NonNull
    @Override
    public CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_cardview_missuniverse, viewGroup, false);
        return new CardViewViewHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull final CardViewViewHolder cardViewViewHolder, final int i) {
        MissUniverse p = getListMissUniverse().get(i);
        Glide.with(context)
                .load(p.getPhoto())
                .apply(new RequestOptions().override(350, 550))
                .into(cardViewViewHolder.imgPhoto);
        cardViewViewHolder.tvName.setText(p.getName());
        cardViewViewHolder.tvRemarks.setText(p.getRemarks());
        cardViewViewHolder.btnFavorite.setOnClickListener(new CustomOnItemClickListener(i, new CustomOnItemClickListener.OnItemClickCallback() {
            @Override
            public void onItemClicked(View view, int position) {
                Toast.makeText(context, "Favorite "+getListMissUniverse().get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        }));
        cardViewViewHolder.btnShare.setOnClickListener(new CustomOnItemClickListener(i, new CustomOnItemClickListener.OnItemClickCallback() {
            @Override
            public void onItemClicked(View view, int position) {
                Toast.makeText(context, "Share "+getListMissUniverse().get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        }));

      /*   cardViewViewHolder.btnDetail.setOnClickListener(new CustomOnItemClickListener(i, new CustomOnItemClickListener.OnItemClickListener() {
           @Override
            void onItemClickListener(View view) {
                Intent moveIntent = new Intent (MissUniverse.this, DetailActivity.class);

                context.startActivities(new Intent[]{moveIntent});
            }
        })); */


    }

    @Override
    public int getItemCount() {
        return getListMissUniverse().size();
    }

    @Override
    public void onClick(View v) {


    }

    class CardViewViewHolder extends RecyclerView.ViewHolder{
        ImageView imgPhoto;
        TextView tvName, tvRemarks;
        Button btnFavorite, btnShare, btnDetail;
        CardViewViewHolder(View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvRemarks = itemView.findViewById(R.id.tv_item_remarks);
            btnFavorite = itemView.findViewById(R.id.btn_fav);
            btnShare = itemView.findViewById(R.id.btn_set_share);
        }
    }
}