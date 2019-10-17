package com.example.profilebox;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.database.Cursor;
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

public class EditThisProfile extends AppCompatActivity implements View.OnClickListener {
    String email;
    DBHelper mydb;
    String v1, v2, v3, v5;
    int v4, v7, v8, v9, v10 = 3, v6;
    Spinner et4, et7;
    EditText et1, et2, et3, et5;
    TextView et6;
    Cursor res;
    RadioGroup gender;
    String country[] = {"Country","India","Taiwan","Pakistan", "Tajikistan", "Tanzania", "Thailand", "Togo", "Tonga", "Trinidad and Tobago", "Tunisia", "Turkey", "Turkmenistan", "Tuvalu", "Uganda", "Ukraine", "United Arab Emirates", "United Kingdom", "United States", "Uruguay", "Uzbekistan", "Vanuatu", "Vatican City", "Venezuela", "Vietnam", "Yemen", "Zambia", "Zimbabwe"};
    ArrayAdapter<String> aa;
    String hq[] = {"Edu.", "X", "XII", "UG", "PG", "PhD"};
    ArrayAdapter<String> aa1;
    int mYear, mMonth, mDay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_this_profile);
        getSupportActionBar().setTitle("Edit This Profile");
        initViews();
        fillAll();
    }

    public void initViews() {
        email = getIntent().getStringExtra("Email");
        mydb = new DBHelper(this);
        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        et3 = findViewById(R.id.et3);
        et4 = findViewById(R.id.et4);
        et5 = findViewById(R.id.et5);
        et6 = findViewById(R.id.et6);
        et7 = findViewById(R.id.et7);
        gender = findViewById(R.id.gender);
        et6.setOnClickListener(this);
        aa = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, country);
        aa1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, hq);
        et4.setAdapter(aa);
        et7.setAdapter(aa1);
        et4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                v4 = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //v4=0;
            }
        });
        et7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                v9 = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
               // v9=0;
            }
        });

    }

    public void editit(View view) {

        v1 = et1.getText().toString();
        v2 = et2.getText().toString();
        v3 = et3.getText().toString();
        v5 = et5.getText().toString();
        if(v1.isEmpty()||v2.isEmpty()||v3.isEmpty()||v5.isEmpty()) {
            Toast.makeText(this, "There is some Empty Field", Toast.LENGTH_LONG).show();
        }
        else{
            boolean isUpdate = mydb.updateData(v1, v2, v3, v4 + "", v5, v6 + "", v7 + "", v8 + "", v9 + "", v10 + "");
            if (isUpdate == true)
                Toast.makeText(this, "Data Updated", Toast.LENGTH_LONG).show();
            else
                Toast.makeText(this, "Data not Updated", Toast.LENGTH_LONG).show();

            Intent i = new Intent(this, MainActivity.class);
            finish();
            startActivity(i);
        }

    }

    public void deleteit(View view) {
        Integer deletedRows = mydb.deleteData(v3);
        if (deletedRows > 0)
            Toast.makeText(this, "Profile Deleted", Toast.LENGTH_LONG).show();
        else
            Toast.makeText(this, "Profile not Deleted", Toast.LENGTH_LONG).show();
        Intent i = new Intent(this, MainActivity.class);
        finish();
        startActivity(i);
    }

    public void fillAll() {

        res = mydb.getSingle(email);
        if (res.getCount() == 0) {
            Toast.makeText(this, "Hello", Toast.LENGTH_LONG).show();
            return;
        }
        while (res.moveToNext()) {
            et1.setText(res.getString(0));
            et2.setText(res.getString(1));
            et3.setText(res.getString(2));
            v3=res.getString(2);
            et4.setSelection(Integer.parseInt(res.getString(3)));
            et5.setText(res.getString(4));
            et6.setText(res.getString(5)+"/"+res.getString(6)+"/"+res.getString(7));
            v6=Integer.parseInt(res.getString(5));
            v7=Integer.parseInt(res.getString(6));
            v8=Integer.parseInt(res.getString(7));
            et7.setSelection(Integer.parseInt(res.getString(8)));
            int a=Integer.parseInt(res.getString(9));
            v10=a;
            if(a==0)gender.check(R.id.et8);
            if(a==1)gender.check(R.id.et9);
            if(a==2)gender.check(R.id.et10);
        }
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
