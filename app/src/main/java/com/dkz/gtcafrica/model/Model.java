package com.dkz.gtcafrica.model;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Model {

    public final DatabaseReference databaseReference;

    public Model(String ref) {

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        this.databaseReference = database.getReference(ref);
    }

}
