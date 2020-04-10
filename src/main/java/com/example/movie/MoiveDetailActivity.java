package com.example.movie;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MoiveDetailActivity extends AppCompatActivity {

    private ImageView moviePost;
    private TextView movieTitle;
    private TextView movieDirector;
    private TextView movieCast;
    private TextView movieGenre;
    private TextView movieIntro;



    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moive_detail);

        moviePost = (ImageView) findViewById(R.id.moviePost);
        movieTitle = (TextView) findViewById(R.id.movieTitle);
        movieDirector = (TextView) findViewById(R.id.movieDirector);
        movieCast = (TextView) findViewById(R.id.movieCast);
        movieGenre = (TextView) findViewById(R.id.movieGenre);
        movieIntro = (TextView) findViewById(R.id.movieIntro);

        String intro = "In a dystopian future, prisoners are held in vertically stacked cells, " +
                "hungrily watching food fall from the top, those at the top are stuffed, and those " +
                "at the bottom are radicalized by hunger.\n" +
                "Directed by gard gastro-ulusia, the hunger platform is a twisted social fable about" +
                " humanity at its darkest and hungriest.";

        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("bundle");
        movieTitle.setText(bundle.getString("title"));
        moviePost.setImageResource(bundle.getInt("img"));
        movieDirector.setText("Director: "+bundle.getString("director"));
        movieCast.setText("Cast: "+bundle.getString("cast"));
        movieGenre.setText("Genre: "+bundle.getString("genre"));
        movieIntro.setText(intro);

    }
}
