package com.example.cookit.model;

public class MealModel {

    private int id;
    private String name;
    private String image ;
    private String country;
    private String ingredients;
    private String measures;
    private String steps;
    private String video;

    public MealModel(int id, String name, String image, String country, String ingredients,String measures, String steps, String video) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.country = country;
        this.ingredients = ingredients;
        this.measures = measures;
        this.steps = steps;
        this.video = video;
    }

    public MealModel(String name, String image) {
        this.name = name;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getMeasures() {
        return measures;
    }

    public void setMeasures(String measures) {
        this.measures = measures;
    }

    public String getSteps() {
        return steps;
    }

    public void setSteps(String steps) {
        this.steps = steps;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }
}
