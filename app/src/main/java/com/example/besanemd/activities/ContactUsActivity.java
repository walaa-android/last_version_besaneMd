package com.example.besanemd.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.besanemd.R;

public class ContactUsActivity extends AppCompatActivity {
TextView textViewSendMassage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);
        textViewSendMassage = findViewById(R.id.textViewSendMassage);
        textViewSendMassage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(ContactUsActivity.this);
                dialog.setContentView(R.layout.massage_send_dialog);
                TextView imageViewDone = dialog.findViewById(R.id.imageViewDone);
                imageViewDone .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                       dialog.dismiss();
                    }
                });
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
                dialog.setCancelable(false);
            }
        });
    }

    public void back(View view) {
        onBackPressed();
    }
}