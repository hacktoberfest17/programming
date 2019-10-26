package com.curve.nandhakishore.deltathree;

import android.graphics.Bitmap;

import java.net.URL;
import java.util.ArrayList;

/**
 * Created by Nandha Kishore on 02-07-2017.
 */
public class Pokemon {

    public ArrayList<String> abilities, types;
    public int speed, defense, attack, hp;
    public String name;
    public int weight, height;
    public URL sprite;
    public int experience;

    public Pokemon() {
        abilities = new ArrayList<>();
        types = new ArrayList<>();
    }
}
