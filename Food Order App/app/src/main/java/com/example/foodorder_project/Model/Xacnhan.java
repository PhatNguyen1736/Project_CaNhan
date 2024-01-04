package com.example.foodorder_project.Model;

public class Xacnhan {
    private int FoodPicture;
    private String FoodName;
    private String Note;
    private String Quantity;
    private String Price;

    public Xacnhan(){
    }

    public Xacnhan(int foodPicture, String foodName, String note, String quantity, String price) {
        FoodPicture = foodPicture;
        FoodName = foodName;
        Note = note;
        Quantity = quantity;
        Price = price;
    }

    public int getFoodPicture() {
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

    public String getNote() {
        return Note;
    }

    public void setNote(String note) {
        Note = note;
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
}
