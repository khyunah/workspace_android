package com.example.movie_1_1.models;

import java.io.Serializable;

public class Movie implements Serializable {
    private String url;
    private String title;
    private int year;
    private double rating;
    private int runtime;
    private String synopsis;
    private String background_image;
    private String medium_cover_image;

    public String getUrl() {
        return url;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public double getRating() {
        return rating;
    }

    public int getRuntime() {
        return runtime;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public String getBackground_image() {
        return background_image;
    }

    public String getMedium_cover_image() {
        return medium_cover_image;
    }
}
