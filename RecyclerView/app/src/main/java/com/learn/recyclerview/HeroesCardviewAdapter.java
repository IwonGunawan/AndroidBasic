package com.learn.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

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
    public void onBindViewHolder(@NonNull cardviewViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class cardviewViewHolder extends RecyclerView.ViewHolder {
        public cardviewViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
