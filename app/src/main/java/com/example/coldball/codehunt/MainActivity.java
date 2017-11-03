package com.example.coldball.codehunt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    static Button startButton;
    static TextView COCname;
    static ImageView COClogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        startButton = (Button) findViewById(R.id.start_button);
        COCname  = (TextView) findViewById(R.id.coc_name);
        COClogo = (ImageView) findViewById(R.id.coc_logo);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                COCname.setVisibility(View.GONE);
                COClogo.setVisibility(View.GONE);
                startButton.setVisibility(View.GONE);

            }
        });
    }
}
