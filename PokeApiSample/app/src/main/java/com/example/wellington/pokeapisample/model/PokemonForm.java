package com.example.wellington.pokeapisample.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Wellington on 04/10/2016.
 */

public class PokemonForm {

    @SerializedName("sprites")
    @Expose
    public Sprites sprites;

}
