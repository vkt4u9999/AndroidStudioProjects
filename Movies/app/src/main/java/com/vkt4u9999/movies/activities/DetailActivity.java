package com.vkt4u9999.movies.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.vkt4u9999.movies.R;
import com.vkt4u9999.movies.model.Movie;

import static com.vkt4u9999.movies.activities.MainActivity.KEY_DIRECTOR;
import static com.vkt4u9999.movies.activities.MainActivity.KEY_PLOT;
import static com.vkt4u9999.movies.activities.MainActivity.KEY_POSTER_URL;
import static com.vkt4u9999.movies.activities.MainActivity.KEY_RUNTIME;
import static com.vkt4u9999.movies.activities.MainActivity.KEY_TITLE;
import static com.vkt4u9999.movies.activities.MainActivity.KEY_YEAR;

public class DetailActivity extends AppCompatActivity {

    TextView titleTextView;
    TextView yearTextView;
    TextView plotTextView;
    TextView runtimeTextView;
    TextView directorTextView;
    ImageView imageView;
    String posterURL;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();

        titleTextView= findViewById(R.id.titleTextView);
        yearTextView=findViewById(R.id.yearTextView);
        plotTextView= findViewById(R.id.plotTextView);
        runtimeTextView= findViewById(R.id.runTimeTextView);
        directorTextView=findViewById(R.id.directorTextView);
        imageView= findViewById(R.id.posterImageView);


        titleTextView.setText(intent.getStringExtra(KEY_TITLE));
        yearTextView.setText(intent.getStringExtra(KEY_YEAR));
        plotTextView.setText(intent.getStringExtra(KEY_PLOT));
        runtimeTextView.setText(intent.getStringExtra(KEY_RUNTIME));
        directorTextView.setText(intent.getStringExtra(KEY_DIRECTOR));
        posterURL=intent.getStringExtra(KEY_POSTER_URL);
        Picasso.get().load(posterURL).fit().centerInside()
                .into(imageView);





    }
}