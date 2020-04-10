package com.example.movie;

import android.media.Image;

public class Moive {
    private int postImg;
    private String rate;
    private String title;
    private String oTitle;
    private String genres;
    private String director;
    private String cast;

    public Moive(int postImg, String rate, String title, String oTitle, String genres, String director, String cast) {
        this.postImg = postImg;
        this.rate = rate;
        this.title = title;
        this.oTitle = oTitle;
        this.genres = genres;
        this.director = director;
        this.cast = cast;
    }

    public int getPostImg() {
        return postImg;
    }

    public String getRate() {
        return rate;
    }

    public String getTitle() {
        return title;
    }

    public String getoTitle() {
        return oTitle;
    }

    public String getGenres() {
        return genres;
    }

    public String getDirector() {
        return director;
    }

    public String getCast() {
        return cast;
    }
}
