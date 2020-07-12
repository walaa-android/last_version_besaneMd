package com.example.besanemd.activities;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.besanemd.R;

public class MainActivity extends AppCompatActivity {
    TextView text_view_yes, text_view_no;
    ImageView close_icon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void test(View view) {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.travell_dialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        text_view_yes = dialog.findViewById(R.id.text_view_yes);
        text_view_no = dialog.findViewById(R.id.text_view_no);
        close_icon = dialog.findViewById(R.id.close_icon);
        close_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        text_view_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
          final Dialog dialogData = new Dialog(MainActivity.this);
                dialogData.setContentView(R.layout.data_of_travell);
                dialogData.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialogData.show();
                dialogData.setCancelable(false);
                TextView nextBtn = dialogData.findViewById(R.id.nextBtn);
                nextBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent stepIntent = new Intent(MainActivity.this , StepActivity.class);
                        startActivity(stepIntent);
                    }
                });
                ImageView close_icon = dialogData.findViewById(R.id.close_icon);
                close_icon.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialogData.dismiss();
                    }
                });

        }
                                         });

                text_view_no.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this, StepActivity.class);
                        startActivity(intent);
                    }
                });

                dialog.show();
                dialog.setCancelable(false);
    }
}