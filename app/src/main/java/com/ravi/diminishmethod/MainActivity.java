package com.ravi.diminishmethod;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.AnimationDrawable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    android.support.v7.widget.Toolbar toolbar;
    ListView listView;
    private List List=new ArrayList();
    ArrayAdapter adapter;
    Button b1,b2;
    double[] n=new double[2];
    double Int,m;
    ConstraintLayout constraintLayout;
    AnimationDrawable animationDrawable;
    private AdView madview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("OUTPUT");
         constraintLayout=(ConstraintLayout)findViewById(R.id.clay1);
         animationDrawable=(AnimationDrawable)constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(5000);
        animationDrawable.setExitFadeDuration(2000);
        animationDrawable.start();
        b1=(Button)findViewById(R.id.button3);
        b2=(Button)findViewById(R.id.button4);
        listView=(ListView)findViewById(R.id.lst);
        double []b=getIntent().getDoubleArrayExtra("cap");
        n=getIntent().getDoubleArrayExtra("monint");
        m=n[0]; Int=n[1];
        for(int i=0;i<b.length;i++){
            if(b[i]!=0 && b[i]>0){
                //noinspection unchecked
                    List.add((i + 1) + " month -> Capital* : " + String.valueOf(b[i]));
        }}
        List.add("Total Intrest Paid  : "+Int);
        List.add("Total No.of Months Required to Finish  : "+m);
        adapter=new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1,List);
        listView.setAdapter(adapter);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,input.class);
                List.clear();
                startActivity(intent);
                overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
                finish();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               startActivity(new Intent(MainActivity.this,Main2Activity.class));
                overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
               finish();
            }
        });

        madview = findViewById(R.id.adView);
        AdRequest adRequest1 = new AdRequest.Builder().build();
        madview.loadAd(adRequest1);
    }

    @Override
    public void onConfigurationChanged(Configuration newconfig){
        super.onConfigurationChanged(newconfig);
        if(newconfig.orientation==Configuration.ORIENTATION_PORTRAIT){
            Toast.makeText(MainActivity.this,"Auto Rotation is not allowed",Toast.LENGTH_LONG).show();
    }
    }

    @Override
    public void onBackPressed(){Toast.makeText(MainActivity.this,"press exit to close or press back to edit",Toast.LENGTH_LONG).show();}
}
