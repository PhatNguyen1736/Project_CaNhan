package com.example.foodorder_project.Model;

public class Users {
    public String DOD;
    public String email;
    public String fullname;
    public String gender;
    public String locationID;
    public String password;
    public int phone;

    public Users() {
    }

    public Users(String DOD, String email, String fullname, String gender, String locationID, String password, int phone) {
        this.DOD = DOD;
        this.email = email;
        this.fullname = fullname;
        this.gender = gender;
        this.locationID = locationID;
        this.password = password;
        this.phone = phone;
    }

    public String getDOD() {
        return DOD;
    }

    public String getEmail() {
        return email;
    }

    public String getFullname() {
        return fullname;
    }

    public String getGender() {
        return gender;
    }

    public String getLocationID() {
        return locationID;
    }

    public String getPassword() {
        return password;
    }

    public int getPhone() {
        return phone;
    }

    public void setDOD(String DOD) {
        this.DOD = DOD;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setLocationID(String locationID) {
        this.locationID = locationID;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }
}
