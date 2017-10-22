package com.yacov.databaseapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private TextView textView;
    DataBaseHelper dataBaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editTextTask);
        textView = (TextView) findViewById(R.id.txtViewTask);
        dataBaseHelper = new DataBaseHelper(this, null, null, 1);
        printDB();
    }

    public void addButtonclicked(View view){
        Tasks tasks = new Tasks(editText.getText().toString());
        dataBaseHelper.addTasks(tasks);
        printDB();
    }

    public void removeButtonClicked(View view){
        String input = editText.getText().toString();
        dataBaseHelper.removeTasks(input);
        printDB();

    }

    public void printDB(){
        String dbString = dataBaseHelper.databasetostring();
        textView.setText(dbString);

    }
}
