package com.example.testapp9;

public class UserModel {
    public String name;
    public String email;
    public String phone;
    public String adr;
    public Integer image;

    public UserModel(String name, String email, String phone, String adr, Integer image) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.adr = adr;
        this.image = image;
    }
}
