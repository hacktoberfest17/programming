package com.example.moviestore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RecyclerView rcv;
    ImageButton search;
    EditText editText;
    String jsonmsg=null;
    String url=null;
    private String TAG = MainActivity.class.getSimpleName();
    private AsyncTask<Void, Void, Void> net;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initALL();
    }

    public void initALL(){
        search=findViewById(R.id.search_button);
        editText=findViewById(R.id.movie_name);

        rcv=findViewById(R.id.rcv);
        url = "https://api.themoviedb.org/3/movie/top_rated?page=1&language=en-US&api_key=6b8db85ce1e45beacf91815f5643cd76";
        net =   new Net().execute();
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                url="https://api.themoviedb.org/3/search/movie?api_key=6b8db85ce1e45beacf91815f5643cd76&query="+editText.getText().toString();
                new Net().execute();
            }
        });
    }

    protected class Net extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            Log.e("Async Task"," STARTED" );
            super.onPreExecute();
            Toast.makeText(MainActivity.this, "Json Data is downloading", Toast.LENGTH_SHORT).show();

        }

        @Override
        protected Void doInBackground(Void... arg0) {
            HttpHandler sh = new HttpHandler();
            // Making a request to url and getting response

            String jsonStr = sh.makeServiceCall(url);
            if (jsonStr != null) {

                jsonmsg=jsonStr;}
            else{
                Log.e(TAG, "Couldn't get json from server.");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(),
                                "Couldn't get json from server. Check LogCat for possible errors!",
                                Toast.LENGTH_LONG).show();
                    }
                });


            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            rcv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
            rcv.setAdapter(new ContactsAdapter(jsonmsg));
            Log.e("Async Task"," Executed" );


        }

        @Override
        protected void onCancelled() {
            Log.e("Async Task"," Finished" );

            super.onCancelled();
        }
    }

    @Override
    protected void onDestroy() {
        if(net!=null && !net.isCancelled()){
            net.cancel(true);
        }

        Log.e("Activity Async "," ACtivity Destroyed");
        super.onDestroy();
    }
}
