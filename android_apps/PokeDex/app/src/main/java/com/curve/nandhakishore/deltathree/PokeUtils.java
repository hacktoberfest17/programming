package com.curve.nandhakishore.deltathree;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Log;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.net.URL;
import java.util.ArrayList;


public class PokeUtils {

    public static boolean found;

    public static int id;

    public static ArrayList<historyItem> search_history;

    public static String pokeUrl;

    public static String TAG = "Pokedex";

    public static boolean searchPoke(String url, String pokeName) {
        found = false;
        HttpHandler sh = new HttpHandler();
        String jsonStr = sh.makeServiceCall(url);
        if (jsonStr != null) {
            try {
                JSONObject jsonObj = new JSONObject(jsonStr);
                JSONArray pokeList = jsonObj.getJSONArray("results");
                for (int i = 0; i < pokeList.length(); i++) {
                    JSONObject c = pokeList.getJSONObject(i);

                    if (pokeName.equalsIgnoreCase(c.getString("name"))) {
                        pokeUrl = c.getString("url");
                        Log.e(TAG, "Pokemon found at index " + String.valueOf(i));
                        found = true;
                        return found;
                    }
                }
                if(!found && !TextUtils.isEmpty(jsonObj.getString("next"))){
                    return found = searchPoke(jsonObj.getString("next"), pokeName);
                }
            } catch (final JSONException e) {
                Log.e(TAG, "Json parsing error: " + e.getMessage());
            }
        }
        return found;
    }

    public static Pokemon getPokeInfo(Context context) {
        Pokemon target = new Pokemon();
        HttpHandler sh = new HttpHandler();
        String pokeJSON = sh.makeServiceCall(pokeUrl);
        if (pokeJSON != null)
        try {

            JSONObject pokemon = new JSONObject(pokeJSON);

            //sprite
            JSONObject sprites = pokemon.getJSONObject("sprites");
            try {
                target.sprite = new URL(sprites.getString("front_default"));
            }catch (Exception e){
                e.printStackTrace();
            }

            //abilities
            JSONArray abilities = pokemon.getJSONArray("abilities");
            for (int i = 0; i < abilities.length(); i++) {
                JSONObject ob = abilities.getJSONObject(i);
                JSONObject ability = ob.getJSONObject("ability");
                target.abilities.add(ability.getString("name"));
            }

            //types
            JSONArray types = pokemon.getJSONArray("types");
            for (int i = types.length() - 1; i > -1; i--) {
                JSONObject ob = types.getJSONObject(i);
                JSONObject type = ob.getJSONObject("type");
                target.types.add(type.getString("name"));
            }

            //stats
            target.name = pokemon.getString("name");
            target.weight = pokemon.getInt("weight");
            target.height = pokemon.getInt("height");
            target.experience = pokemon.getInt("base_experience");
            JSONArray stats = pokemon.getJSONArray("stats");
            for (int i = 0; i < stats.length(); i++) {
                JSONObject ob = stats.getJSONObject(i);
                JSONObject stat = ob.getJSONObject("stat");
                switch (stat.getString("name")) {
                    case "speed": target.speed = ob.getInt("base_stat");
                        break;
                    case "attack": target.attack = ob.getInt("base_stat");
                        break;
                    case "defense": target.defense = ob.getInt("base_stat");
                        break;
                    case "hp": target.hp = ob.getInt("base_stat");
                        break;
                    default: break;
                }
            }
        }catch (JSONException e){
            e.printStackTrace();
        }
        return target;
    }

}
