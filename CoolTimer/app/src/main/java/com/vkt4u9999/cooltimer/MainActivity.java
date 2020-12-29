package com.vkt4u9999.cooltimer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.PreferenceManager;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.preference.PreferenceFragment;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SharedPreferences.OnSharedPreferenceChangeListener {

    private SeekBar seekBar;
    private TextView textView;
    Button button;
    private boolean isTimerOn;
    private CountDownTimer countDownTimer;
    private int defaultInterval;
    SharedPreferences sharedPreferences;


    private void resetTimer() {
        button.setText(R.string.start);
        seekBar.setEnabled(true);
        isTimerOn = false;
        countDownTimer.cancel();
        setIntervalFromSharedPreferences(sharedPreferences);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.action_settings) {
            Intent openSettings = new Intent(this, Settings.class);
            startActivity(openSettings);
            return true;

        }
            return super.onOptionsItemSelected(item);
        }

        private void updateTimer ( long l){
            int minutes = (int) l / 1000 / 60;
            int seconds = (int) l / 1000 - (minutes * 60);
            String minutesStrings = "";
            String secondsStrings = "";

            if (minutes < 10) {
                minutesStrings = "0" + minutes;
            } else {
                minutesStrings = String.valueOf(minutes);
            }
            if (seconds < 10) {
                secondsStrings = "0" + seconds;
            } else {
                secondsStrings = String.valueOf(seconds);
            }
            textView.setText(minutesStrings + " : " + secondsStrings);
        }

        @Override
        public boolean onCreateOptionsMenu (Menu menu){
            MenuInflater menuInflater = getMenuInflater();
            menuInflater.inflate(R.menu.timer_menu, menu);
            return true;
        }

        @Override
        protected void onCreate (Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);


            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            seekBar = findViewById(R.id.seekBar);
            textView = findViewById(R.id.textView);
            button = findViewById(R.id.button);
            isTimerOn = false;

            sharedPreferences=PreferenceManager.getDefaultSharedPreferences(this);

            setIntervalFromSharedPreferences(sharedPreferences);
            seekBar.setMax(3600);
            seekBar.setProgress(defaultInterval);
            seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                    long progressInMillis = i * 1000;
                    updateTimer(progressInMillis);
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
                    if (!isTimerOn) {
                        button.setText(R.string.stop);
                        seekBar.setEnabled(false);
                        isTimerOn = true;

                        countDownTimer = new CountDownTimer(seekBar.getProgress() * 1000, 1000) {
                            @Override
                            public void onTick(long l) {
                                updateTimer(l);
                            }

                            @Override
                            public void onFinish() {

                                SharedPreferences sharedPreferences= PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                                if (sharedPreferences.getBoolean("enable_sound",true)){
                                    String melodyName=sharedPreferences.getString("timer_melody", "bell");
                                    if (melodyName.equals("bell")){
                                        MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.bell_sound);
                                        mediaPlayer.start();
                                    }
                                    else if (melodyName.equals("alarm_siren")) {
                                        MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.alarm_siren_sound);
                                        mediaPlayer.start();
                                    }
                                        else if (melodyName.equals("bip")) {
                                        MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.bip_sound);
                                        mediaPlayer.start();
                                    }
                                }
                                resetTimer();
                            }
                        }.start();
                    } else {
                        resetTimer();
                    }
                }
            });





       /* CountDownTimer countDownTimer= new CountDownTimer(10000,1000) {
            @Override
            public void onTick(long l) {

                Log.i("mytimer", l / 1000 + " seconds left");
            }

            @Override
            public void onFinish() {
                Log.i("mytimer", "finish");
            }
        };
        countDownTimer.start();
       Handler handler= new Handler();
        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                Log.i("runnable", "Two seconds passed");
                handler.postDelayed(this,2000);
            }
        };
        handler.post(runnable);*/

            sharedPreferences.registerOnSharedPreferenceChangeListener(this);
        }

    private void setIntervalFromSharedPreferences(SharedPreferences sharedPreferences){

            defaultInterval = Integer.valueOf(sharedPreferences.getString("default_interval", "30"));
        long defaultIntervalInMillis = defaultInterval * 1000;
        updateTimer(defaultIntervalInMillis);
        seekBar.setProgress(defaultInterval);

    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String s) {
        if (s.equals("default_interval")){
            setIntervalFromSharedPreferences(sharedPreferences);
        }
    }

    @Override
    protected void onDestroy() {
        sharedPreferences.unregisterOnSharedPreferenceChangeListener(this);
        super.onDestroy();
    }
}
