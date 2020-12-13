package com.example.reproductorpmd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
private Button audio,video,cAudio;
private TextView inicio;
private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicio=(TextView) findViewById(R.id.txtInicio);
        audio=(Button) findViewById(R.id.btnAudio);
        cAudio= (Button)findViewById(R.id.btnAudioClasico);
        cAudio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent= new Intent(MainActivity.this,AudioClasico.class);
                startActivity(intent);
            }
        });
        audio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent= new Intent(MainActivity.this,Audio.class);
                startActivity(intent);
            }
        });
        video=(Button) findViewById(R.id.btnVideo);
        video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent= new Intent(MainActivity.this,Video.class);
                startActivity(intent);
            }
        });

    }
}