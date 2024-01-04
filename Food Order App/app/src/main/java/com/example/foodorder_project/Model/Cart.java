package com.example.foodorder_project.Model;

public class Cart {
    private int FoodPicture;
    private String FoodName;
    private String Quantity;
    private String Price;
    private String Note;


    public Cart(int foodPicture, String foodName, String quantity, String price, String note) {
        FoodPicture = foodPicture;
        FoodName = foodName;
        Quantity = quantity;
        Price = price;
        Note = note;
    }

    public int  getFoodPicture() {
        return FoodPicture;
    }

    public void setFoodPicture(int foodPicture) {
        FoodPicture = foodPicture;
    }

    public String getFoodName() {
        return FoodName;
    }

    public void setFoodName(String foodName) {
        FoodName = foodName;
    }

    public String getQuantity() {
        return Quantity;
    }

    public void setQuantity(String quantity) {
        Quantity = quantity;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getNote() {
        return Note;
    }

    public void setNote(String note) {
        Note = note;
    }

}

