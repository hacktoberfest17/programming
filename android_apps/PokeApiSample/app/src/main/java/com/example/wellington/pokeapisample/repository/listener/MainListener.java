package com.example.wellington.pokeapisample.repository.listener;

import com.example.wellington.pokeapisample.model.PokemonList;

/**
 * Created by Wellington on 17/10/2016.
 */

public interface MainListener extends BaseListener {

    void onPokemonListLoad(PokemonList pokemonList);

    void onApiError(Throwable e);

}
