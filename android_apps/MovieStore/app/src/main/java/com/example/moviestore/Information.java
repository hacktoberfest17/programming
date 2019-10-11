package com.example.moviestore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class Information extends AppCompatActivity {
    ImageView backdrop;
    TextView title,certiType,pop,vote_count,vote_avg,overview,release_date,language;
    String sbackdrop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);
        getSupportActionBar().setTitle("Information");
        initALL();
    }
    public  void initALL(){
        backdrop=findViewById(R.id.backdrop);
        title=findViewById(R.id.title);
        certiType=findViewById(R.id.certiType);
        pop=findViewById(R.id.popularity);
        vote_count=findViewById(R.id.vote_count);
        vote_avg=findViewById(R.id.vote_avg);
        overview=findViewById(R.id.overview);
        release_date=findViewById(R.id.release_date);
        language=findViewById(R.id.language);

        Intent i = getIntent();
        title.setText(i.getStringExtra("stitle"));
        certiType.setText(i.getStringExtra("scertitype"));
        pop.setText(i.getStringExtra("spop"));
        vote_avg.setText(i.getStringExtra("svote"));
        overview.setText(i.getStringExtra("soverview"));
        vote_count.setText(i.getStringExtra("svcount"));
        language.setText(i.getStringExtra("slang"));
        release_date.setText(i.getStringExtra("srdate"));
        sbackdrop=i.getStringExtra("sbackdrop");
        Picasso.get().load("http://image.tmdb.org/t/p/w780"+sbackdrop).into(backdrop);
    }


}
