package com.example.fragmen;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class HeroesAdapter extends RecyclerView.
        Adapter<HeroesAdapter.ViewHolder> {

    private Context context;

    public HeroesAdapter(Context context) {
        this.context = context;
    }

    private ArrayList<Heroes> heroes;

    public ArrayList<Heroes> getHeroes() {
        return heroes;
    }

    public void setHeroes(ArrayList<Heroes> heroes) {
        this.heroes = heroes;
    }

    @NonNull
    @Override
    public HeroesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_hero, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HeroesAdapter.ViewHolder holder, final int position) {

        holder.tvName.setText(getHeroes().get(position).getHeroName());
        holder.tvDetail.setText(getHeroes().get(position).getHeroDetail());
        Glide.with(context).load(getHeroes().get(position).getImage()).into(holder.ivHero);

        holder.btn_detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent movedata = new Intent(context, Detail.class);
                movedata.putExtra("nama", getHeroes().get(position).getHeroName());
                movedata.putExtra("image", getHeroes().get(position).getImage());
                movedata.putExtra("desc", getHeroes().get(position).getHeroDetail());
                context.startActivity(movedata);
            }
        });
    }

    @Override
    public int getItemCount() {
        return heroes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivHero;
        TextView tvName, tvDetail;
        Button btn_detail;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ivHero = itemView.findViewById(R.id.itemhero_iv);
            tvName = itemView.findViewById(R.id.itemhero_tv_nama);
            tvDetail = itemView.findViewById(R.id.itemhero_tv_deskripsi);
            btn_detail = itemView.findViewById(R.id.btn_detail);

        }
    }
}

