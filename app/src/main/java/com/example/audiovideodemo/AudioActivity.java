package com.example.audiovideodemo;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;

public class AudioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio);

        MediaPlayer mPlayer = MediaPlayer.create(this, R.raw.car_starting);

        mPlayer.start();
    }
}