package com.example.reproductorpmd;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.MediaController;

public class Audio extends AppCompatActivity implements MediaController.MediaPlayerControl {
    private ConstraintLayout cAudio;
    private MediaPlayer mp;
    private MediaController mc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio);
        mp=MediaPlayer.create(this,R.raw.you);
        mc=new MediaController(this);
        mc.setMediaPlayer(this);
        cAudio=(ConstraintLayout) findViewById(R.id.cAudio);
        mc.setAnchorView(cAudio);
        mp.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mc.show(20000);
            }
        });

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mp.stop();
        mp.release();
    }

    @Override
    public void start() {
    mp.start();
    }

    @Override
    public void pause() {
        if(mp.isPlaying())
            mp.pause();

    }

    @Override
    public int getDuration() {
        return mp.getDuration();
    }

    @Override
    public int getCurrentPosition() {
        return mp.getCurrentPosition();
    }

    @Override
    public void seekTo(int pos) {
        mp.seekTo(pos);
    }

    @Override
    public boolean isPlaying() {
        return mp.isPlaying();
    }

    @Override
    public int getBufferPercentage() {
        return 0;
    }

    @Override
    public boolean canPause() {
        return true;
    }

    @Override
    public boolean canSeekBackward() {
        return true;
    }

    @Override
    public boolean canSeekForward() {
        return true;
    }

    @Override
    public int getAudioSessionId() {
        return 0;
    }
}