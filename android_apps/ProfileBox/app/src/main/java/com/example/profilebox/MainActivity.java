package com.example.profilebox;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    DBHelper mydb;
    ArrayList<String> al;
    ArrayAdapter<String> aa;
    ListView lv1;
    Button b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mydb = new DBHelper(this);
        lv1 = findViewById(R.id.lv1);
        b2=findViewById(R.id.b2);
        al = new ArrayList<String>();
        aa = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, al);
        lv1.setAdapter(aa);
        setupListViewListener();
        loadAll();
        deleteAllData();
    }


    public void onAddItem(View v) {

        Intent i = new Intent(this, AddNewProfile.class);
        finish();
        startActivity(i);
    }


    private void setupListViewListener() {
        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String s=(String) lv1.getItemAtPosition(i);
                Toast.makeText(MainActivity.this,s+"is selected!!" , Toast.LENGTH_LONG).show();

                Intent j = new Intent(getApplicationContext(), EditThisProfile.class);
                j.putExtra("Email",s);
                finish();
                startActivity(j);

            }
        });
    }


    public void loadAll() {
        Cursor res = mydb.getAllData();
        if (res.getCount() == 0) {
            // show message
            Toast.makeText(this, "Nothing To Load", Toast.LENGTH_LONG).show();
            return;
        }

        while (res.moveToNext()) {
            aa.add(res.getString(2));
        }
    }

    public void deleteAllData() {
        b2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Integer deletedRows = mydb.deleteAllData();
                        if (deletedRows > 0)
                            Toast.makeText(MainActivity.this, "All"+deletedRows+"rows are deleted!!", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(MainActivity.this, "Nothing is deleted!!", Toast.LENGTH_LONG).show();
                        Intent j = new Intent(getApplicationContext(), MainActivity.class);
                        finish();
                        startActivity(j);
                    }
                }
        );
    }


}
