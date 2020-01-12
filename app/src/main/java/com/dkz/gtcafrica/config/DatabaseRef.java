package com.dkz.gtcafrica.config;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DatabaseRef {

    public static DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
}
