package com.example.coldball.codehunt;

import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;

public class MainActivity extends SingleFragmentActivity {

    public static int CURRENT_LOCATION = 0;
    public static final String PREFS_NAME= "MyPrefsFile";

    public static final String[] QUESTION_LIST = {"defaultext",
            "QUESTION 1",
            "QUESTION 2",
            "QUESTION 3",
            "QUESTION 4",
            "QUESTION 5"};

    public static final String[] PASSWORD = {"0","1","2","3","4","5"};

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
            case 1 :
            case 2 :
            case 3 :
            case 4 :
            case 5 :return new Question();

        }
        return null;
    }
}
