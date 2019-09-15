package com.infymark.introductionslider;

import android.os.Build;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

public class WelcomeActivity extends AppCompatActivity {

    private ViewPager mPager;

    private int[] layouts =

            {
                    R.layout.first_slide, R.layout.second_slide, R.layout.third_slide, R.layout.fourth_slide
            };


    private MPageAdapter mPageAdapter;


    //For circular page indicator
    private LinearLayout Dots_Layout;
    private ImageView[] dots;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Condition for  making the status for transparent

        if (Build.VERSION.SDK_INT >= 19) {

            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        } else {

            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        }

        setContentView(R.layout.activity_welcome);

        mPager = (ViewPager) findViewById(R.id.viewPager);

        mPageAdapter = new MPageAdapter(layouts, this);

        mPager.setAdapter(mPageAdapter);



        //For circular page indicator

        Dots_Layout = (LinearLayout) findViewById(R.id.dotsLayout);

        //createDots(0);

       /* mPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                Log.d("INFY", "onPageScrolled:   Welcome Activity");


            }

            @Override
            public void onPageSelected(int position) {
                Log.d("INFY", "onPageSelected:     Welcome Activity");
                createDots(position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {
                Log.d("INFY", "onPageScrollStateChanged:  Welcome Activity");

            }
        });*/
    }


    private void createDots(int current_position) {


        if (Dots_Layout != null)
            Dots_Layout.removeAllViews();

        dots = new ImageView[layouts.length];

        for (int i = 0; i < layouts.length; i++) {

            dots[i] = new ImageView(this);

            if (i == current_position) {
                dots[i].setImageDrawable(ContextCompat.getDrawable(this, R.drawable.active_dots));
            } else {
                dots[i].setImageDrawable(ContextCompat.getDrawable(this, R.drawable.default_dots));
            }

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

            params.setMargins(4, 0, 4, 0);

            Dots_Layout.addView(dots[i], params);

        }


    }
}
