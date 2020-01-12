package com.dkz.gtcafrica.model;

import com.dkz.gtcafrica.config.DatabaseRef;
import com.google.firebase.database.DatabaseReference;

import java.util.Date;

public class StudentAccount {
    private String Key;
    private String Username;
    private String Email;
    private String Password;
    private Date dateCreated;
    private Date dateUpdated;
    final public static DatabaseReference ref = DatabaseRef.reference.child(StudentAccount.class.getSimpleName());

    public StudentAccount() {

    }

    public StudentAccount(String username, String email, String password) {
        Key = username;
        Username = username;
        Email = email;
        Password = password;
        dateCreated = new Date();
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Key = username;
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


    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(Date dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public String getKey() {
        return StringReference.clean(Key.toLowerCase());
    }

    public void setKey(String key) {
        Key = key;
    }
}
