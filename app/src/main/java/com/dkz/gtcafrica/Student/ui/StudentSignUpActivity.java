package com.dkz.gtcafrica.Student.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.dkz.gtcafrica.BaseActivity;
import com.dkz.gtcafrica.R;
import com.dkz.gtcafrica.config.SecurePassword;
import com.dkz.gtcafrica.model.StringReference;
import com.dkz.gtcafrica.model.StudentAccount;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.pixplicity.easyprefs.library.Prefs;

import dmax.dialog.SpotsDialog;

public class StudentSignUpActivity extends BaseActivity {

    private static final String TAG = StudentSignUpActivity.class.getCanonicalName();
    EditText editUsername;
    EditText editEmail;
    EditText editPassword;
    EditText editConfirmPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        //Toolbar toolbar = findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        //ButterKnife.bind(this);
        editUsername = findViewById(R.id.editUsername);
        editEmail = findViewById(R.id.editEmail);
        editPassword = findViewById(R.id.editPassword);
        editConfirmPassword = findViewById(R.id.editConfirmPassword);

        // getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        dialog = new SpotsDialog(this,"Updating...");
    }

    public void xml_student_info(View view) {

        if (!checkFields()) return;

        dialog.show();
        final StudentAccount account = new StudentAccount();
        account.setUsername(editUsername.getText().toString());
        account.setEmail(editEmail.getText().toString());
        account.setPassword(SecurePassword.encrypt(editPassword.getText().toString()));

        StudentAccount.ref.child(account.getKey()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                Log.d(TAG, "onDataChange: "+dataSnapshot);
                dialog.dismiss();
                if (dataSnapshot.exists()) {
                    Toast.makeText(StudentSignUpActivity.this, "Username exist, please login!", Toast.LENGTH_LONG).show();
                } else {
                    StudentAccount.ref.child(account.getKey()).setValue(account);

                    Prefs.putString("Username",account.getUsername());
                    Prefs.putString("Email",account.getEmail());
                    Prefs.putBoolean("StudentAccount",true);
                    StudentInfoActivity.CurrentAccount = account;
                    startActivity(new Intent(getApplicationContext(), StudentInfoActivity.class));
                    finish();
                    return;
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    private boolean checkFields() {
        String textError = "";
        if (TextUtils.isEmpty(editUsername.getText())) textError = "Username is empty";
        else if (TextUtils.isEmpty(editEmail.getText())) textError = "Email is empty";
        else if (!editEmail.getText().toString().contains("@")) textError = "Email invalid";
        else if (TextUtils.isEmpty(editPassword.getText())) textError = "Password is empty";
        else if (TextUtils.isEmpty(editConfirmPassword.getText()))
            textError = "Confirm Password is empty";
        else if (!editConfirmPassword.getText().toString().equals(editPassword.getText().toString()))
            textError = "Password doesn't much!";
        else {
            return true;
        }

        Toast.makeText(this, textError, Toast.LENGTH_SHORT).show();

        return false;
    }
}
