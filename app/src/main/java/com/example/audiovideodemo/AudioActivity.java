package com.example.audiovideodemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;

public class AudioActivity extends AppCompatActivity {

    // widgets
    private SeekBar seekBar;

    // variables
    private MediaPlayer mPlayer;
    private AudioManager audioManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_audio);

        mPlayer = MediaPlayer.create(this, R.raw.car_starting);

        seekBar = findViewById(R.id.seekBar);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        }

        int maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int currentVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);

        seekBar.setMax(maxVolume);
        seekBar.setProgress(currentVolume);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    public void onClickPlay(View view){

        mPlayer.start();
    }

    public void onClickPause(View view){

        mPlayer.pause();
    }
}