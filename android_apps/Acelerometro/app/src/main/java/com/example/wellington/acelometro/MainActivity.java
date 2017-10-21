package com.example.wellington.acelometro;

import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.OrientationEventListener;
import android.widget.TextView;


import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity{

    @Bind(R.id.portrait)
    TextView portrait;

    OrientationEventListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        addOrientationListener();
    }


    private void addOrientationListener() {
        listener = new OrientationEventListener(this, SensorManager.SENSOR_DELAY_UI) {
            public void onOrientationChanged(int orientation) {
                if ((orientation >= 230 && orientation <= 290) || (orientation >= 70 && orientation <= 90)) {
                    portrait.setText("True");
                }
            }
        };
        if (listener.canDetectOrientation()) listener.enable();
    }


    @Override
    protected void onPause() {
        super.onPause();
        if(listener != null){
            listener.disable();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(listener != null){
            listener.enable();
        }
    }
}
