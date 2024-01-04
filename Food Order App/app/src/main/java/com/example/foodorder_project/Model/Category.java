package com.example.foodorder_project.Model;


public class Category {
    public String nameCategory;
    public String image;
    public Category() {
    }

    public Category(String image, String nameCategory) {
        this.image = image;
        this.nameCategory = nameCategory;
    }
    public String getImage(){
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }
}
