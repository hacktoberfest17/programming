
package com.example.wellington.pokeapisample.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Species implements Serializable{

    @SerializedName("url")
    @Expose
    public String url;
    @SerializedName("name")
    @Expose
    public String name;

}
