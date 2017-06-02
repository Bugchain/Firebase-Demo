package com.bugchain.firebasedemo.activity.auth;
/*
 * Created by BUG CHAIN on 01/06/2017.
 * ARIP Public Company Limited
 * Bangkok, Thailand
 */

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.bugchain.firebasedemo.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ResetPasswordActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        findViewById(R.id.btnResetPassword).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnResetPassword:
                    sendResetPassword();
                break;
        }
    }

    private void sendResetPassword(){
        EditText textEmail = (EditText)findViewById(R.id.textEmail);
        String email = textEmail.getText().toString();
        if(email.length() == 0){
            textEmail.requestFocus();
            showToast("Enter email");
            return;
        }
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        firebaseAuth.sendPasswordResetEmail(email)
                .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Log.w("TAG", "sendPasswordResetEmail:success");
                            showToast("Check your email, and reset password.");
                            finish();
                        }else {
                            Log.w("TAG", "sendPasswordResetEmail:failure", task.getException());
                            showToast("sendPasswordResetEmail failure.");
                        }
                    }
                });
    }

    private void showToast(String message){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }


}
