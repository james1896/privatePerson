package com.example.toby.test01.BroadcastReceiver.boty;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by toby on 01/02/2017.
 */

public class BootCompleteReceiver extends BroadcastReceiver {
    private static final String TAG = "BootCompleteReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        Intent service = new Intent(context,BootMsgPushService.class);
        context.startService(service);

        Log.i(TAG,"Boot Complete. Starting MsgPushService...");
    }
}
