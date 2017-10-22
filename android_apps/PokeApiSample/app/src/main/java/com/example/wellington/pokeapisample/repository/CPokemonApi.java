package com.example.wellington.pokeapisample.repository;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by Wellington on 05/10/2016.
 */

public class CPokemonApi {

    private static final String SERVER_URL = "http://pokeapi.co/api/v2/";
    PokemonApi mPokemonAPI;

    public CPokemonApi(){
        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(SERVER_URL)
                .build();

        mPokemonAPI = retrofit.create(PokemonApi.class);
    }

    public PokemonApi getmPokemonAPI(){
        return mPokemonAPI;
    }



}
