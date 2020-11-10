package com.example.booking;

public class RowItem {
    private int imageId;
    private String price;
    private String place;
    private String rating;
    private int rating_img;

    public RowItem(int imageId, String price, String place, String rating, int rating_img) {
        this.imageId = imageId;
        this.price = price;
        this.place = place;
        this.rating = rating;
        this.rating_img = rating_img;
    }
    public int getImageId() {
        return imageId;
    }
    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }
    public String getPlace() {
        return place;
    }
    public void setPlace(String place) {
        this.place = place;
    }
    public String getRating() {
        return rating;
    }
    public void setRating(String rating) {
        this.rating = rating;
    }
    public int getRating_img(){
        return rating_img;
    }
    public void setRating_img(int rating_img){
        this.rating_img = rating_img;
    }
//    @Override
//    public String toString() {
//        return title + "\n" + desc;
//    }
}
