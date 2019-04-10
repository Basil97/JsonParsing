package com.basil.jsonparsing;

public class Movies {

    String title;
    String overview;
    String imageUrl;
    long id;
    float vote;

    public Movies(String title, String overview, String imageUrl, long id, float vote) {
        this.title = title;
        this.overview = overview;
        this.imageUrl = imageUrl;
        this.id = id;
        this.vote = vote;
    }
}
