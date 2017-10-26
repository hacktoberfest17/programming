package com.example.wellington.pokeapisample.presenter;

import com.example.wellington.pokeapisample.model.PokemonList;
import com.example.wellington.pokeapisample.repository.CPokemonApi;
import com.example.wellington.pokeapisample.repository.listener.MainListener;
import com.example.wellington.pokeapisample.view.ui.MainActivity;

import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Wellington on 05/10/2016.
 */
public class MainPresenter {

    public static final String POKEMON_FROM_LIST = "PokemonFromList";

    private CPokemonApi pokemonApi;

    public MainPresenter() {
           pokemonApi = new CPokemonApi();
    }

    public void loadPokemonList(int offset, final MainListener listener) {
        listener.onRequestStarted();

        Subscription subscribe = pokemonApi.getmPokemonAPI()
                .getPokemonList(offset)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PokemonList>() {
                    @Override
                    public void onCompleted() {
                        listener.onRequestFinished();
                    }

                    @Override
                    public void onError(Throwable e) {
                        listener.onRequestFinished();
                        listener.onApiError(e);
                    }

                    @Override
                    public void onNext(PokemonList pokemonList) {
                        listener.onPokemonListLoad(pokemonList);
                    }
                });


    }
}
