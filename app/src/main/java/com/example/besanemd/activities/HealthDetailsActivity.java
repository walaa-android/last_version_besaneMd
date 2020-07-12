package com.example.besanemd.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.besanemd.R;

public class HealthDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_daetiles);
    }




    public void nextToChooseResult(View view) {
        Intent intent = new Intent(HealthDetailsActivity.this , ChooseTestResultActivity.class);
        startActivity(intent);
    }

    public void back(View view) {
        onBackPressed();
    }
}