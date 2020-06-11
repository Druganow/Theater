package com.example.lab_1.model;

public class Actor {
    private String name;
    private String imgUrl;

    public Actor(String name, String imageUrl){
        this.name = name;
        this.imgUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public String getImgUrl() {
        return imgUrl;
    }
}
