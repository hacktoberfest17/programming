package com.example.rishabh.everythingapp;

/**
 * Created by Rishabh on 10-06-2017.
 */

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.widget.TextView;

public class bottom_picture  extends Fragment {

    private static TextView topmemetext;
    private static TextView bottommemetext;


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //giving reference to layout file
        View view=inflater.inflate(R.layout.bottom_picture,container,false);
        topmemetext=(TextView)view.findViewById(R.id.textView4);
        bottommemetext=(TextView)view.findViewById(R.id.textView5);

        return view;
    }

    public void setMemeText(String top,String bottom){
        topmemetext.setText(top);
        bottommemetext.setText(bottom);
    }
}
