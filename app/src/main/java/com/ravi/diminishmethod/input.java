package com.ravi.diminishmethod;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.graphics.Paint;
import android.graphics.drawable.AnimationDrawable;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



public class input extends AppCompatActivity {
    android.support.v7.widget.Toolbar toolbar;
    EditText et1, et2, et3;
    Button b1, b2;
    int e, m = 0, k = 0;
    Double c, i, x, I = 0.0;
    double[] a = new double[10000];
    String e1, e2, e3;
    AnimationDrawable animationDrawable;
    ConstraintLayout constraintLayout;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
        toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Input");
        constraintLayout = (ConstraintLayout) findViewById(R.id.clay);
        animationDrawable = (AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(5000);
        animationDrawable.setExitFadeDuration(2000);
        animationDrawable.start();
        et1 = (EditText) findViewById(R.id.editText1);
        et2 = (EditText) findViewById(R.id.editText2);
        et3 = (EditText) findViewById(R.id.editText3);
        b1 = (Button) findViewById(R.id.button2);
        b2 = (Button) findViewById(R.id.button1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                e1 = et1.getText().toString();
                e2 = et2.getText().toString();
                e3 = et3.getText().toString();
                if (!e1.equals("") && !e2.equals("") && !e3.equals("")) {
                    c = Double.parseDouble(e1);
                    i = Double.parseDouble(e2);
                    e = Integer.parseInt(e3);
                    while (c > 0) {
                        x = (c / 100) * i;
                        I += x;
                        c += x;
                        c -= e;
                        m += 1;
                        a[k] = c;
                        k += 1;
                    }
                    double b[] = {m, I};
                    Intent intent = new Intent(input.this, MainActivity.class);
                    intent.putExtra("cap", a);
                    intent.putExtra("monint", b);
                    et1.setText("");
                    et2.setText("");
                    et3.setText("");
                    c = 0.0;
                    i = 0.0;
                    e = 0;
                    startActivity(intent);
                } else
                    Toast.makeText(input.this, "please fill the above details", Toast.LENGTH_LONG).show();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et1.setText("");
                et2.setText("");
                et3.setText("");
                    /*moveTaskToBack(true);
                    android.os.Process.killProcess(android.os.Process.myPid());
                    System.exit(1);*/
            }
        });
        tv=(TextView)findViewById(R.id.textView5);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(input.this,DefaultIntro.class).putExtra("extra","interest"));
            }
        });
    }

    @Override
    public void onConfigurationChanged(Configuration newconfig) {
        super.onConfigurationChanged(newconfig);
        if (newconfig.orientation == Configuration.ORIENTATION_LANDSCAPE)
            Toast.makeText(input.this, "Auto Rotation is not allowed", Toast.LENGTH_LONG).show();
    }
    @Override
    public void onBackPressed(){
        //super.onBackPressed();
        //startActivity(new Intent(input.this,Main2Activity.class));
        overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
        finish();
    }
}
