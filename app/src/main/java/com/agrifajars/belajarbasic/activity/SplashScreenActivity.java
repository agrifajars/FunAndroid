package com.agrifajars.belajarbasic.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.agrifajars.belajarbasic.MainActivity;
import com.agrifajars.belajarbasic.R;
import com.agrifajars.belajarbasic.activity.student.StudentActivity;
import com.agrifajars.belajarbasic.helper.DataConfig;

import androidx.appcompat.app.AppCompatActivity;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInsanceState) {
        super.onCreate(savedInsanceState);
        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (DataConfig.isLogin(SplashScreenActivity.this)){
                    startActivity(new Intent(SplashScreenActivity.this, StudentActivity.class));
                }else{
                    startActivity(new Intent(SplashScreenActivity.this, MainActivity.class));
                    finish();
                }
            }
        }, 1000);
    }
}
