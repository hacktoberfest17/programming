
package com.example.wellington.pokeapisample.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PokemonList implements Serializable {

    @SerializedName("count")
    @Expose
    public Integer count;
    @SerializedName("previous")
    @Expose
    public Object previous;
    @SerializedName("results")
    @Expose
    public List<Result> results = new ArrayList<Result>();
    @SerializedName("next")
    @Expose
    public String next;

}
