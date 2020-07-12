package com.example.besanemd.activities;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.example.besanemd.R;

public class ChooseTestResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_test_result);
    }




    public void nextToChooseResult(View view) {
        Intent intent = new Intent(ChooseTestResultActivity.this , HomeActivity.class);
        startActivity(intent);
    }

    public void back(View view) {
        onBackPressed();
    }
}