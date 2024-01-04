package com.example.foodorder_project.Model;

import java.security.Timestamp;

public class Hientai {
    public String Quantity;
    public String status;
    public String ArrivalTime;
    public String createDate;
    public String Price;
    public String FoodName;

    public void setFoodName(String foodName) {
        FoodName = foodName;
    }

    public String getFoodName() {
        return FoodName;
    }

    public String PaymentMethod;

    public Hientai(String foodName,String quantity, String Status, String arrivalTime, String createDate, String price, String paymentMethod) {
        FoodName = foodName;
        Quantity = quantity;
        status = Status;
        ArrivalTime = arrivalTime;
        this.createDate = createDate;
        Price = price;
        PaymentMethod = paymentMethod;
    }

    public Hientai() {
    }

//    public Hientai (String quanlity, String status, String arrivalTime, String price, String paymentMethod) {
//        Quantity = quanlity;
//        Status = status;
//        ArrivalTime = arrivalTime;
//        Price = price;
//        PaymentMethod = paymentMethod;
//    }

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
        status = status;
    }

    public String getArrivalTime() {
        return ArrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        ArrivalTime = arrivalTime;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getPaymentMethod() {
        return PaymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        PaymentMethod = paymentMethod;
    }

}
