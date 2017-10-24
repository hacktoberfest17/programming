package com.curve.nandhakishore.deltathree;

import java.net.URL;

/**
 * Created by Nandha Kishore on 03-07-2017.
 */

public class historyItem {

    public int place;
    public URL image;
    public String name;

    public historyItem(int p, URL bmp, String n) {
        image = bmp;
        name = n;
        place = p;
    }

}
