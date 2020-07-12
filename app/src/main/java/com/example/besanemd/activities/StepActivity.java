package com.example.besanemd.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TabWidget;
import android.widget.TextView;

import com.example.besanemd.R;
import com.example.besanemd.adapter.StepTabsAdapter;
import com.google.android.material.tabs.TabLayout;

public class StepActivity extends AppCompatActivity {
    ViewPager view_pager;
    TabLayout indicator;
    StepTabsAdapter stepTabsAdapter;
    TextView textViewBack ,textNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step);
        textViewBack= findViewById(R.id.textViewBack);
        indicator = findViewById(R.id.indicator);
        view_pager= findViewById(R.id.view_pager);
        textNext = findViewById(R.id.textNext);

        textNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultIntent = new Intent(StepActivity.this ,HealthDetailsActivity.class);
                startActivity(resultIntent);
            }
        });

        stepTabsAdapter = new StepTabsAdapter(this , getSupportFragmentManager());
        view_pager.setPageTransformer(true, new ZoomOutPageTransformer());
        view_pager.setAdapter(stepTabsAdapter);
        indicator.setupWithViewPager(view_pager, true);

        textViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              onBackPressed();
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (view_pager.getCurrentItem() == 0){
            super.onBackPressed();
        } else {
            view_pager.setCurrentItem(view_pager.getCurrentItem() - 1);
        }
    }

    private static class ZoomOutPageTransformer implements ViewPager.PageTransformer {
        private static final float MIN_SCALE = 0.85f;
        private static final float MIN_ALPHA = 0.5f;

        public void transformPage(View view, float position) {
            int pageWidth = view.getWidth();
            int pageHeight = view.getHeight();

            if (position < -1) {

                view.setAlpha(0f);

            } else if (position <= 1) {

                float scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position));
                float vertMargin = pageHeight * (1 - scaleFactor) / 2;
                float horzMargin = pageWidth * (1 - scaleFactor) / 2;
                if (position < 0) {
                    view.setTranslationX(horzMargin - vertMargin / 2);
                } else {
                    view.setTranslationX(-horzMargin + vertMargin / 2);
                }

                view.setScaleX(scaleFactor);
                view.setScaleY(scaleFactor);

                view.setAlpha(MIN_ALPHA +
                        (scaleFactor - MIN_SCALE) /
                                (1 - MIN_SCALE) * (1 - MIN_ALPHA));

            } else {
                view.setAlpha(0f);
            }
        }
    }
}