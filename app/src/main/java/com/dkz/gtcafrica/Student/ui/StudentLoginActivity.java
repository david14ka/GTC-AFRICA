package com.dkz.gtcafrica.Student.ui;

import androidx.annotation.NonNull;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
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

public class StudentLoginActivity extends BaseActivity {
    private static final String TAG = StudentLoginActivity.class.getCanonicalName();
    EditText editUsername;
    EditText editPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editUsername = findViewById(R.id.editUsername);
        editPassword = findViewById(R.id.editPassword);

        dialog = new SpotsDialog(this, "Logging...");

    }


    public void xml_welcome(View view) {
        String textError = "";
        if (TextUtils.isEmpty(editUsername.getText())) textError = "Username is empty";
        else if (TextUtils.isEmpty(editPassword.getText())) textError = "Password is empty";
        else if (editUsername.getText().toString().contains("@")){

            loginStudentByEmail(); return;
        }
        else{

            StudentAccount account = new StudentAccount(editUsername.getText().toString(),"","");
            loginStudentByUsername(account); return;
        }

        Toast.makeText(this, textError, Toast.LENGTH_SHORT).show();

    }

    private void loginStudentByUsername(StudentAccount account) {

        dialog.show();

        StudentAccount.ref.child(account.getKey()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                dialog.dismiss();
                if (dataSnapshot.exists()) {

                    StudentAccount account = dataSnapshot.getValue(StudentAccount.class);

                   /* Log.d(TAG, "onDataChange: "+dataSnapshot);
                    Log.d(TAG, "onDataChange: "+dataSnapshot.exists());
                    Log.d(TAG, "onDataChange fireb: "+account.getPassword());
                    Log.d(TAG, "onDataChange edit: "+editPassword.getText().toString());*/

                    if (SecurePassword.decrypt(editPassword.getText().toString(), account.getPassword())) {
                        StudentHomeBasedActivity.ConnectedStudent = account;
                        Prefs.putString("Username", account.getUsername());
                        Prefs.putString("Email", account.getEmail());
                        Prefs.putBoolean("StudentAccount", true);
                        startActivity(new Intent(getApplicationContext(), StudentWelcomeActivity.class));

                    } else {
                        Toast.makeText(StudentLoginActivity.this, "Username or Password Incorrect", Toast.LENGTH_SHORT).show();

                    }

                } else {

                    Toast.makeText(StudentLoginActivity.this, "Username or Password Incorrect", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    private void loginStudentByEmail() {
        dialog.show();
        StudentAccount.ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                dialog.dismiss();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    StudentAccount account = snapshot.getValue(StudentAccount.class);

                    if (editUsername.getText().toString().equalsIgnoreCase(account.getEmail())) {

                        if (SecurePassword.decrypt(editPassword.getText().toString(), account.getPassword())) {
                            StudentHomeBasedActivity.ConnectedStudent = account;
                            Prefs.putString("Username", account.getUsername());
                            Prefs.putString("Email", account.getEmail());
                            Prefs.putBoolean("StudentAccount", true);

                            startActivity(new Intent(getApplicationContext(), StudentWelcomeActivity.class));
                            finish();

                            break;

                        } else {
                            Toast.makeText(StudentLoginActivity.this, "Email or Password Incorrect", Toast.LENGTH_SHORT).show();

                        }
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

}
