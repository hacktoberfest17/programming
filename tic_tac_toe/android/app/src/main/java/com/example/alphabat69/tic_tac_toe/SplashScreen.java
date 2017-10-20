package com.example.alphabat69.tic_tac_toe;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

public class SplashScreen extends AppCompatActivity {
    private ImageView imageView;
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        imageView=(ImageView)findViewById(R.id.imageView);
        progressBar=(ProgressBar)findViewById(R.id.progressBar);
        final Handler handler=new Handler();
        handler.postDelayed(new Runnable(){
            @Override
            public void run(){
                imageView.setVisibility(View.VISIBLE);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        progressBar.setVisibility(View.VISIBLE);
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                startActivity(new Intent(SplashScreen.this,Activity1.class));
                                finish();
                            }
                        }, 500);
                    }
                },500);
            }
        },1000);
    }
}
