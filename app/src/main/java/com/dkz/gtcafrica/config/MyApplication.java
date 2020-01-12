package com.dkz.gtcafrica.config;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;

import com.dkz.gtcafrica.R;
import com.dkz.gtcafrica.model.ui.StudentMenu;
import com.pixplicity.easyprefs.library.Prefs;

import java.util.ArrayList;
import java.util.Arrays;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        new Prefs.Builder()
                .setContext(this)
                .setMode(ContextWrapper.MODE_PRIVATE)
                .setPrefsName(getPackageName())
                .setUseDefaultSharedPreference(true)
                .build();
        

    }


}
