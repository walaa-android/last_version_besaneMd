package com.example.besanemd.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.UnderlineSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.besanemd.R;
import com.example.besanemd.fragments.DatePickerFragment;
import com.example.besanemd.ui.login.LoginActivity;

public class RegisterActivity extends AppCompatActivity {
 TextView textView , textViewLogin;
 EditText editTextPassword , editTextPasswordConfirm;
 ImageView imageViewShowPassword , imageViewShowPasswordConfirm ;
    ImageView imageViewBack;
 Button register ;
 private int passwordNotVisible=0;
 EditText editTextDateOfBirth;
 Button maleSelected, femaleSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        textViewLogin = findViewById(R.id.textViewLogin);
        textView = findViewById(R.id.textView);
        editTextDateOfBirth=findViewById(R.id.editTextDateOfBirth);
        editTextPassword = findViewById(R.id.editTextPassword);
        editTextPasswordConfirm = findViewById(R.id.editTextPasswordConfirm);
        imageViewBack = findViewById(R.id.imageViewBack);
        imageViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        imageViewShowPassword =findViewById(R.id.imageViewShowPassword);
        imageViewShowPasswordConfirm = findViewById(R.id.imageViewShowPasswordConfirm);
        register = findViewById(R.id.register);

      // femaleSelected= findViewById(R.id.femaleSelected);
      //  maleSelected = findViewById(R.id.maleSelected);


        SpannableStringBuilder builder = new SpannableStringBuilder();
        SpannableString str1= new SpannableString("Besane ");
        str1.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.colorPrimaryDark)), 0, str1.length(), 0);
        builder.append(str1);

        SpannableString str2= new SpannableString("Md");
        str2.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.colorBlack)), 0, str2.length(), 0);
        builder.append(str2);
        textView.setText( builder, TextView.BufferType.SPANNABLE);

        SpannableString spannableStringObject= new SpannableString("Login");
        spannableStringObject.setSpan(new UnderlineSpan(), 0,
                spannableStringObject.length(), 0);
        textViewLogin.setText(spannableStringObject);


       imageViewShowPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (passwordNotVisible == 1) {
                    imageViewShowPassword.setImageResource(R.drawable.hidden_eye);
                    editTextPassword.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    passwordNotVisible = 0;
                } else {
                    imageViewShowPassword.setImageResource(R.drawable.feather_eye_icon);
                    editTextPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    passwordNotVisible = 1;
                }
                editTextPassword.setSelection(editTextPassword.length());
            }
        });

        imageViewShowPasswordConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (passwordNotVisible == 1) {
                    imageViewShowPasswordConfirm.setImageResource(R.drawable.hidden_eye);
                    editTextPasswordConfirm.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    passwordNotVisible = 0;
                } else {
                    imageViewShowPasswordConfirm.setImageResource(R.drawable.feather_eye_icon);
                    editTextPasswordConfirm.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    passwordNotVisible = 1;
                }
                editTextPasswordConfirm.setSelection(editTextPasswordConfirm.length());

            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent regIntent = new Intent(RegisterActivity.this , MainActivity.class);
                startActivity(regIntent);
            }
        });
        textViewLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent logIntent = new Intent(RegisterActivity.this , LoginActivity.class);
                startActivity(logIntent);
            }
        });

        editTextDateOfBirth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment newFragment = new DatePickerFragment();
                newFragment.show(getSupportFragmentManager(), "datePicker");

            }
        });

    }

}