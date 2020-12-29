package com.vkt4u9999.mplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    AudioManager audioManager;
    SeekBar seekBar;
    ImageView playPauseIcon;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    mediaPlayer =MediaPlayer.create(getApplicationContext(), R.raw.basta_na_majake);
    audioManager= (AudioManager) getSystemService(AUDIO_SERVICE);
    seekBar= findViewById(R.id.seekBar);
    playPauseIcon=findViewById(R.id.playImageView);


    seekBar.setMax(mediaPlayer.getDuration());
    seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
            if (b){
                mediaPlayer.seekTo(i);
            }
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    });

    new Timer().scheduleAtFixedRate(new TimerTask() {
        @Override
        public void run() {
            seekBar.setProgress(mediaPlayer.getCurrentPosition());
        }
    },0,1000);




    }

    public void play(View view) {
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
            playPauseIcon.setImageResource(R.drawable.ic_baseline_play_arrow_blue_24);
        }
        else {
            mediaPlayer.start();
            playPauseIcon.setImageResource(R.drawable.ic_baseline_pause_24);
        }
    }

    public void previous(View view) {
    }

    public void next(View view) {
    }
}