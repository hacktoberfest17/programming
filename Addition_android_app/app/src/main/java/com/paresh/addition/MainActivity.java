package com.paresh.addition;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView tv3 = (TextView)findViewById(R.id.tv3);
        final EditText et1 = (EditText)findViewById(R.id.et1);
        final EditText et2 = (EditText)findViewById(R.id.et2);
        Button add = (Button)findViewById(R.id.add);


        final float[] ans = new float[1];

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ans[0] = Float.parseFloat(et1.getText().toString()) + Float.parseFloat(et2.getText().toString());
                tv3.setText(String.valueOf(ans[0]));
            }
        });

    }
}
