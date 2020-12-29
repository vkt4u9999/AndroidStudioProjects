package com.vkt4u9999.playingaudio;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    Button button;
    SeekBar volumeSeekBar;
    AudioManager audioManager;       // Дает доступ к звуку

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Устанавливаем звук на все активити
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.taras);

        button = findViewById(R.id.button);
        volumeSeekBar = findViewById(R.id.volumeSeekBar);
        audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);


        // Получаем данные о макс громкости
        int maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        volumeSeekBar.setMax(maxVolume);

        volumeSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                Log.d("Progress changed: ", "" + i);
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, i, 0);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

       button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mediaPlayer.isPlaying()){
                    pause();
                }
                else{
                    play();
                }
            }
        });

    }
    public void play(){
        mediaPlayer.start();
        button.setText("Pause");
    }

    public void pause(){
        mediaPlayer.pause();
        button.setText("Play");
    }
    }

