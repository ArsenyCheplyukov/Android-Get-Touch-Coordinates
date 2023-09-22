package com.arsenyvoid.touchcoordinates;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.view.MotionEvent;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView imgFavorite = findViewById(R.id.viewImage);
        imgFavorite.setClickable(true);
        imgFavorite.setEnabled(true);
        imgFavorite.setFocusable(true);
        imgFavorite.setFocusableInTouchMode(true);
        imgFavorite.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                if (event != null) {
                    if (MotionEvent.ACTION_UP == event.getAction()) {
                        view.performClick();
                        float[] location = new float[2];
                        location[0] = event.getX();
                        location[1] = event.getY();
                        //imgFavorite.getLocationOnScreen(location);
                        Toast.makeText(MainActivity.this, "X axis is " + location[0] + " and Y axis is " + location[1], Toast.LENGTH_LONG).show();
                    }
                    return true;
                }
                return false;
            }
        });
    }
}