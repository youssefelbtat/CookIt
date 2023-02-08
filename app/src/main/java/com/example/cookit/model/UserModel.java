package com.example.cookit.model;

public class UserModel {
    String image;
    String userName;
    String email;
    String passWord;

    public UserModel(String image, String userName, String email, String passWord) {
        this.image = image;
        this.userName = userName;
        this.email = email;
        this.passWord = passWord;
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
