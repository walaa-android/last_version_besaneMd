package com.example.besanemd.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;

import com.example.besanemd.R;

public class AboutUsActivity extends AppCompatActivity {
TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        textView = findViewById(R.id.textView);

        SpannableStringBuilder builder = new SpannableStringBuilder();
        SpannableString str1= new SpannableString("Besane ");
        str1.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.colorPrimaryDark)), 0, str1.length(), 0);
        builder.append(str1);

        SpannableString str2= new SpannableString("Md");
        str2.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.colorBlack)), 0, str2.length(), 0);
        builder.append(str2);
        textView.setText( builder, TextView.BufferType.SPANNABLE);

    }

    public void back(View view) {
       onBackPressed();
    }
}