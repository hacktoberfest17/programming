package com.example.wellington.pokeapisample.view.ui.splashScreen;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.example.wellington.pokeapisample.BuildConfig;
import com.example.wellington.pokeapisample.R;
import com.example.wellington.pokeapisample.view.ui.login.Login;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class SplashScreen extends AppCompatActivity {

    @Bind(R.id.pokeApi)
    TextView textView;

    private static final int SPLASH_TIME_OUT = 10000;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash_screen);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        handler = new Handler();
        handler.postDelayed(myRunnable, SPLASH_TIME_OUT);

        changeToBeta();

    }

    Runnable myRunnable = new Runnable() {
        @Override
        public void run() {
            nextScreen();
        }
    };

    private void nextScreen() {

        handler.removeCallbacks(myRunnable);


        Intent i = new Intent(SplashScreen.this, Login.class);
        startActivity(i);

        finish();
    }

    @OnClick(R.id.splashScreen)
    public void screenClick() {
        nextScreen();
    }

    public void changeToBeta(){

        if (BuildConfig.IS_BETA) {
            textView.setText("POKEMON API SAMPLE BETA");
        } else {
            textView.setText("POKEMON API SAMPLE");
        }


    }



}
