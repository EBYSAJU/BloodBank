package com.eby.bloodbank.db.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class DonarCenters {
    @PrimaryKey(autoGenerate = true)
    int id;
    @ColumnInfo(name="center_name")
    String centerName;
    @ColumnInfo(name="address")
    String Address;
    @ColumnInfo(name="contact_number")
    String contactNumber;

        @ColumnInfo(name="username")
    String username;

    public int getCenterCode() {
        return centerCode;
    }

    public void setCenterCode(int centerCode) {
        this.centerCode = centerCode;
    }

    @ColumnInfo(name="password")
    String password;
        @ColumnInfo(name="center_code")
        int centerCode;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCenterName() {
        return centerName;
    }

    public void setCenterName(String centerName) {
        this.centerName = centerName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public DonarCenters(int centerCode,String username,String password,String centerName, String Address, String contactNumber) {
        this.centerCode=centerCode;
        this.centerName = centerName;
        this.Address = Address;
        this.contactNumber = contactNumber;
        this.username=username;
        this.password=password;
    }
}
