package com.example.wellington.pokeapisample.presenter;

import android.os.Bundle;

import com.example.wellington.pokeapisample.model.Pokemon;
import com.example.wellington.pokeapisample.model.PokemonForm;
import com.example.wellington.pokeapisample.repository.CPokemonApi;
import com.example.wellington.pokeapisample.model.Result;
import com.example.wellington.pokeapisample.repository.listener.DetailsListener;
import com.example.wellington.pokeapisample.view.ui.DetailsActivity;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Wellington on 05/10/2016.
 */

public class DetailsPresenter {


    private CPokemonApi pokemonApi;

    public DetailsPresenter() {
        pokemonApi = new CPokemonApi();
    }

    public void loadPokemonDetails(Bundle bundle, final DetailsListener detailsListener) {
        final Result pokemonFromList = (Result) bundle.getSerializable(MainPresenter.POKEMON_FROM_LIST);

        detailsListener.onRequestStarted();

        pokemonApi.getmPokemonAPI()
                .getPokemon(pokemonFromList.name)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Pokemon>() {
                    @Override
                    public void onCompleted() {
                        detailsListener.onRequestFinished();
                    }

                    @Override
                    public void onError(Throwable e) {
                        detailsListener.onRequestFinished();
                        detailsListener.onApiError(e);
                    }

                    @Override
                    public void onNext(Pokemon pokemon) {
                       detailsListener.onLoadDetails(pokemon);
                    }
                });

        pokemonApi.getmPokemonAPI()
                .getPokemonForm(pokemonFromList.name)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PokemonForm>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        detailsListener.onApiError(e);

                    }

                    @Override
                    public void onNext(PokemonForm pokemonForm) {
                        detailsListener.onLoadSprite(pokemonForm.sprites.frontDefault);
                    }

                });

    }
}
