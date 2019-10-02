package com.nagraj.sensor;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Handler;
import android.os.HandlerThread;

import java.util.Calendar;

import static android.content.Context.ACTIVITY_SERVICE;

public class MyHandlerThread extends HandlerThread {

    private final Handler uiHandler;
    private final Context context;
    Handler workerHandler;

    public MyHandlerThread(Handler uiHandler, Context context) {
        super(MyHandlerThread.class.getName());
        this.context = context;
        this.uiHandler = uiHandler;
        start();

    }

    @Override
    protected void onLooperPrepared() {
        super.onLooperPrepared();
        workerHandler = new Handler();
        workerHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                try {
                    int count = 0;
                    while (count == 0) {

                        IntentFilter ifilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
                        Intent batteryStatus = context.registerReceiver(null, ifilter);
                        int level = batteryStatus.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
                        int scale = batteryStatus.getIntExtra(BatteryManager.EXTRA_SCALE, -1);
                        int rem1 = (int) ((level * 100) / (float) scale);

                        ActivityManager actManager = (ActivityManager) context.getSystemService(ACTIVITY_SERVICE);
                        ActivityManager.MemoryInfo memInfo = new ActivityManager.MemoryInfo();
                        actManager.getMemoryInfo(memInfo);
                        long totalMemory = memInfo.totalMem;
                        long freeMem = memInfo.availMem;
                        long usedMem = totalMemory - freeMem;
                        int rem2 = (int) ((usedMem * 100) / (float) totalMemory);

                        Calendar cal = Calendar.getInstance();
                        cal.setTimeInMillis(System.currentTimeMillis());
                        int yyyy = cal.get(Calendar.YEAR);
                        int mm = cal.get(Calendar.MONTH);
                        int dd = cal.get(Calendar.DAY_OF_MONTH);
                        int h = cal.get(Calendar.HOUR_OF_DAY);
                        int m = cal.get(Calendar.MINUTE);
                        int s = cal.get(Calendar.SECOND);
                        String rem3 = "Time : " + h + " : " + m + " : " + s + "    |   Date : " + dd + " / " + mm + " / " + yyyy;

                        uiHandler.obtainMessage(1, rem1).sendToTarget();
                        uiHandler.obtainMessage(2, rem2).sendToTarget();
                        uiHandler.obtainMessage(3, rem3).sendToTarget();
                        Thread.sleep(200);
                    }

                } catch (Exception e) {

                }

            }
        }, 2000);

    }


}
