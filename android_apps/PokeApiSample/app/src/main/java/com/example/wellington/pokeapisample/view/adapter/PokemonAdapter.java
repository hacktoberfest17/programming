package com.example.wellington.pokeapisample.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.wellington.pokeapisample.R;
import com.example.wellington.pokeapisample.model.Pokemon;
import com.example.wellington.pokeapisample.model.PokemonList;
import com.example.wellington.pokeapisample.model.Result;

import java.util.ArrayList;
import java.util.List;

/**
 * Adapter for PokemonList
 */
public class PokemonAdapter extends RecyclerView.Adapter<PokemonAdapter.PokemonAdapterViewHolder> {

    public List<Result> mPokemonList;
    private final OnPokemonClickListener listener;

    public interface OnPokemonClickListener {
        void onPokemonClick(Result pokemonFromList);
    }

    /**
     *
     * @param pokemonList - List of Pokemon read from API
     * @param listener - Event for Row Click on RecyclerView
     */
    public PokemonAdapter(List<Result> pokemonList, OnPokemonClickListener listener) {
        this.mPokemonList = pokemonList;
        this.listener = listener;
    }

    @Override
    public PokemonAdapter.PokemonAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pokemon_list_item, parent, false);

        return new PokemonAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PokemonAdapter.PokemonAdapterViewHolder holder, int position) {
        Result item = mPokemonList.get(position);

        holder.tvPokemonItem.setText(item.name);
        holder.bind(mPokemonList.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return this.mPokemonList.size();
    }


    public void addAll(List<Result> newPokemonList) {
        if (this.mPokemonList == null) {
            this.mPokemonList = newPokemonList;
        } else {
            this.mPokemonList.addAll(newPokemonList);
        }
    }

    public static class PokemonAdapterViewHolder extends RecyclerView.ViewHolder {
        public TextView tvPokemonItem;

        public PokemonAdapterViewHolder(View itemView) {
            super(itemView);

            this.tvPokemonItem = (TextView) itemView.findViewById(R.id.pokemon);
        }

        public void bind(final Result pokemonListItem, final OnPokemonClickListener listener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onPokemonClick(pokemonListItem);
                }
            });
        }
    }
}
