package com.dkz.gtcafrica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import com.dkz.gtcafrica.Student.ui.StudentHomeBasedActivity;
import com.pixplicity.easyprefs.library.Prefs;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                //Toast.makeText(SplashActivity.this, Prefs.getString("Username",""), Toast.LENGTH_SHORT).show();

                if (Prefs.getBoolean("StudentAccount", false)) {
                    startActivity(new Intent(getApplicationContext(), StudentHomeBasedActivity.class));

                } else {
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));

                }
                finish();
            }

        }, 2000);

    }
}
