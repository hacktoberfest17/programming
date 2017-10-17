
package com.example.wellington.pokeapisample.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Type implements Serializable {

    @SerializedName("slot")
    @Expose
    public Integer slot;
    @SerializedName("type")
    @Expose
    public Type_ type;

}
