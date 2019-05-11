package com.ravi.diminishmethod;



import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.github.paolorotolo.appintro.AppIntro;
import com.github.paolorotolo.appintro.AppIntroFragment;
import com.github.paolorotolo.appintro.model.SliderPage;

public class DefaultIntro extends AppIntro {
    String val;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        val=getIntent().getStringExtra("extra");
        if(val.equals("interest")){
        SliderPage sliderPage1 = new SliderPage();
        sliderPage1.setTitle("How to use interest Calci");
        sliderPage1.setDescription("To calculate the Total interest of the loan amount taken with a interest and committed to pay the emi of your choice..");
        sliderPage1.setBgColor(Color.TRANSPARENT);
        addSlide(AppIntroFragment.newInstance(sliderPage1));

        SliderPage sliderPage2 = new SliderPage();
        sliderPage2.setTitle("Loan amount");
        sliderPage2.setDescription("Enter the loan amount");
        sliderPage2.setImageDrawable(R.drawable.img1);
        sliderPage2.setBgColor(Color.TRANSPARENT);
        addSlide(AppIntroFragment.newInstance(sliderPage2));

        SliderPage sliderPage3 = new SliderPage();
        sliderPage3.setTitle("Interest");
        sliderPage3.setDescription("Enter the interest of your loan");
        sliderPage3.setImageDrawable(R.drawable.img2);
        sliderPage3.setBgColor(Color.TRANSPARENT);
        addSlide(AppIntroFragment.newInstance(sliderPage3));

        SliderPage sliderPage4 = new SliderPage();
            sliderPage4.setTitle("EMI");
            sliderPage4.setDescription("Enter the installment you want to pay every month");
            sliderPage4.setImageDrawable(R.drawable.img3);
            sliderPage4.setBgColor(Color.TRANSPARENT);
            addSlide(AppIntroFragment.newInstance(sliderPage4));
    }
    else if(val.equals("annual")){
            SliderPage sliderPage1 = new SliderPage();
            sliderPage1.setTitle("How to use Annual Savings");
            sliderPage1.setDescription("To calculate the Annual savings of the amount after the completion of the specified time period(with and without the extended period)");
            sliderPage1.setBgColor(Color.TRANSPARENT);
            addSlide(AppIntroFragment.newInstance(sliderPage1));

            SliderPage sliderPage2 = new SliderPage();
            sliderPage2.setTitle("Amount");
            sliderPage2.setDescription("Enter the amount per year..");
            sliderPage2.setImageDrawable(R.drawable.img4);
            sliderPage2.setBgColor(Color.TRANSPARENT);
            addSlide(AppIntroFragment.newInstance(sliderPage2));

            SliderPage sliderPage3 = new SliderPage();
            sliderPage3.setTitle("Interest");
            sliderPage3.setDescription("Enter interest per year for the amount");
            sliderPage3.setImageDrawable(R.drawable.img5);
            sliderPage3.setBgColor(Color.TRANSPARENT);
            addSlide(AppIntroFragment.newInstance(sliderPage3));

            SliderPage sliderPage4 = new SliderPage();
            sliderPage4.setTitle("No of years");
            sliderPage4.setDescription("enter the no of years of saving the amount");
            sliderPage4.setImageDrawable(R.drawable.img6);
            sliderPage4.setBgColor(Color.TRANSPARENT);
            addSlide(AppIntroFragment.newInstance(sliderPage4));

            SliderPage sliderPage5 = new SliderPage();
            sliderPage5.setTitle("Extended period");
            sliderPage5.setDescription("Enter the extended period of your amount saving\nfill this only if you want to extend the period\n other wise dont fill this....\n\n If this field is not filled it will take by default 0");
            sliderPage5.setImageDrawable(R.drawable.img7);
            sliderPage5.setBgColor(Color.TRANSPARENT);
            addSlide(AppIntroFragment.newInstance(sliderPage5));
        }
    }

    @Override
    public void onSkipPressed(Fragment currentFragment) {
        //super.onSkipPressed(currentFragment);
        val=getIntent().getStringExtra("extra");
        if(val.equals("interest")){startActivity(new Intent(this,input.class));overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);}
        else if(val.equals("annual")){startActivity(new Intent(this,savings.class));overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);}
    }

    @Override
    public void onDonePressed(Fragment currentFragment) {
        val=getIntent().getStringExtra("extra");
        if(val.equals("interest")){startActivity(new Intent(this,input.class));overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);}
        else if(val.equals("annual")){startActivity(new Intent(this,savings.class));overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);}

    }
}

