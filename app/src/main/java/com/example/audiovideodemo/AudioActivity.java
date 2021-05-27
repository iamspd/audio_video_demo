package com.example.audiovideodemo;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

public class AudioActivity extends AppCompatActivity {

    // variables
    private MediaPlayer mPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_audio);

        mPlayer = MediaPlayer.create(this, R.raw.car_starting);
    }

    public void onClickPlay(View view){

        mPlayer.start();
    }

    public void onClickPause(View view){

        mPlayer.pause();
    }
}