package com.example.reproductorpmd;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class Video extends AppCompatActivity {
private ConstraintLayout cVideo;
    private MediaPlayer mp;
    private MediaController mc;
    private VideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        mc= new MediaController(this);
       // mp= MediaPlayer.create(this,R.raw.can);
        cVideo=(ConstraintLayout) findViewById(R.id.cVideo);
       videoView=(VideoView)findViewById(R.id.vvVideo);
       // String url="android.resource://com.example.reproductorpmd"+R.raw.can;
        videoView.setVideoURI(Uri.parse("android.resource://com.example.reproductorpmd/"+R.raw.can));
       //videoView.setVideoURI(Uri.parse(this,R.raw.can));
      //  mc.setMediaPlayer((MediaController.MediaPlayerControl) this);
        videoView.setMediaController(mc);
       mc.setAnchorView(videoView);
      // mc.setAnchorView(cVideo);
        videoView.start();
    }
}