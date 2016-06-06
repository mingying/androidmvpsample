package com.mingying.androidmanager.managers;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.util.Log;

import java.util.List;

/**
 * Created by caihanlin on 16/6/4.
 */
public class MyActivityManager {


    public static void getRunningPro(Context context){

        ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningAppProcessInfo> infos = activityManager.getRunningAppProcesses();
        for (ActivityManager.RunningAppProcessInfo info : infos){
            String processName = info.processName;
            int pid = info.pid;
            Log.e("chl","processName = " +processName + "; pid =" +pid);
        }
        ConfigurationInfo configurationInfo = activityManager.getDeviceConfigurationInfo();
        Log.e("chl",configurationInfo.toString());
    }

}
