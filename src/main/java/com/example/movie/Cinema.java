package com.example.movie;

public class Cinema {
    private String name;
    private String address;
    private String distance;

    public Cinema(String name, String address, String distance) {
        this.name = name;
        this.address = address;
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getDistance() {
        return distance;
    }
}
