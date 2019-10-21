package com.example.broadcastapplication;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action.equals("action.refreshFriend")) {
            String cardNo = intent.getStringExtra("message");
            Toast.makeText(context, "广播1已发送..."+cardNo, Toast.LENGTH_SHORT).show();

            //要执行的逻辑
        }
    }

}

