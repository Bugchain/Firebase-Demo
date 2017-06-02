package com.bugchain.firebasedemo.activity.auth;
/*
 * Created by BUG CHAIN on 01/06/2017.
 * ARIP Public Company Limited
 * Bangkok, Thailand
 */

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.bugchain.firebasedemo.R;
import com.bugchain.firebasedemo.activity.MainActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        findViewById(R.id.btnLogin).setOnClickListener(this);
        findViewById(R.id.btnForgotPassword).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnLogin:
                loginProcess();
                break;
            case R.id.btnForgotPassword:
                    startActivity(new Intent(LoginActivity.this, ResetPasswordActivity.class));
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
        EditText textPassword = (EditText)findViewById(R.id.textPassword);
        String password = textPassword.getText().toString();
        if(password.length() == 0){
            textPassword.requestFocus();
            showToast("Enter password");
            return;
        }
        showProgressDialog();
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        hideProgressDialog();
                        if(task.isSuccessful()){
                            showToast("Login success");
                            startMainActivity();
                        }else {
                            showToast("Login failed.");
                        }
                    }
                });
    }

    private void startMainActivity(){
        Intent intent = new Intent(this,MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
    }


    private void showToast(String message){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }

    private void showProgressDialog(){
        if(progressDialog == null){
            progressDialog = new ProgressDialog(this);
            progressDialog.setCancelable(false);
            progressDialog.setMessage("Please wait...");
        }
        progressDialog.show();
    }

    private void hideProgressDialog(){
        if(progressDialog != null && progressDialog.isShowing()){
            progressDialog.dismiss();
            progressDialog = null;
        }
    }

}
