package com.bugchain.firebasedemo.activity.auth;
/*
 * Created by BUG CHAIN on 02/06/2017.
 * ARIP Public Company Limited
 * Bangkok, Thailand
 */

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.bugchain.firebasedemo.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ProfileActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        updateProfile(FirebaseAuth.getInstance().getCurrentUser())
        ;
    }

    private void updateProfile(FirebaseUser user){
        if(user != null){
            TextView textEmail = (TextView)findViewById(R.id.textEmail);
            textEmail.setText(user.getEmail());
        }
    }
}
