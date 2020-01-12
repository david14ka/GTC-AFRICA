package com.dkz.gtcafrica.Student.ui;

import android.content.Intent;
import android.os.Bundle;

import com.dkz.gtcafrica.BaseActivity;
import com.dkz.gtcafrica.R;
import com.dkz.gtcafrica.model.StudentAccount;
import com.dkz.gtcafrica.model.StudentInfo;

import androidx.appcompat.app.AppCompatActivity;

import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import dmax.dialog.SpotsDialog;

public class StudentInfoActivity extends BaseActivity {

    public static StudentAccount CurrentAccount;

    EditText editNames;
    EditText editSurname;
    EditText editDob;
    EditText editGender;
    EditText editCitizen;
    EditText editProvince;
    EditText editAddress;
    EditText editPostalCode;
    //EditText editPhotoUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_activity_info);
        //Toolbar toolbar = findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        editNames = findViewById(R.id.editNames);
        editSurname = findViewById(R.id.editSurname);
        editDob = findViewById(R.id.editDob);
        editGender = findViewById(R.id.editGender);
        editCitizen = findViewById(R.id.editCitizenship);
        editProvince = findViewById(R.id.editProvince);
        editAddress = findViewById(R.id.editAddress);
        editPostalCode = findViewById(R.id.editPostalCode);
        //editPhotoUrl = findViewById(R.id.editPhotoUrl);

        dialog = new SpotsDialog(this,"Updating Info...");


    }

    public void xml_home_based(View view) {

        if (verifiedEntries()){
            dialog.show();
            setStudentInfo(CurrentAccount.getUsername());
            startActivity(new Intent(getApplicationContext(), StudentWelcomeActivity.class));
            finish();
            dialog.dismiss();

        }
    }

    private boolean verifiedEntries() {

        if (TextUtils.isEmpty(editNames.getText().toString()))
            Toast.makeText(this, "Names is Empty !", Toast.LENGTH_SHORT).show();
        else if (TextUtils.isEmpty(editSurname.getText().toString()))
            Toast.makeText(this, "Surname is Empty !", Toast.LENGTH_SHORT).show();
        else if (TextUtils.isEmpty(editDob.getText().toString()))
            Toast.makeText(this, "Dob is Empty !", Toast.LENGTH_SHORT).show();
        else if (TextUtils.isEmpty(editGender.getText().toString()))
            Toast.makeText(this, "Gender is Empty !", Toast.LENGTH_SHORT).show();
        else if (TextUtils.isEmpty(editCitizen.getText().toString()))
            Toast.makeText(this, "Citizen is Empty !", Toast.LENGTH_SHORT).show();
        else if (TextUtils.isEmpty(editProvince.getText().toString()))
            Toast.makeText(this, "Province is Empty !", Toast.LENGTH_SHORT).show();
        else if (TextUtils.isEmpty(editAddress.getText().toString()))
            Toast.makeText(this, "Address is Empty !", Toast.LENGTH_SHORT).show();
        else if (TextUtils.isEmpty(editPostalCode.getText().toString()))
            Toast.makeText(this, "PostalCode is Empty !", Toast.LENGTH_SHORT).show();

        else {
            return true;
        }

        return false;
    }

    private StudentInfo getStudentInfo() {

        StudentInfo studentInfo = new StudentInfo();
        studentInfo.setNames(editNames.getText().toString());
        studentInfo.setSurname(editSurname.getText().toString());
        studentInfo.setDob(editDob.getText().toString());
        studentInfo.setGender(editGender.getText().toString());
        studentInfo.setCitizen(editCitizen.getText().toString());
        studentInfo.setProvince(editProvince.getText().toString());
        studentInfo.setAddress(editAddress.getText().toString());
        studentInfo.setPostalCode(editPostalCode.getText().toString());

        return studentInfo;
    }

    private void setStudentInfo(String Username) {

        StudentInfo.ref.child(Username).setValue(getStudentInfo());

    }
}
