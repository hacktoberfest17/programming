package com.example.wellington.pokeapisample.repository;

import com.example.wellington.pokeapisample.model.Pokemon;
import com.example.wellington.pokeapisample.model.PokemonForm;
import com.example.wellington.pokeapisample.model.PokemonList;


import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Wellington on 04/10/2016.
 */

public interface PokemonApi {

    @GET("pokemon/")
    Observable<PokemonList> getPokemonList(@Query("offset") int offset);

    @GET("pokemon/{name}/")
    Observable<Pokemon> getPokemon(@Path("name") String name);

    @GET("pokemon-form/{name}/")
    Observable<PokemonForm> getPokemonForm(@Path("name") String name);

}
