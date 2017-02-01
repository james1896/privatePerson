package com.example.toby.test01.BroadcastReceiver.boty;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.BatteryManager;
import android.widget.Toast;

/**
 * Created by toby on 01/02/2017.
 */

public class BatteryChangedReceiver extends BroadcastReceiver {
    private static final String TAG = "BatteryChangedReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        int currLevel = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0);  //当前电量
        int total = intent.getIntExtra(BatteryManager.EXTRA_SCALE, 1);      //总电量
        int percent = currLevel * 100 / total;
        Toast.makeText(context,"battery: " + percent + "%",Toast.LENGTH_SHORT).show();


    }

//    当然，有些时候我们是要立即获取电量的，而不是等电量变化的广播，比如当阅读软件打开时立即显示出电池电量。我们可以按以下方式获取：

//    Intent batteryIntent = getApplicationContext().registerReceiver(null,
//            new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
//    int currLevel = batteryIntent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0);
//    int total = batteryIntent.getIntExtra(BatteryManager.EXTRA_SCALE, 1);
//    int percent = currLevel * 100 / total;
//    Log.i("battery", "battery: " + percent + "%");
}
