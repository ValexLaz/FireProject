package com.example.fireproject.models;

public class Coordinate {
    public String country;
    public double latitude;
    public double longitude;

    public Coordinate(String country, double latitude, double longitude) {
        this.country = country;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "Coordinate{" +
                "country='" + country + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}

