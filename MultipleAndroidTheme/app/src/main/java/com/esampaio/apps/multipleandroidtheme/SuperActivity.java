package com.esampaio.apps.multipleandroidtheme;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by eduardo on 11/03/17.
 */

public class SuperActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        if (BuildConfig.app_theme.equals("AppThemeTwo")){
            setTheme(R.style.AppThemeTwo);
        }
        super.onCreate(savedInstanceState);
    }
}
