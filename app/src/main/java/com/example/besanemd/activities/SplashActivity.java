package com.example.besanemd.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;

import com.example.besanemd.R;
import com.example.besanemd.ui.login.LoginActivity;

public class SplashActivity extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spalsh);
        textView = findViewById(R.id.textView);

        SpannableStringBuilder builder = new SpannableStringBuilder();
        SpannableString str1= new SpannableString("Besane ");
        str1.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.colorPrimaryDark)), 0, str1.length(), 0);
        builder.append(str1);

        SpannableString str2= new SpannableString("Md");
        str2.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.colorBlack)), 0, str2.length(), 0);
        builder.append(str2);
        textView.setText( builder, TextView.BufferType.SPANNABLE);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent loginIntent = new Intent(SplashActivity.this , LoginActivity.class);
                startActivity(loginIntent);
                finish();
            }
        }, 4000);
    }
}