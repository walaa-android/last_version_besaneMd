package com.example.besanemd.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.besanemd.R;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
    }

    public void nextToHome(View view) {
        Intent homeIntent = new Intent(this , HomeActivity.class);
        startActivity(homeIntent);
    }
}