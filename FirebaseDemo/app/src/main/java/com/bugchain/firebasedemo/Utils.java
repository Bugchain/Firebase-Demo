package com.bugchain.firebasedemo;
/*
 * Created by BUG CHAIN on 02/06/2017.
 * ARIP Public Company Limited
 * Bangkok, Thailand
 */

import android.os.Build;

public class Utils {

    public static boolean isAndroidVersionAboveMarshmallow(){
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.M;
    }

}
