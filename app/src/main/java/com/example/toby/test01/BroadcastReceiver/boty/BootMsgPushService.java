package com.example.toby.test01.BroadcastReceiver.boty;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by toby on 01/02/2017.
 */

public class BootMsgPushService extends Service {
    private static final String TAG = "BootMsgPushService";
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG,"onCreate called");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG,"onStartCommand called");
        return super.onStartCommand(intent, flags, startId);
    }
}
