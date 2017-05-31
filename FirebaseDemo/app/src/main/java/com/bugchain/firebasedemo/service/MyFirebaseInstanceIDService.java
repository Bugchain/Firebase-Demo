package com.bugchain.firebasedemo.service;
/*
 * Created by BugChain on 5/31/17.
 * chain.chaiyaphat@gmail.com
 */

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

public class MyFirebaseInstanceIDService extends FirebaseInstanceIdService{

    private static final String TAG = MyFirebaseInstanceIDService.class.getSimpleName();

    @Override
    public void onTokenRefresh() {
        super.onTokenRefresh();

        String refreshToken = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG,"Refresh token : " + refreshToken);
    }

    private void setTokenToServer(String token){
        // Add custom implementation, as needed.
    }

}
