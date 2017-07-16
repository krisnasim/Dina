package com.dina.dina.activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.dina.dina.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.input_email) EditText input_email;
    @BindView(R.id.input_password) EditText input_pwd;
    @BindView(R.id.btn_login) Button btn_login;
    @BindView(R.id.link_signup) TextView link_signup;
    @BindView(R.id.link_skip_login) TextView link_skip_login;
    @BindView(R.id.login_screen_title) TextView login_screen_title;

    //set click listener to login button
    @OnClick(R.id.btn_login)
    public void clickToLogin(View view) {
        String email = input_email.getText().toString();
        String pwd = input_pwd.getText().toString();

        if(email.matches("jonathan") && pwd.matches("dina2017")) {
            //call new Intent
            Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(this, "oops, wrong credentials! Try again please", Toast.LENGTH_SHORT).show();
        }
    }

    @OnClick(R.id.link_skip_login)
    public void skipLogin() {
        //starting the home activity
        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
        startActivity(intent);
    }

    //set click listener to signup textview
    @OnClick(R.id.link_signup)
    public void clickToSignup(View view) {
        //starting the signup activity
        Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        Typeface myTypeface = Typeface.createFromAsset(getAssets(), "Claudia.otf");
        login_screen_title.setTypeface(myTypeface);
    }
}
