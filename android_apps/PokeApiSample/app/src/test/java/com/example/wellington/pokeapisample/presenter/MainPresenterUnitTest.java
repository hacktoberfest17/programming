package com.example.wellington.pokeapisample.presenter;

import com.example.wellington.pokeapisample.model.PokemonList;
import com.example.wellington.pokeapisample.model.TestResponseEnum;
import com.example.wellington.pokeapisample.repository.listener.MainListener;

import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

/**
 * Created by Wellington on 18/10/2016.
 */

public class MainPresenterUnitTest extends BaseUnitTest{

    private final String TAG = MainPresenterUnitTest.class.getSimpleName();



    @Test
    public void mainPresenter_notNull() throws Exception{
        MainPresenter mainPresenter = new MainPresenter();
        assertNotNull(true);
        mainPresenter.loadPokemonList(0, new MainListener() {
            @Override
            public void onPokemonListLoad(PokemonList pokemonList) {
                    checkPokemonListTests(pokemonList);
            }



            @Override
            public void onApiError(Throwable e) {

            }

            @Override
            public void onRequestStarted() {

            }

            @Override
            public void onRequestFinished() {

            }

            @Override
            public void onError(Throwable error) {
                checkError(error);
            }
        });
    }

    private void checkPokemonListTests(PokemonList pokemonList) {
        assertFalse(pokemonList == null);
        super.printMessage(TAG, "mainPresenter_notNull", "pokemonList not null", TestResponseEnum.PASSED);

        int expectedMinimumItemsInList = 1;
        int channelInList = pokemonList.results.size();
        assertTrue(channelInList >= expectedMinimumItemsInList);
        super.printMessage(TAG, "mainPresenter_notNull", String.format("pokemon.results.size() > %d", expectedMinimumItemsInList), TestResponseEnum.PASSED);
    }

    private void checkError (Throwable error){
        super.printMessage(TAG, "mainPresenter_notNull", error.getMessage(), TestResponseEnum.FAILED);
        assertTrue(false);
    }

}
