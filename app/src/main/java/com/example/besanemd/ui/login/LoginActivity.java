package com.example.besanemd.ui.login;

import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.text.InputType;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.besanemd.activities.MainActivity;
import com.example.besanemd.R;
import com.example.besanemd.activities.RegisterActivity;

public class LoginActivity extends AppCompatActivity {

    private LoginViewModel loginViewModel;

    TextView textView ,  textViewReg ;
    EditText editTextPassword;
    ImageView imageViewShow ;
    private int passwordNotVisible=0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginViewModel = ViewModelProviders.of(this, new LoginViewModelFactory())
                .get(LoginViewModel.class);

        textView = findViewById(R.id.textView);
        textViewReg =findViewById(R.id.textViewReg);
        editTextPassword=findViewById(R.id.editTextPassword);
        imageViewShow = findViewById(R.id.imageViewShow);

        imageViewShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (passwordNotVisible == 1) {
                    imageViewShow.setImageResource(R.drawable.hidden_eye);
                    editTextPassword.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    passwordNotVisible = 0;
                } else {
                    imageViewShow.setImageResource(R.drawable.feather_eye_icon);
                    editTextPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    passwordNotVisible = 1;
                }


                editTextPassword.setSelection(editTextPassword.length());

            }
        });


        SpannableStringBuilder builder = new SpannableStringBuilder();
        SpannableString str1= new SpannableString("Besane ");
        str1.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.colorPrimaryDark)), 0, str1.length(), 0);
        builder.append(str1);

        SpannableString str2= new SpannableString("Md");
        str2.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.colorBlack)), 0, str2.length(), 0);
        builder.append(str2);
        textView.setText( builder, TextView.BufferType.SPANNABLE);



        SpannableString spannableStringObject= new SpannableString("Register");
        spannableStringObject.setSpan(new UnderlineSpan(), 0,
                spannableStringObject.length(), 0);
        textViewReg.setText(spannableStringObject);




    }



    /*    final EditText usernameEditText = findViewById(R.id.username);
        final EditText passwordEditText = findViewById(R.id.password);
        final Button loginButton = findViewById(R.id.login);
        final ProgressBar loadingProgressBar = findViewById(R.id.loading);

        loginViewModel.getLoginFormState().observe(this, new Observer<LoginFormState>() {
            @Override
            public void onChanged(@Nullable LoginFormState loginFormState) {
                if (loginFormState == null) {
                    return;
                }
                loginButton.setEnabled(loginFormState.isDataValid());
                if (loginFormState.getUsernameError() != null) {
                    usernameEditText.setError(getString(loginFormState.getUsernameError()));
                }
                if (loginFormState.getPasswordError() != null) {
                    passwordEditText.setError(getString(loginFormState.getPasswordError()));
                }
            }
        });

        loginViewModel.getLoginResult().observe(this, new Observer<LoginResult>() {
            @Override
            public void onChanged(@Nullable LoginResult loginResult) {
                if (loginResult == null) {
                    return;
                }
                loadingProgressBar.setVisibility(View.GONE);
                if (loginResult.getError() != null) {
                    showLoginFailed(loginResult.getError());
                }
                if (loginResult.getSuccess() != null) {
                    updateUiWithUser(loginResult.getSuccess());
                }
                setResult(Activity.RESULT_OK);

                //Complete and destroy login activity once successful
                finish();
            }
        });

        TextWatcher afterTextChangedListener = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // ignore
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // ignore
            }

            @Override
            public void afterTextChanged(Editable s) {
                loginViewModel.loginDataChanged(usernameEditText.getText().toString(),
                        passwordEditText.getText().toString());
            }
        };
        usernameEditText.addTextChangedListener(afterTextChangedListener);
        passwordEditText.addTextChangedListener(afterTextChangedListener);
        passwordEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {

            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    loginViewModel.login(usernameEditText.getText().toString(),
                            passwordEditText.getText().toString());
                }
                return false;
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadingProgressBar.setVisibility(View.VISIBLE);
                loginViewModel.login(usernameEditText.getText().toString(),
                        passwordEditText.getText().toString());
            }
        });
    }

    private void updateUiWithUser(LoggedInUserView model) {
        String welcome = getString(R.string.welcome) + model.getDisplayName();
        // TODO : initiate successful logged in experience
        Toast.makeText(getApplicationContext(), welcome, Toast.LENGTH_LONG).show();
    }

    private void showLoginFailed(@StringRes Integer errorString) {
        Toast.makeText(getApplicationContext(), errorString, Toast.LENGTH_SHORT).show();
    }

     */


    public void register(View view) {
        Intent regIntent = new Intent(LoginActivity.this , RegisterActivity.class);
        startActivity(regIntent);
    }

    public void Login(View view) {
        Intent regIntent = new Intent(LoginActivity.this , MainActivity.class);
        startActivity(regIntent);
    }

    public void showHidden(View view) {
   //   if (imageViewShow.text.toString().equals("Show")) {
   //       editTextPassword.transformationMethod = HideReturnsTransformationMethod.getInstance().
   //               image.text = "Hide";
   //   } else {
   //       editTextPassword.transformationMethod = PasswordTransformationMethod.getInstance()
   //       showHideBtn.text = "Show";
   //   }
    }
}
