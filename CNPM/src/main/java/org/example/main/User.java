package org.example.main;

import java.util.Date;

public class User {
    private String id;
    private String userName;
    private int height;
    private int weight;
    private int age;
    private String password;
    private  int  role;
    private int  gioiTinh;
    private String avt;
    private Date registerDate;
    private String email;


    private DailyInformation dailyInformation;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getAge( ) {
        return age;
    }

    public void setAge(int anInt) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }


    public void setGioiTinh(int gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getAvt() {
        return avt;
    }

    public void setAvt(String avt) {
        this.avt = avt;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public DailyInformation getDailyInformation() {
        return dailyInformation;
    }

    public void setDailyInformation(DailyInformation dailyInformation) {
        this.dailyInformation = dailyInformation;
    }

    public int getGioiTinh() {
        return gioiTinh;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
