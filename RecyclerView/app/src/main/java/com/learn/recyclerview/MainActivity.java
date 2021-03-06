package com.learn.recyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvHeroes;
    private ArrayList<Heroes> list = new ArrayList<>();
    private String title = "List";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvHeroes = findViewById(R.id.rv_heroes);
        rvHeroes.setHasFixedSize(true);

        list.addAll(HeroesData.getListData());
        showRecyclerList();
        setTitleBar(title);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    private void setMode(int itemId) {
        switch (itemId){
            case R.id.action_list:
                showRecyclerList();
                title = "List";
                break;
            case R.id.action_grid:
                showRecyclerGrid();
                title = "Grid";
                break;
            case R.id.action_cardview:
                showRecyclerCardview();
                title = "Cardview";
                break;
        }
        setTitleBar(title);
    }

    private void showRecyclerList() {
        rvHeroes.setLayoutManager(new LinearLayoutManager(this));
        HeroesAdapter heroesAdapter = new HeroesAdapter(list);
        rvHeroes.setAdapter(heroesAdapter);
    }

    private void showRecyclerGrid() {
        rvHeroes.setLayoutManager(new GridLayoutManager(this, 2));
        HeroesGridAdapter heroesGridAdapter = new HeroesGridAdapter(list);
        rvHeroes.setAdapter(heroesGridAdapter);
    }

    private void showRecyclerCardview() {
        rvHeroes.setLayoutManager(new LinearLayoutManager(this));
        HeroesCardviewAdapter heroesCardviewAdapter = new HeroesCardviewAdapter(list);
        rvHeroes.setAdapter(heroesCardviewAdapter);
    }

    private void setTitleBar(String title) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }
}
