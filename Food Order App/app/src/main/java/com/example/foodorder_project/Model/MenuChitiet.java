package com.example.foodorder_project.Model;

public class MenuChitiet {

    public String foodName;
    public int price;
    public int reviewStar;
    public String image;

    public MenuChitiet() {
    }

    public MenuChitiet(String foodName, int price, int reviewStar, String image) {
        this.foodName = foodName;
        this.price = price;
        this.reviewStar = reviewStar;
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getFoodName() {
        return foodName;
    }

    public int getPrice() {
        return price;
    }

    public int getReviewStar() {
        return reviewStar;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setReviewStar(int reviewStar) {
        this.reviewStar = reviewStar;
    }
}
