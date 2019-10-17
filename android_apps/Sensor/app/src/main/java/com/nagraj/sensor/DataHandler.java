package com.nagraj.sensor;

import android.content.Context;
import android.net.TrafficStats;
import android.os.Handler;
import android.os.HandlerThread;


public class DataHandler extends HandlerThread {

    private final Handler uiHandler;
    Handler workerHandler;
    Context context;
    long owrx = 0, owtx = 0,omrx=0,omtx=0;


    public DataHandler(Handler uiHandler, Context context) {
        super(MyHandlerThread.class.getName());
        this.context = context;
        this.uiHandler = uiHandler;
        start();

    }

    @Override
    protected void onLooperPrepared() {
        super.onLooperPrepared();
        workerHandler = new Handler();
        workerHandler.post(new Runnable() {
            @Override
            public void run() {
                try {
                    int count = 0;
                    while (count == 0) {
                        long nmrx=TrafficStats.getMobileRxBytes();
                        long nmtx=TrafficStats.getMobileTxBytes();
                        long nwrx = TrafficStats.getTotalRxBytes()-nmrx;
                        long nwtx = TrafficStats.getTotalTxBytes()-nmtx;

                        long wrx = nwrx - owrx;
                        long wtx = nwtx - owtx;
                        long mrx = nmrx - omrx;
                        long mtx = nmtx - omtx;
                        owrx = nwrx;
                        owtx = nwtx;
                        omrx=nmrx;
                        omtx=nmtx;
                        long rem4 = (wrx + wtx) / 1024;
                        long rem5=(mrx+mtx)/1024;

                        uiHandler.obtainMessage(4, rem4).sendToTarget();
                        uiHandler.obtainMessage(5, rem5).sendToTarget();
                        Thread.sleep(1000);
                        workerHandler.postDelayed(this, 1000);

                    }

                } catch (Exception e) {

                }

            }
        });

    }


}

