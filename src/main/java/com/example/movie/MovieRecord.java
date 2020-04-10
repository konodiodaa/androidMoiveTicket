package com.example.movie;

import java.util.Date;

public class MovieRecord {
    private String MovieTitle;
    private int price;
    private Date showDate;
    private Cinema cinema;

    public MovieRecord(String movieTitle, int price, Date showDate,Cinema cinema) {
        MovieTitle = movieTitle;
        this.price = price;
        this.showDate = showDate;
        this.cinema = cinema;
    }

    public String getMovieTitle() {
        return MovieTitle;
    }

    public int getPrice() {
        return price;
    }

    public Date getShowDate() {
        return showDate;
    }

    public Cinema getCinema() {
        return cinema;
    }
}
