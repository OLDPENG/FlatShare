package com.yuxuan.flatshare.Utils;

import android.content.Context;
import android.content.SharedPreferences;

public class ConfigUtils {

    private static SharedPreferences sharedPreferences;

    //判断是否第一次运行
    public static boolean getIsRun(Context context) {
        SharedPreferences setting = context.getSharedPreferences("config", 0);
        Boolean user_first = setting.getBoolean("FIRST", true);
        if (user_first) {//第一次
            setting.edit().putBoolean("FIRST", false).commit();
            return true;
        } else {
            return false;
        }
    }
}
