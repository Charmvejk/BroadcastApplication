package com.example.broadcastapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/*
 * android广播通知
 * */



/*
* 2种注册方式 静态和动态 在AndroidManifiest种是静态不常用，直接在点击事件中写，单独一个类接收
* 动态是在oncreate中接收，方便销毁
* */
public class MainActivity extends AppCompatActivity {

    TextView tvName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvName = findViewById(R.id.tv_name);
        findViewById(R.id.tv_name_send).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendBroadcast1();
            }
        });

//        接收方
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("action.refreshFriend");
        registerReceiver(mRefreshBroadcastReceiver, intentFilter);
     }

    //todo 说明
    private void receiveBraodacast() {
        /*
         * 1.接收方*/
/*
* onCreate（）方法中：
*    IntentFilter intentFilter =new IntentFilter();
    intentFilter.addAction("action.refreshFriend");
    registerReceiver(mRefreshBroadcastReceiver, intentFilter);

      添加方法：
   private BroadcastReceivermRefreshBroadcastReceiver =new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                String action = intent.getAction();
                if (action.equals("action.refreshFriend"))
                {
                    //要执行的逻辑
                 }
            }
    };

    */


    }

    /*添加方法*/
    private BroadcastReceiver mRefreshBroadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action.equals("action.refreshFriend")) {
                //要执行的逻辑
                String cardNo = intent.getStringExtra("message");
                tvName.setText(cardNo);
                Toast.makeText(context, "广播1已发送..."+cardNo, Toast.LENGTH_SHORT).show();


            }
        }
    };

    private void sendBroadcast1() {
        /*
         * 1.发送方*/
        Intent intent = new Intent();
        intent.setAction("action.refreshFriend");
        intent.putExtra("message", "收到广播");
        sendBroadcast(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(mRefreshBroadcastReceiver);
    }
}
