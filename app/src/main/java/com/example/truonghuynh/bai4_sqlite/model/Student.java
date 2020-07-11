package com.example.truonghuynh.bai4_sqlite.model;

/**
 * Created by Truong Huynh on 25/03/2018.
 */

public class Student {
    private int mID;
    private String mName;
    private String mPhoneNumber;
    private String mAddress;
    private  String mEmail;

    public Student() {
    }

    // dung luc dua vao, do id tu tang nen khong can id
    public Student(String mName, String mPhoneNumber, String mAddress, String mEmail) {
        this.mName = mName;
        this.mPhoneNumber = mPhoneNumber;
        this.mAddress = mAddress;
        this.mEmail = mEmail;
    }

    // dung luc lay ra nen co id
    public Student(int mID, String mName, String mPhoneNumber, String mAddress, String mEmail) {
        this.mID = mID;
        this.mName = mName;
        this.mPhoneNumber = mPhoneNumber;
        this.mAddress = mAddress;
        this.mEmail = mEmail;
    }

    public int getmID() {
        return mID;
    }

    public void setmID(int mID) {
        this.mID = mID;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmPhoneNumber() {
        return mPhoneNumber;
    }

    public void setmPhoneNumber(String mPhoneNumber) {
        this.mPhoneNumber = mPhoneNumber;
    }

    public String getmAddress() {
        return mAddress;
    }

    public void setmAddress(String mAddress) {
        this.mAddress = mAddress;
    }

    public String getmEmail() {
        return mEmail;
    }

    public void setmEmail(String mEmail) {
        this.mEmail = mEmail;
    }
}
