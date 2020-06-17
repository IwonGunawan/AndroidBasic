package com.learn.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class HeroesCardviewAdapter extends RecyclerView.Adapter<HeroesCardviewAdapter.cardviewViewHolder> {

    private ArrayList<Heroes> listHero;

    public HeroesCardviewAdapter(ArrayList<Heroes> list) {
        this.listHero = list;
    }



    @NonNull
    @Override
    public cardviewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cardview_hero, parent, false);
        return new cardviewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final cardviewViewHolder holder, int position) {
        final Heroes heroes = listHero.get(position);

        Glide.with(holder.itemView.getContext())
                .load(heroes.getPhoto())
                .apply(new RequestOptions().override(350, 550))
                .into(holder.imgPhoto);
        holder.tvName.setText(heroes.getName());
        holder.tvDetail.setText(heroes.getDetail());

        holder.btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(holder.itemView.getContext(),
                        "share " + listHero.get(holder.getAdapterPosition()).getName(),
                        Toast.LENGTH_SHORT).show();
            }
        });

        holder.btnFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(holder.itemView.getContext(),
                        "favorite " + heroes.getName(),
                        Toast.LENGTH_SHORT).show();
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(holder.itemView.getContext(),
                        "anda memilih " + heroes.getName(),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return listHero.size();
    }

    public class cardviewViewHolder extends RecyclerView.ViewHolder {

        ImageView imgPhoto;
        TextView tvName, tvDetail;
        Button btnShare, btnFavorite;


        public cardviewViewHolder(@NonNull View itemView) {
            super(itemView);

            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvDetail = itemView.findViewById(R.id.tv_item_detail);
            btnShare = itemView.findViewById(R.id.btn_share);
            btnFavorite = itemView.findViewById(R.id.btn_favorite);

        }
    }
}
