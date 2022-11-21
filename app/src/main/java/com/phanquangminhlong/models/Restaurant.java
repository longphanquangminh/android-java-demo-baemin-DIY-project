package com.phanquangminhlong.models;

public class Restaurant {
    String placeName, dishName, address, ratingCount;
    int photo;
    double ratingValue;

    //Constructor


    public Restaurant(String placeName, String dishName, int photo, double ratingValue, String ratingCount, String address) {
        this.placeName = placeName;
        this.dishName = dishName;
        this.photo = photo;
        this.ratingValue = ratingValue;
        this.ratingCount = ratingCount;
        this.address = address;



    }
//Getters and Setters


    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRatingCount() {
        return ratingCount;
    }

    public void setRatingCount(String ratingCount) {
        this.ratingCount = ratingCount;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public double getRatingValue() {
        return ratingValue;
    }

    public void setRatingValue(double ratingValue) {
        this.ratingValue = ratingValue;
    }
}


