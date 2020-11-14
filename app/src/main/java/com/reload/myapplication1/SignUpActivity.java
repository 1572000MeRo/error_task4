package com.reload.myapplication1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class SignUpActivity extends AppCompatActivity {
 Button next_btn,login_btn;
 TextView title_signup;
 ImageView back_img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }
    public void callNextSignUpScreen(View view){
        next_btn=findViewById(R.id.btn_next_signup);
        login_btn=findViewById(R.id.btn_login_signup);
        back_img=findViewById(R.id.signup_back_button);
        title_signup=findViewById(R.id.tv_title_signup);



    }
}