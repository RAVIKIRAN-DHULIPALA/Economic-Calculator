package com.ravi.diminishmethod;

import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.getkeepsafe.taptargetview.TapTarget;
import com.getkeepsafe.taptargetview.TapTargetSequence;
import com.getkeepsafe.taptargetview.TapTargetView;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class Main2Activity extends AppCompatActivity {
    android.support.v7.widget.Toolbar toolbar;
    TextView tv1;
    ImageButton ib1,ib2;
    boolean doubleBackToExitPressedOnce = false;
    private AdView madview2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Boolean isFirstRun = getSharedPreferences("PREFERENCE", MODE_PRIVATE)
                .getBoolean("isFirstRun", true);
        if (isFirstRun) {
            //show start activity
            new AlertDialog.Builder(this)
                    .setMessage("share the app link to your friends with share button and rate our app using rate button on the top...")
                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    }).create().show();
            getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit()
                    .putBoolean("isFirstRun", false).commit();
        }
        toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        tv1=(TextView)findViewById(R.id.vt1);
        String st="Calculation Logic by \n DurgaPrasad Siddani\n\nDesigned & Developed by \n Ravikiran Dhulipala\n";
        SpannableString ss=new SpannableString(st);
        ForegroundColorSpan fcsWhite=new ForegroundColorSpan(Color.BLACK);
        ss.setSpan(fcsWhite,23,44, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ForegroundColorSpan fcs=new ForegroundColorSpan(Color.BLACK);
        ss.setSpan(fcs,70,90,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        tv1.setText(ss);
        ib1=(ImageButton)findViewById(R.id.dim);
        ib1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Main2Activity.this,input.class));
            }
        });
        ib2=(ImageButton)findViewById(R.id.ans);
        ib2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Main2Activity.this,savings.class));
            }
        });
        madview2 = findViewById(R.id.adView1);
        AdRequest adRequest1 = new AdRequest.Builder().build();
        madview2.loadAd(adRequest1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.share:
                try {
                    Intent i=new Intent(Intent.ACTION_SEND);
                    i.setType("text/plain");
                    i.putExtra(Intent.EXTRA_SUBJECT,"Diminishing Interest");
                    String sAux="\n Let me Recommend you this application \n\n";
                    sAux=sAux+"https://play.google.com/store/apps/details?id=com.ravi.diminishmethod\n\n";
                    i.putExtra(Intent.EXTRA_TEXT,sAux);
                    startActivity(Intent.createChooser(i,"choose one"));
                    /*ApplicationInfo api = getApplicationContext().getApplicationInfo();
                    String apk = api.sourceDir;
                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.setType("application/vnd.android.package-archive");
                    intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(new File(apk)));
                    startActivity(Intent.createChooser(intent, "SHARE APP USING"));*/
                }catch(Exception e){}
                break;
            case R.id.rate:
                try{
                    Uri uri1=Uri.parse("market://details?id="+getPackageName());
                    Intent gotomark=new Intent(Intent.ACTION_VIEW,uri1);
                    startActivity(gotomark);

                }catch (Exception e){
                    Uri uri1=Uri.parse("https:play.google.com/store/apps/details?id="+getPackageName());
                    Intent gotomark=new Intent(Intent.ACTION_VIEW,uri1);
                    startActivity(gotomark);
                }

        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            moveTaskToBack(true);
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(0);
        }
        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 1000);
    }
}
