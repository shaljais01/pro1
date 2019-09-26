package com.example.pro1;

public class typeforanimal {

    String messName;
    String location;

    String quanFood;
    int rating;
    String photo;

    public typeforanimal(String messName, String location, String quanFood,String photo,int rating)
    {
        this.messName=messName;
        this.location=location;
        this.quanFood=getQuannFood();

        this.photo=photo;
        this.rating=rating;
    }

    public String getPhoto() {
        return photo;
    }

    public String getMessName() {
        return messName;
    }

    public String getLocation() {
        return location;
    }

    public String getQuannFood() {
        return getQuannFood();
    }


    public int getRating() {
        return rating;
    }
}
