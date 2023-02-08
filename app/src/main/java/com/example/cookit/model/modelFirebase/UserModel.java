package com.example.cookit.model.modelFirebase;

import com.example.cookit.model.MealModel;

import java.util.List;

public class UserModel {
    int id ;
    String image;
    String userName;
    String email;
    String passWord;

    public UserModel(int id, String image, String userName, String email, String passWord, List<MealModel> favorites, List<MealModel> plans) {
        this.id = id;
        this.image = image;
        this.userName = userName;
        this.email = email;
        this.passWord = passWord;
        Favorites = favorites;
        Plans = plans;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<MealModel> getFavorites() {
        return Favorites;
    }

    public void setFavorites(List<MealModel> favorites) {
        Favorites = favorites;
    }

    public List<MealModel> getPlans() {
        return Plans;
    }

    public void setPlans(List<MealModel> plans) {
        Plans = plans;
    }

    List<MealModel> Favorites;

    List<MealModel> Plans;

    public UserModel(){

    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
