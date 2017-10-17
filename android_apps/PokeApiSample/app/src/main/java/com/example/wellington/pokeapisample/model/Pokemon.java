
package com.example.wellington.pokeapisample.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Pokemon implements Serializable {

    @SerializedName("forms")
    @Expose
    public List<Form> forms = new ArrayList<Form>();
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("height")
    @Expose
    public Integer height;
    @SerializedName("sprites")
    @Expose
    public Sprites sprites;
    @SerializedName("is_default")
    @Expose
    public Boolean isDefault;
    @SerializedName("species")
    @Expose
    public Species species;
    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("types")
    @Expose
    public List<Type> types = new ArrayList<Type>();



}
