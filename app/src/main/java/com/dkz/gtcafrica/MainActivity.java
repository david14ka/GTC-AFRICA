package com.dkz.gtcafrica;

import android.content.Intent;
import android.os.Bundle;

import com.dkz.gtcafrica.Student.ui.StudentLoginActivity;
import com.dkz.gtcafrica.Student.ui.StudentSignUpActivity;
import com.dkz.gtcafrica.Student.ui.StudentHomeBasedActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Toolbar toolbar = findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);


    }

    public void xml_create_account(View view) {
        startActivity(new Intent(getApplicationContext(), StudentSignUpActivity.class));

    }

    public void xml_login(View view) {
        startActivity(new Intent(getApplicationContext(), StudentLoginActivity.class));

    }

    public void xml_browse_app(View view) {

        startActivity(new Intent(getApplicationContext(), StudentHomeBasedActivity.class));

    }

    public void xml_maps(View view) {
        startActivity(new Intent(getApplicationContext(), MapsActivity.class));
    }
}
