package com.dkz.gtcafrica.Student.ui;

import android.content.Intent;
import android.os.Bundle;

import com.dkz.gtcafrica.BaseActivity;
import com.dkz.gtcafrica.MainActivity;
import com.dkz.gtcafrica.model.StudentAccount;

import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.dkz.gtcafrica.R;
import com.dkz.gtcafrica.model.ui.StudentBasedData;
import com.pixplicity.easyprefs.library.Prefs;

public class StudentHomeBasedActivity extends BaseActivity {

    public static StudentAccount ConnectedStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_activity_home);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }if (id == R.id.action_logout) {

            Prefs.clear();
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
            return true;

        }

        return super.onOptionsItemSelected(item);
    }

    public void xml_community_based_details(View view) {

        int tag = Integer.parseInt(String.valueOf(view.getTag()));
        StudentDetailsBasedActivity.studentMenu = StudentBasedData.getStudentMenus(getApplicationContext()).get(tag);
        startActivity(new Intent(getApplicationContext(), StudentDetailsBasedActivity.class));

    }
}
