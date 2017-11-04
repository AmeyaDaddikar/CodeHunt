package com.example.coldball.codehunt;

import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;

public class MainActivity extends FragmentActivity
        implements MainPage.OnFragmentInteractionListener{

    public static int CURRENT_LOCATION = 0;

    @Override
    public void onFragmentInteraction(Uri uri){

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.fragment_frame);

        if(fragment == null)
            fragment = new MainPage();

        fragmentManager.beginTransaction()
                .add(R.id.fragment_frame,fragment,"HOMEPAGE")
                .commit();

    }
}
