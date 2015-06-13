package com.example.administrator.basictools.Service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;

import com.example.administrator.basictools.R;

import java.io.IOException;

/**
 * Created by Tong on 2015/6/13.
 */
public class BackgroundMusic extends Service{
    public static final int MUSIC_START = 0;
    public static final int MUSIC_PAUSE = 1;
    public static final int MUSIC_STOP = 3;
    public static final int MUSIC_RESUME = 2;

    private MediaPlayer mMediaPlayer = null;

    @Override
    public void onCreate(){
        super.onCreate();
        mMediaPlayer = MediaPlayer.create(this, R.raw.background);
        Log.v("MusicPlayService:    ", "onCreate");
    }

    @Override
    public IBinder onBind(Intent intent) {

        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if(intent != null){
        int action = intent.getIntExtra("musicAction",-1);
        Log.v("service action:    ", String.valueOf(action) );
        switch (action){
            case MUSIC_START:
                mMediaPlayer.start();
                break;
            case MUSIC_PAUSE:
                if(mMediaPlayer.isPlaying()) {
                    Log.v("MusicPlayService:    ", "mMediaPlayer pause()" );
                    mMediaPlayer.pause();
                }
                break;
            case MUSIC_RESUME:
                if(!mMediaPlayer.isPlaying()) {
                    Log.v("MusicPlayService:    ", "mMediaPlayer start()" );
                    mMediaPlayer.start();
                }
                break;
            case MUSIC_STOP:
                mMediaPlayer.stop();

                try {
                    mMediaPlayer.prepare();
                    mMediaPlayer.seekTo(0);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                break;
            default:
                break;
        }

        }

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        if(mMediaPlayer != null){
            Log.v("MusicPlayService:    ", "mMediaPlayer release()" );
            mMediaPlayer.release();
        }
        super.onDestroy();

    }
}

