package com.example.coldball.codehunt;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

/**
 * Created by sanidhya on 9/11/17.
 */

public abstract class SingleFragmentActivity extends FragmentActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.fragment_frame);
        if(fragment == null){
            fragment = createFragment();
        }
        fragmentManager.beginTransaction()
                .add(R.id.fragment_frame,fragment,"HOMEPAGE")
                .commit();
    }

    public abstract Fragment createFragment();
}
