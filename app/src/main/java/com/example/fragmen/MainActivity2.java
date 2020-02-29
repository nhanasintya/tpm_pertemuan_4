package com.example.fragmen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity2 extends AppCompatActivity {

    private RecyclerView rvHero;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvHero = findViewById(R.id.activitymain_main_heroes);
        rvHero.setHasFixedSize(true);

        showRecyclerList();
    }

    private void showRecyclerList() {
        rvHero.setLayoutManager(new LinearLayoutManager(this));

        HeroesAdapter heroesAdapter = new HeroesAdapter(this);
        heroesAdapter.setHeroes(HeroesData.getHeroesList());

        rvHero.setAdapter(heroesAdapter);
    }
}
