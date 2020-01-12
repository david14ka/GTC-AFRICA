package com.dkz.gtcafrica.model;

import com.dkz.gtcafrica.config.DatabaseRef;
import com.google.firebase.database.DatabaseReference;

public class StudentInfo {
    private String Names;
    private String Surname;
    private String Dob;
    private String Gender;
    private String Citizen;
    private String Province;
    private String Address;
    private String PostalCode;
    private String PhotoUrl;

    final public static DatabaseReference ref = DatabaseRef.reference.child(StudentInfo.class.getSimpleName());


    public StudentInfo() {
    }

    public String getNames() {
        return Names;
    }

    public void setNames(String names) {
        Names = names;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public String getDob() {
        return Dob;
    }

    public void setDob(String dob) {
        Dob = dob;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getCitizen() {
        return Citizen;
    }

    public void setCitizen(String citizen) {
        Citizen = citizen;
    }

    public String getProvince() {
        return Province;
    }

    public void setProvince(String province) {
        Province = province;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPostalCode() {
        return PostalCode;
    }

    public void setPostalCode(String postalCode) {
        PostalCode = postalCode;
    }

    public String getPhotoUrl() {
        return PhotoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        PhotoUrl = photoUrl;
    }
}
