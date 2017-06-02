package com.bugchain.firebasedemo;
/*
 * Created by BUG CHAIN on 02/06/2017.
 * ARIP Public Company Limited
 * Bangkok, Thailand
 */

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

public class PermissionUtils {

    public static boolean checkWriteStoragePermissionGranted(Activity context){
        int writeStoragePermission = ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        return writeStoragePermission == PackageManager.PERMISSION_GRANTED;
    }

    public static void requestWriteStoragePermission(Activity context, int requestPermissionId){
        ActivityCompat.requestPermissions(context,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},requestPermissionId);
    }

}
