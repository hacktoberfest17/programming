package com.example.profilebox;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class AddNewProfile extends AppCompatActivity implements View.OnClickListener {
    DBHelper mydb;
    String v1, v2, v3, v5;
    int v4, v7, v8, v9, v10=3, v6;
    Spinner et4, et7;
    EditText et1, et2, et3, et5;
    TextView et6;
    RadioGroup gender;
    String country[] = {"Country","India","Taiwan","Pakistan", "Tajikistan", "Tanzania", "Thailand", "Togo", "Tonga", "Trinidad and Tobago", "Tunisia", "Turkey", "Turkmenistan", "Tuvalu", "Uganda", "Ukraine", "United Arab Emirates", "United Kingdom", "United States", "Uruguay", "Uzbekistan", "Vanuatu", "Vatican City", "Venezuela", "Vietnam", "Yemen", "Zambia", "Zimbabwe"};
    ArrayAdapter<String> aa;
    String hq[] = {"Edu.", "X", "XII", "UG", "PG", "PhD"};
    ArrayAdapter<String> aa1;
    int mYear, mMonth, mDay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_profile);
        getSupportActionBar().setTitle("Add New Profile");
        initViews();
    }

    private void initViews() {
        mydb = new DBHelper(this);
        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        et3 = findViewById(R.id.et3);
        et5 = findViewById(R.id.et5);
        et6 = findViewById(R.id.et6);
        et6.setOnClickListener(this);
        gender = findViewById(R.id.gender);
        et4 = findViewById(R.id.et4);
        aa = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, country);
        et4.setAdapter(aa);
        gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.et8:
                        v10 = 0;
                        break;
                    case R.id.et9:
                        v10 = 1;
                        break;
                    case R.id.et10:
                        v10 = 2;
                        break;
                }
            }
        });
        et4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                v4 = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                v4=0;
            }
        });
        et7 = findViewById(R.id.et7);
        aa1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, hq);
        et7.setAdapter(aa1);

        et7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                v9 = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                v9=0;
            }
        });


    }

    public void addit(View view) {
        v1 = et1.getText().toString();
        v2 = et2.getText().toString();
        v3 = et3.getText().toString();
        v5 = et5.getText().toString();
        if(v1.isEmpty()||v2.isEmpty()||v3.isEmpty()||v5.isEmpty()) {
            Toast.makeText(this, "There is some Empty Field", Toast.LENGTH_LONG).show();
        }
        else{
            boolean isInserted = mydb.insertData(v1, v2, v3, v4 + "", v5, v6 + "", v7 + "", v8 + "", v9 + "", v10 + "");
            if (isInserted == true)
                Toast.makeText(this, "Data Inserted", Toast.LENGTH_LONG).show();
            else
                Toast.makeText(this, "Data not Inserted", Toast.LENGTH_LONG).show();

            Intent i = new Intent(this, MainActivity.class);
            finish();
            startActivity(i);
        }
    }

    @Override
    public void onClick(View view) {
        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);


        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {

                        et6.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                        v6 = dayOfMonth;
                        v7 = monthOfYear;
                        v8 = year;

                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }
}
