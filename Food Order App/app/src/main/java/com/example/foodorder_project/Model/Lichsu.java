package com.example.foodorder_project.Model;

public class Lichsu {
    public String Quantity;
    public String status;
    public String createDate;
    public String Price;
    public String foodname;

    public void setFoodname(String foodname) {
        this.foodname = foodname;
    }

    public String getFoodname() {
        return foodname;
    }

    public Lichsu(String foodname ,String quantity, String Status, String createDate, String price) {
       this.foodname = foodname;
        Quantity = quantity;
        status = Status;
        this.createDate = createDate;
        Price = price;
    }

    public Lichsu() {
    }


    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getCreateDate() {
        return createDate;
    }


    public String getQuantity() {
        return Quantity;
    }

    public void setQuantity(String quantity) {
        Quantity = quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }


}
