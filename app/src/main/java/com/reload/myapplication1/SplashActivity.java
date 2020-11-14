package com.reload.myapplication1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {

    private static int SPLASH_SCREEN=3000;
    //variables
Animation TopAnimation,BottomAnimation;
ImageView image;
TextView logo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // to hide stauts bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);
        //Animations
        TopAnimation= AnimationUtils.loadAnimation(this,R.anim.top_animation);
        BottomAnimation=AnimationUtils.loadAnimation(this,R.anim.bottom_animation);

        image=findViewById(R.id.image);
        logo=findViewById(R.id.logo);
        image.setAnimation(TopAnimation);
        logo.setAnimation(BottomAnimation);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i=new Intent(SplashActivity.this, LogInActivity.class);
                startActivity(i);
                finish();

            }
        },SPLASH_SCREEN);
    }
}