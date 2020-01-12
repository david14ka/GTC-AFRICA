package com.dkz.gtcafrica.Student.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.dkz.gtcafrica.R;
import com.dkz.gtcafrica.Student.ui.StudentHomeBasedActivity;

public class StudentWelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(), StudentHomeBasedActivity.class));

            }
        },2000);
    }
}
