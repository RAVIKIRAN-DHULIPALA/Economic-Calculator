package com.ravi.diminishmethod;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class savings extends AppCompatActivity {
    android.support.v7.widget.Toolbar toolbar;
    EditText et1,et2,et3,et4;
    Button but,b2;
    int i=0,g;
    double A,S,G,I;
    LinearLayout lay;
    TextView t1,t2,t3;
    String E,aa,b,c;
    AnimationDrawable animationDrawable;
    ConstraintLayout constraintLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_savings);
        toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        constraintLayout = (ConstraintLayout) findViewById(R.id.clay);
        animationDrawable = (AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(5000);
        animationDrawable.setExitFadeDuration(2000);
        animationDrawable.start();
        getSupportActionBar().setTitle("Annual savings");
        et1 = (EditText) findViewById(R.id.eT1);
        et2 = (EditText) findViewById(R.id.eT2);
        et3 = (EditText) findViewById(R.id.eT3);
        et4=(EditText)findViewById(R.id.eT4);
        but = (Button) findViewById(R.id.buon);
        b2 = (Button) findViewById(R.id.buon1);
        t1=(TextView)findViewById(R.id.t1);
        t2=(TextView)findViewById(R.id.t2);
        lay=(LinearLayout)findViewById(R.id.linearLayout);
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aa = et1.getText().toString();
                b = et2.getText().toString();
                c = et3.getText().toString();
                E = et4.getText().toString();
                if (!aa.equals("") && !b.equals("") && !c.equals("")) {
                    A = Double.valueOf(aa);
                    I = Double.valueOf(b);
                    g = Integer.valueOf(c);
                    double m = A;
                    while (i < g) {
                        G = (((A / 100) * I)) * 12;
                        S = A + G;
                        A =m+S;
                        i++;
                    }
                    final double []bc=new double[2];
                    bc[0]=A-m;
                    if (E.equals("")) {
                        lay.setVisibility(View.VISIBLE);
                        t1.setText("If Extended period is not filled by default it will take 0\nTotal Amount at the end of last term :" + (Math.round(bc[0] * 100.0) / 100.0));
                        int sd = 0;
                        double p = ((bc[0] / 100) * I) * 12 * sd;
                        A =bc[0]+p;
                        t2.setText("Total amount with Extended period :" + (Math.round(A * 100.0) / 100.0));
                        A=0.0;I=0.0;g=0;i=0;
                    } else if (!E.equals("")) {
                        lay.setVisibility(View.VISIBLE);
                        t1.setText("Total Amount at the end of last term :" + (Math.round(bc[0] * 100.0) / 100.0));
                        int sd = Integer.parseInt(E);
                        double p=bc[0];
                        while (sd>0) {
                            G = (((p / 100) * I)) * 12;
                            p = p + G;
                            sd--;
                        }
                        t2.setText("Total amount with Extended period :" + (Math.round(p * 100.0) / 100.0));
                        A=0.0;I=0.0;g=0;i=0;
                        E=null;
                        bc[0]=0.0;
                        sd=0;
                    } }else {
                        Toast.makeText(savings.this, "enter the above fields", Toast.LENGTH_LONG).show();
                    }

                }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et1.setText("");
                et2.setText("");
                et3.setText("");
                et4.setText("");
                lay.setVisibility(View.INVISIBLE);
                A=0.0;I=0.0;g=0;i=0;
                E=null;

            }
        });
        t3=(TextView)findViewById(R.id.textView6);
        t3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(savings.this,DefaultIntro.class).putExtra("extra","annual"));
            }
        });
        }
    @Override
    public void onBackPressed(){
        startActivity(new Intent(this,Main2Activity.class));
        overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
        finish();
    }
}
