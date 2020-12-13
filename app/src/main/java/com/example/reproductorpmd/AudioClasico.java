package com.example.reproductorpmd;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;

public class AudioClasico extends AppCompatActivity implements MediaPlayer.OnCompletionListener {
private Button btnPlay,btnPause,btnStop;
private TextView cancion;
private MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_clasico);
        cancion= (TextView) findViewById(R.id.txtCancionClasica);
      //  String url="android.resource://com.example.reproductorpmd"+ R.raw.raging;
      //  mp= new MediaPlayer();
//  mp.setDataSource(this, Uri.parse(url));
        mp= MediaPlayer.create(this,R.raw.raging);
        /*
        try {
          //  mp.setDataSource(this, Uri.parse(url));
            mp= MediaPlayer.create(this,R.raw.raging);
            mp.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        mp.setOnCompletionListener(this);

        btnPlay=(Button) findViewById(R.id.btnPlay);
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mp.isPlaying()){
                    cancion.setText(getString(R.string.txt_reproducir));
                }
                else {
                    mp.start();
                    cancion.setText(getString(R.string.txt_reproduciendo));
                }
            }
        });
        btnPause=(Button)findViewById(R.id.btnPause);
        btnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mp.isPlaying()) {
                    mp.pause();
                    cancion.setText(getString(R.string.txt_pausando));
                }
                else {
                    cancion.setText(getString(R.string.txt_pausado));
                }
            }
        });
        btnStop=(Button)findViewById(R.id.btnStop);
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mp!=null && mp.isPlaying()) {
                    mp.stop();
                    try {
                        mp.prepare();
                        cancion.setText(getString(R.string.txt_deteniendo));
                    } catch (IOException e) {
                        e.printStackTrace();
                    } }
                else {
                    cancion.setText(getString(R.string.txt_detenido));
                }
            }
        });
    }

    @Override
    public void onCompletion(MediaPlayer mp) {
    mp.release();
    cancion.setText(getString(R.string.txt_finalizado));
    }
}