package com.example.wellington.pokeapisample.repository.listener;

import com.example.wellington.pokeapisample.model.Pokemon;
import com.example.wellington.pokeapisample.model.PokemonForm;

/**
 * Created by Wellington on 17/10/2016.
 */

public interface DetailsListener extends BaseListener {

    void onLoadDetails(Pokemon pokemon);

    void onLoadSprite(String spriteUML);

    void onApiError(Throwable e);
}
