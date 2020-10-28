package com.example.knightcube;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button option1, option2, option3, option4, reset;
    TextView score;
    ImageView animalImage;
    private Handler handler;
    int copy;
    int points = 0;
    int animalImages[] =
            {
                    R.drawable.tame_animals_bird,
                    R.drawable.tame_animals_cat,
                    R.drawable.tame_animals_dolphin,
                    R.drawable.tame_animals_fish,
                    R.drawable.tame_animals_flappy_bird,
                    R.drawable.tame_animals_goat,
                    R.drawable.tame_animals_horse,
                    R.drawable.tame_animals_peacock,
                    R.drawable.tame_animals_rabbit,
                    R.drawable.tame_animals_penguin,
                    R.drawable.tame_animals_sheep,
                    R.drawable.wild_animals_bear,
                    R.drawable.wild_animals_crocodile,
                    R.drawable.wild_animals_dog,
                    R.drawable.wild_animals_eagle,
                    R.drawable.wild_animals_elephant,
                    R.drawable.wild_animals_fox,
                    R.drawable.wild_animals_leopard,
                    R.drawable.wild_animals_lion,
                    R.drawable.wild_animals_mouse,
                    R.drawable.wild_animals_pink_panther,
                    R.drawable.wild_animals_shark,
                    R.drawable.wild_animals_snake,
                    R.drawable.wild_animals_tiger


            };

    String animalNames[] = new String[]
            {

                    "Bird",
                    "Cat",
                    "Dolphin",
                    "Fish",
                    "Flappy_Bird",
                    "Goat",
                    "Horse",
                    "Peacock",
                    "Rabbit",
                    "Penguin",
                    "Sheep",
                    "Bear",
                    "Crocodile",
                    "Dog",
                    "Eagle",
                    "Elephant",
                    "Fox",
                    "Leopard",
                    "Lion",
                    "Mouse",
                    "Pink_Panther",
                    "Shark",
                    "Snake",
                    "Tiger"

            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        handler = new Handler();
        option1 = (Button) findViewById(R.id.option1);
        option2 = (Button) findViewById(R.id.option2);
        option3 = (Button) findViewById(R.id.option3);
        option4 = (Button) findViewById(R.id.option4);
        reset = (Button) findViewById(R.id.reset);
        score = (TextView) findViewById(R.id.score);
        animalImage = (ImageView) findViewById(R.id.imageView);
        generateOptions();
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int points = 0;
                score.setText(Integer.toString(points));
                generateOptions();
            }
        });

    }

    private void generateOptions() {

        int numberOfAnimals = animalImages.length;
        Random random = new Random();
        int answer = random.nextInt(numberOfAnimals);
        copy = answer;
        animalImage.setImageResource(animalImages[answer]);
        ArrayList<String> answers = new ArrayList<String>();
        answers.add(animalNames[answer]);

        int x = random.nextInt(numberOfAnimals);


        while (answers.size() < 4) {

            if (x != answer && !answers.contains(animalNames[x])) {
                answers.add(animalNames[x]);

            }

            x = random.nextInt(numberOfAnimals);
        }

        //Shuffle the answers
        Collections.shuffle(answers);
        option1.setText(answers.get(0).toString());
        option2.setText(answers.get(1).toString());
        option3.setText(answers.get(2).toString());
        option4.setText(answers.get(3).toString());

        answers.clear();

        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                verify(option1.getText().toString());

            }
        });

        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                verify(option2.getText().toString());
            }
        });


        option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                verify(option3.getText().toString());

            }
        });


        option4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                verify(option4.getText().toString());

            }
        });

    }

    private void verify(String s) {
        if (s.compareTo(animalNames[copy].toString()) == 0) {
            Toast.makeText(getApplicationContext(), "Correct!!", Toast.LENGTH_SHORT).show();
            points += 10;
            score.setText("Your Score: " + Integer.toString(points));
            generateOptions();
        } else {
            Toast.makeText(getApplicationContext(), "Wrong!!Try Again", Toast.LENGTH_SHORT).show();
        }
    }

}
