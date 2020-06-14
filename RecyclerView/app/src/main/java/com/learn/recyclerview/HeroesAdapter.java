package com.learn.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class HeroesAdapter extends RecyclerView.Adapter<HeroesAdapter.ListViewHolder> {

    private ArrayList<Heroes> listHero;
    //constructor
    public HeroesAdapter(ArrayList<Heroes> list) {
        this.listHero = list;
    }




    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_hero, parent, false);
       return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        Heroes heroes = listHero.get(position);
        Glide.with(holder.itemView.getContext())
                .load(heroes.getPhoto())
                .apply(new RequestOptions().override(55,55))
                .into(holder.imgItemPhoto);
        holder.tvItemName.setText(heroes.getName());
        holder.tvItemDetail.setText(heroes.getDetail());
    }

    @Override
    public int getItemCount() {
        return listHero.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgItemPhoto;
        TextView tvItemName, tvItemDetail;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);

            imgItemPhoto = itemView.findViewById(R.id.img_item_photo);
            tvItemName = itemView.findViewById(R.id.tv_item_name);
            tvItemDetail = itemView.findViewById(R.id.tv_item_detail);
        }
    }
}
