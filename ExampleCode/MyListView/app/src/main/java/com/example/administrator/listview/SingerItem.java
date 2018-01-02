package com.example.administrator.listview;


public class SingerItem {
    String name;
    String phone;
    int age;
    int resId;

    SingerItem(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    SingerItem(String name, String phone, int age, int resId) {
        this.name = name;
        this.phone = phone;
        this.age = age;
        this.resId = resId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }
}
