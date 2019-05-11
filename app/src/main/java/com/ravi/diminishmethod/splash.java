package com.ravi.diminishmethod;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import static android.content.Context.MODE_PRIVATE;

public class splash extends AppCompatActivity {
    private final int SPLASH_DISPLAY_LENGTH = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_splash);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent mainIntent = new Intent(splash.this, Main2Activity.class);
                    splash.this.startActivity(mainIntent);
                    splash.this.finish();
                }
            }, SPLASH_DISPLAY_LENGTH);
        }
        }



