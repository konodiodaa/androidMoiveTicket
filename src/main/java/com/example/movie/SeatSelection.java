package com.example.movie;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class SeatSelection extends AppCompatActivity {

    private MovieSeatView movieSeatView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.seat_selection);
        movieSeatView = (MovieSeatView) findViewById(R.id.seat);
        movieSeatView.setData(6,15);
    }
}
