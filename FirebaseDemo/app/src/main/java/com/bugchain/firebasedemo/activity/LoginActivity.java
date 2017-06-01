package com.bugchain.firebasedemo.activity;
/*
 * Created by BUG CHAIN on 01/06/2017.
 * ARIP Public Company Limited
 * Bangkok, Thailand
 */

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.bugchain.firebasedemo.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        findViewById(R.id.btnLogin).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnLogin:
                loginProcess();
                break;
        }
    }

    private void loginProcess(){
        EditText textEmail = (EditText)findViewById(R.id.textEmail);
        String email = textEmail.getText().toString();
        if(email.length() == 0){
            textEmail.requestFocus();
            showToast("Enter email");
            return;
        }
        EditText textPassword = (EditText)findViewById(R.id.textEmail);
        String password = textPassword.getText().toString();
        if(password.length() == 0){
            textPassword.requestFocus();
            showToast("Enter password");
            return;
        }
    }

    private void showToast(String message){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }
}
