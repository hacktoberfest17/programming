package com.example.rishabh.everythingapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

// fragments are separate parts of the same activity
// we created separated layout file and their corresponding java files

public class Fragments extends AppCompatActivity implements top_section_fragment.TopSectionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragments);
    }

    //gets called when user clicks the button
    @Override
    public void createMeme(String top, String bottom) {
        bottom_picture bottom_picture=(bottom_picture)getSupportFragmentManager().findFragmentById(R.id.fragment2);
        bottom_picture.setMemeText(top, bottom);

    }
}
