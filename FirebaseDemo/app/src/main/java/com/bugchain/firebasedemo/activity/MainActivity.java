package com.bugchain.firebasedemo.activity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.bugchain.firebasedemo.PermissionUtils;
import com.bugchain.firebasedemo.R;
import com.bugchain.firebasedemo.Utils;
import com.bugchain.firebasedemo.activity.auth.LoginActivity;
import com.bugchain.firebasedemo.activity.auth.ProfileActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private static final int REQUEST_WRITE_STORAGE_PERMISSION = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnAuthentication).setOnClickListener(this);
        findViewById(R.id.btnCloudMessaging).setOnClickListener(this);
        findViewById(R.id.btnRealTimeDatabase).setOnClickListener(this);
        findViewById(R.id.btnCrashReporting).setOnClickListener(this);
        findViewById(R.id.btnGoogleAnalytics).setOnClickListener(this);
        findViewById(R.id.btnLogout).setOnClickListener(this);

        if(Utils.isAndroidVersionAboveMarshmallow()){
            if(!PermissionUtils.checkWriteStoragePermissionGranted(this)){
                PermissionUtils.requestWriteStoragePermission(this,REQUEST_WRITE_STORAGE_PERMISSION);
            }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnAuthentication:
                checkUserLogin();
                break;
            case R.id.btnGoogleAnalytics:
                    startActivity(new Intent(MainActivity.this, AnalyticsActivity.class));
                break;
            case R.id.btnCloudMessaging:
                    startActivity(new Intent(MainActivity.this, NotificationActivity.class));
                break;
            case R.id.btnLogout:
                    logoutApplication();
                break;
        }
    }

    private void showToast(String message){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }

    private void checkUserLogin(){
        FirebaseUser  user = FirebaseAuth.getInstance().getCurrentUser();
        if(user != null){
            startActivity(new Intent(MainActivity.this, ProfileActivity.class));
        }else {
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
        }
    }

    private void logoutApplication(){
        Log.d("TAG","--- Logout ---");
        FirebaseAuth.getInstance().signOut();
        showToast("Logout success.");
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == REQUEST_WRITE_STORAGE_PERMISSION){
            if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                showToast("Write storage permission granted.");
            }
        }

    }
}
