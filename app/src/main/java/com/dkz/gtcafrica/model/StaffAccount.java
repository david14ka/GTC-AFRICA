package com.dkz.gtcafrica.model;

import com.dkz.gtcafrica.config.DatabaseRef;
import com.google.firebase.database.DatabaseReference;

public class StaffAccount  {

    private String Username;
    private String Email;
    private String Password;
    private String StaffID;

    final public static DatabaseReference ref = DatabaseRef.reference.child(StaffAccount.class.getSimpleName());


    public StaffAccount() {
    }

    public StaffAccount(String username, String email, String password, String staffID) {
        Username = username;
        Email = email;
        Password = password;
        StaffID = staffID;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getStaffID() {
        return StaffID;
    }

    public void setStaffID(String staffID) {
        StaffID = staffID;
    }


}
