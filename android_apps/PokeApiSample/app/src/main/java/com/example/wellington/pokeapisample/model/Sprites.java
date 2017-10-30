
package com.example.wellington.pokeapisample.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Sprites implements Serializable{

    @SerializedName("back_female")
    @Expose
    public Object backFemale;
    @SerializedName("back_shiny_female")
    @Expose
    public Object backShinyFemale;
    @SerializedName("back_default")
    @Expose
    public String backDefault;
    @SerializedName("front_female")
    @Expose
    public Object frontFemale;
    @SerializedName("front_shiny_female")
    @Expose
    public Object frontShinyFemale;
    @SerializedName("back_shiny")
    @Expose
    public String backShiny;
    @SerializedName("front_default")
    @Expose
    public String frontDefault;
    @SerializedName("front_shiny")
    @Expose
    public String frontShiny;

}
