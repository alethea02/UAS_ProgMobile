package com.example.latihanapp7;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {


    private CardView buttonFirst;
    private CardView buttonSecond;
    private CardView buttonHallo;
    private CardView buttonFibo;
    private CardView buttonScroll;
    private CardView buttonAlarm;
    private CardView buttonMaps;
    private CardView buttonMovie;
    private CardView buttonTrailer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonSecond = findViewById(R.id.twoactivity);
        buttonFirst = findViewById(R.id.twoactivity);
        buttonHallo = findViewById(R.id.hallo);
        buttonFibo = findViewById(R.id.fibo);
        buttonScroll = findViewById(R.id.scroll);
        buttonAlarm = findViewById(R.id.SetAlarm);
        buttonMaps = findViewById(R.id.showmap);
        buttonMovie = (findViewById(R.id.movie));
        buttonTrailer = (findViewById(R.id.filmku));

        setToolbar();
        setIntent();
    }
    private void setToolbar() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Dimas Firmansyah");
            getSupportActionBar().setSubtitle("Projek Gabungan");
        }
    }
    private void setIntent() {

        buttonSecond.setOnClickListener(v -> {
            Intent intent = new Intent(this, SecondActivity.class);
            startActivity(intent);
            finish();
        });

        buttonFirst.setOnClickListener(v -> {
            Intent intent = new Intent(this, FirstActivity.class);
            startActivity(intent);
        });

        buttonHallo.setOnClickListener(v -> {
            Intent intent = new Intent(this, HalloActivity.class);
            startActivity(intent);
        });

        buttonFibo.setOnClickListener(v -> {
            Intent intent = new Intent(this, FiboActivity.class);
            startActivity(intent);
        });

        buttonScroll.setOnClickListener(view -> {
            Intent intent = new Intent(this, ScrollSianida.class);
            startActivity(intent);
        });

        buttonAlarm.setOnClickListener(view -> {
            Intent intent = new Intent(AlarmClock.ACTION_SHOW_ALARMS);
            startActivity(intent);
        });

        buttonMaps.setOnClickListener(view -> {
            Uri geoLocation = null;
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(geoLocation);
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
        });

        buttonMovie.setOnClickListener(view -> {
            Intent intent = new Intent(this, MovieActivity.class);
            startActivity(intent);
        });
        buttonTrailer.setOnClickListener(view -> {
            Intent intent = new Intent(this, TrailerActivity.class);
            startActivity(intent);
        });
    }

}