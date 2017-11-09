package com.example.coldball.codehunt;

import android.content.SharedPreferences;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;

public class MainActivity extends SingleFragmentActivity {

    public static int CURRENT_LOCATION = 0;
    public static final String PREFS_NAME= "MyPrefsFile";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public Fragment createFragment() {
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        CURRENT_LOCATION = settings.getInt("fragment_value", 0);
        switch (CURRENT_LOCATION){
            case 0 : return new MainPage();
            case 1 : return new Question1();

        }
        return null;
    }
}
