package com.infymark.mylibrary;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

import static androidx.core.content.ContextCompat.getDrawable;

public class CircularPageIndicator extends LinearLayout implements ViewPager.OnPageChangeListener {

    private ImageView[] dots;
    private LinearLayout Dots_Layout;
    private int length=10;

    public CircularPageIndicator(Context context) {
        super(context);
        init(context);
    }


    public CircularPageIndicator(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public CircularPageIndicator(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public CircularPageIndicator(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    private void init(Context context) {

        Log.d("INFY", "init: CircularPageIndicator");
        Log.d("INFY", "onFinishInflate: CircularPageIndicator");
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.dots_layout, null);
        Dots_Layout = (LinearLayout) findViewById(R.id.dotsLayout);
        createDots(0);

    }

/*
    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        Log.d("INFY", "onFinishInflate: CircularPageIndicator");
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.dots_layout, null);
        Dots_Layout = (LinearLayout) findViewById(R.id.dotsLayout);
        createDots(0);
    }
*/

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        Log.d("INFY", "onPageScrolled: CircularPageIndicator");
    }

    @Override
    public void onPageSelected(int position) {
        createDots(position);
        Log.d("INFY", "onPageSelected: createDots()" +position );
        Log.d("INFY", "onPageSelected: CircularPageIndicator");
    }

    @Override
    public void onPageScrollStateChanged(int state) {
        Log.d("INFY", "onPageScrollStateChanged: CircularPageIndicator");

    }


    private void createDots(int current_position) {
        Log.d("INFY", "current_position: CircularPageIndicator");

        if (Dots_Layout != null)
            Dots_Layout.removeAllViews();

        dots = new ImageView[length];

        for (int i = 0; i < length; i++) {
            Log.d("INFY", "length: CircularPageIndicator "+ i);

            dots[i] = new ImageView(getContext());

            if (i == current_position) {
                dots[i].setImageDrawable(getDrawable(getContext(), R.drawable.active_dots));
            } else {
                dots[i].setImageDrawable(getDrawable(getContext(), R.drawable.default_dots));
            }

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

            params.setMargins(4, 0, 4, 0);

            Dots_Layout.addView(dots[i], params);

        }


    }
}
