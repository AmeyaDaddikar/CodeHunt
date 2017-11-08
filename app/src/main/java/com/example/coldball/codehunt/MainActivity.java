package com.example.coldball.codehunt;

import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;

public class MainActivity extends FragmentActivity
        implements MainPage.OnFragmentInteractionListener{

    public static int CURRENT_LOCATION = 0;
    public static final String PREFS_NAME= "MyPrefsFile";

    @Override
    public void onFragmentInteraction(Uri uri){

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences settings = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        CURRENT_LOCATION = settings.getInt("fragment_value", 0);
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.fragment_frame);

        if(fragment == null) {
            //fragment = new MainPage();
            switch(CURRENT_LOCATION){
                case 0 :    fragment = new MainPage();
                            break;
                case 1 :    fragment = new Question1();
                            break;
            }
        }

        fragmentManager.beginTransaction()
                .add(R.id.fragment_frame,fragment,"HOMEPAGE")
                .commit();

    }
}
