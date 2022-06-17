package com.example.test7.pojo;

public class Contact {
    private String phone;
    private String name;
    private String sex;

    public Contact(String phone, String name, String sex) {
        this.phone = phone;
        this.name = name;
        this.sex = sex;
    }

    public Contact() {
    }

    public Contact(String phone, String name) {
        this.phone = phone;
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
