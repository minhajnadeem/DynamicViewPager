package com.example.minhaj.dynamicviewpager;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        MyViewPagerAdapter myViewPagerAdapter = new MyViewPagerAdapter();
        viewPager.setAdapter(myViewPagerAdapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Log.d("tag","page "+position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}

class MyViewPagerAdapter extends PagerAdapter{
    private final int TV_ID = 1;

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        RelativeLayout relativeLayout = new RelativeLayout(container.getContext());
        relativeLayout.setLayoutParams(new ViewPager.LayoutParams());
        TextView textView = new TextView(container.getContext());
        textView.setId(TV_ID);
        textView.setPadding(8,8,8,8);
        textView.setGravity(Gravity.CENTER);
        textView.setTextColor(ColorStateList.valueOf(Color.WHITE));
        RelativeLayout.LayoutParams textViewLayoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
        textViewLayoutParams.addRule(RelativeLayout.CENTER_IN_PARENT);
        textView.setLayoutParams(textViewLayoutParams);

        Button button = new Button(container.getContext());
        RelativeLayout.LayoutParams btnParam = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
        btnParam.addRule(RelativeLayout.CENTER_HORIZONTAL);

        button.setText("btn");
        if (position == 0) {
            textView.setText("Hello one");
            textView.setBackgroundColor(Color.RED);
            btnParam.addRule(RelativeLayout.ABOVE,textView.getId());
        }else {
            textView.setText("Hello Two");
            textView.setBackgroundColor(Color.BLUE);
            btnParam.addRule(RelativeLayout.BELOW,textView.getId());
        }
        button.setLayoutParams(btnParam);
        relativeLayout.addView(textView);
        relativeLayout.addView(button);
        container.addView(relativeLayout);
        return relativeLayout;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}