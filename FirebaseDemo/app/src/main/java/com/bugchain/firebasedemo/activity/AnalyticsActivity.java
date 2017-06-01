package com.bugchain.firebasedemo.activity;
/*
 * Created by BugChain on 5/31/17.
 * chain.chaiyaphat@gmail.com
 */

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.bugchain.firebasedemo.R;
import com.google.firebase.messaging.FirebaseMessaging;

public class AnalyticsActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analytics);

        findViewById(R.id.btnSubScribeNews).setOnClickListener(this);
        findViewById(R.id.btnUnSubScribeNews).setOnClickListener(this);

    }

    private void subScribeNews(){
        FirebaseMessaging.getInstance().subscribeToTopic("news");
        Toast.makeText(this,"SubScribe news",Toast.LENGTH_SHORT).show();
    }
    private void unSubScribeNews(){
        FirebaseMessaging.getInstance().unsubscribeFromTopic("news");
        Toast.makeText(this,"UnSubScribe news",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnSubScribeNews:
                    subScribeNews();
                break;
            case R.id.btnUnSubScribeNews:
                    unSubScribeNews();
                break;
        }
    }
}
