package com.bugchain.firebasedemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnAuthentication).setOnClickListener(this);
        findViewById(R.id.btnCloudMessaging).setOnClickListener(this);
        findViewById(R.id.btnRealTimeDatabase).setOnClickListener(this);
        findViewById(R.id.btnCrashReporting).setOnClickListener(this);
        findViewById(R.id.btnGoogleAnalytics).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnGoogleAnalytics:
                    startActivity(new Intent(MainActivity.this, MAnalyticsActivity.class));
                break;
        }
    }
}
