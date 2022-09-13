package com.example.demo.services;

import org.springframework.data.annotation.Id;

public class Movie {
    @Id
    public String id;
    public String name;
    public String genre;
    public int durationInMinutes;
    public String description;
    public float rating;

    public Movie(){

    }
    public Movie(String id,String name,String genre,int durationInMinutes,String description,int rating){
        this.id=id;
        this.name=name;
        this.genre=genre;
        this.durationInMinutes=durationInMinutes;
        this.description=description;
        this.rating=rating;
    }
}
