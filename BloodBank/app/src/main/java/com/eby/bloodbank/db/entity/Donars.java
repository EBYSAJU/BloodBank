package com.eby.bloodbank.db.entity;

import androidx.room.ColumnInfo;
import androidx.room.Dao;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity
public class Donars {
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Donars(String username, String password, String firstName, String lastName, String address, String gender, String bloodGroup,String date) {
       this.password=password;
        this.username=username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.gender = gender;
        this.age = age;
        this.bloodGroup=bloodGroup;
        this.date=date;
    }

    public void setId(int id) {
        this.id = id;
    }

    @PrimaryKey(autoGenerate = true)
    private int id;
@ColumnInfo(name="first_name")
    private String firstName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @ColumnInfo(name="last_name")
    private String lastName;
@ColumnInfo(name="address")
    private String address;
@ColumnInfo(name="gender")
    String gender;
@ColumnInfo(name="age")
int age;

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    @ColumnInfo(name="blood_group")
String bloodGroup;
    @ColumnInfo(name="user_name")
    String username;
    @ColumnInfo(name="password")
    String password;
    @ColumnInfo(name="date")
    String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
