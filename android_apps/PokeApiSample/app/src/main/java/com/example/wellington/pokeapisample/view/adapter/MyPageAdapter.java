package com.example.wellington.pokeapisample.view.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;

import com.example.wellington.pokeapisample.model.Pokemon;
import com.example.wellington.pokeapisample.view.ui.fragment.TypeFrangment;
import com.example.wellington.pokeapisample.view.ui.fragment.SpritesFragment;

/**
 * Created by Wellington on 10/10/2016.
 */

public class MyPageAdapter extends FragmentStatePagerAdapter {

    Pokemon pokemon;

    public MyPageAdapter(FragmentManager fm, Pokemon mPokemon) {
        super(fm);
        this.pokemon = mPokemon;
    }

    @Override
    public Fragment getItem(int position) {
       Fragment fragment;

        Bundle bundle = new Bundle();

        switch (position){
            case 0: fragment = new TypeFrangment();
                bundle.putSerializable(TypeFrangment.TIPO, this.pokemon);
                break;
            case 1: fragment = new SpritesFragment();
                bundle.putString(SpritesFragment.SPRITE, this.pokemon.sprites.frontShiny);
                break;
            default: fragment = new Fragment();
            }

        fragment.setArguments(bundle);

        return fragment;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public int getItemPosition(Object object) {
    return PagerAdapter.POSITION_NONE;
    }
}
