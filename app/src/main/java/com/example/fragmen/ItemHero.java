package com.example.fragmen;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class ItemHero extends Fragment {
    private RecyclerView rvHero;

    public ItemHero() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_main2, container, false);
        rvHero = view.findViewById(R.id.activitymain_main_heroes);
        rvHero.setHasFixedSize(true);
        rvHero.setLayoutManager(new LinearLayoutManager(view.getContext()));
        HeroesAdapter heroesAdapter = new HeroesAdapter(view.getContext());
        heroesAdapter.setHeroes(HeroesData.getHeroesList());
        rvHero.setAdapter(heroesAdapter);
        return  view;
    }

}
