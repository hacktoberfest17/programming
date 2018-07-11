package com.example.anurag.app_37galleryandscrollview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView imgAnimal;
    LinearLayout linearLayoutHorizontal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        linearLayoutHorizontal=(LinearLayout)findViewById(R.id.linearLayoutHorizontal);
        imgAnimal=(ImageView)findViewById(R.id.imageView);

        for(int index=0;index<Balloons.balloonImages.length;index++) {

            final int i = index;
            ImageView imageView=new ImageView(MainActivity.this);
            imageView.setImageResource(Balloons.balloonImages[index]);
            letsSetLayoutParamsForImageView(imageView);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    imgAnimal.setImageResource(Balloons.balloonImages[i]);
                    letsSetLayoutParamsForImageView(imgAnimal);
                    Toast.makeText(MainActivity.this,"The color is "+Balloons.colors[i],Toast.LENGTH_LONG).show();
                }
            });

            linearLayoutHorizontal.addView(imageView);

        }

    }


    public void letsSetLayoutParamsForImageView(ImageView imageView){

        imageView.setLayoutParams(new LinearLayout.LayoutParams(200,200));

    }


}
