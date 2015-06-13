package com.example.administrator.basictools.Receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

import com.example.administrator.basictools.Service.BackgroundMusic;

/**
 * Created by Tong on 2015/6/13.
 */
public class NetstateChangeReceiver extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        ConnectivityManager manager = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo mobNetInfo = manager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        NetworkInfo wifiInfo = manager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        if(mobNetInfo.isConnected()||wifiInfo.isConnected())
        {
            Toast.makeText(context, "NetstateChangeReceiver：已经连接网络", Toast.LENGTH_LONG).show();
            Intent i = new Intent(context, BackgroundMusic.class);
            i.putExtra("musicAction",BackgroundMusic.MUSIC_RESUME);
            context.startService(i);
        }
        else
        {
            Toast.makeText(context, "NetstateChangeReceiver：已经断开网络", Toast.LENGTH_LONG).show();
            Intent i = new Intent(context, BackgroundMusic.class);
            i.putExtra("musicAction", BackgroundMusic.MUSIC_PAUSE);
            context.startService(i);
        }
    }
}
