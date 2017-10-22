package com.example.rishabh.sqlite;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText myInput;
    TextView myText;
    Button add,delete;
    MyDBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myInput=(EditText)findViewById(R.id.myText);
        myText=(TextView) findViewById(R.id.textView);
        dbHandler=new MyDBHandler(this,null,null,1);
        printDatabase();
    }

    public void addButtonClicked(View view){
        Products product=new Products(myInput.getText().toString());
        dbHandler.addProduct(product);
        printDatabase();
    }

    public void deleteButtonClicked(View view){
        String inputText=myInput.getText().toString();
        dbHandler.deleteProduct(inputText);
        printDatabase();

    }

    public void printDatabase(){
        String dbString=dbHandler.databaseToString();
        myText.setText(dbString);
        myInput.setText("");
    }
}
