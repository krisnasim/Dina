package com.dina.dina.activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.dina.dina.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterActivity extends AppCompatActivity {

    @BindView(R.id.btn_signup) Button signUpBut;
    @BindView(R.id.input_eml) EditText input_email;
    @BindView(R.id.input_pwd) EditText input_pwd;
    @BindView(R.id.input_phonenum) EditText input_phonenum;
    @BindView(R.id.register_screen_layout) TextView register_screen_layout;

    @OnClick(R.id.link_login)
    public void getLoginScreen() {
        //call for login Activity
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);

        Typeface myTypeface = Typeface.createFromAsset(getAssets(), "Claudia.otf");
        register_screen_layout.setTypeface(myTypeface);
    }
}
