package com.example.assignment3;


import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    EditText etMin ;
    TextView tvColon;
    EditText etSec;
    Button btnStart;
    TextView tvScreen;
    Button btnPause;

    CountDownTimer countDownTimer ;
    Boolean isRunning = false;
    Integer timeLeft;
    Boolean isPause = false;
    String time1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etMin = findViewById(R.id.etMin);
        tvColon = findViewById(R.id.tvColon);
        etSec = findViewById(R.id.etSec);
        btnStart = findViewById(R.id.btnStart);
        tvScreen = findViewById(R.id.tvScreen);
        btnPause = findViewById(R.id.btnPause);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startTimer();
            }
        });
        btnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pauseTimer();
            }
        });

    }
    private void startTimer()
    {
        int timeLeftMin;
        int timeLeftSec;
        tvScreen.setText(null);
        timeLeft = 0;
        if(isPause)
        {
             timeLeftMin = Integer.parseInt(tvScreen.getText().toString().substring(0,2)) * 60 * 1000;
             timeLeftSec = Integer.parseInt(tvScreen.getText().toString().substring(3,5)) * 1000;
           // timeLeft =
        }
        else
        {
             timeLeftMin = Integer.parseInt(etMin.getText().toString()) * 60 * 1000;
             timeLeftSec = Integer.parseInt(etSec.getText().toString()) * 1000;
        }

        timeLeft = timeLeftMin + timeLeftSec;
        countDownTimer = new CountDownTimer(timeLeft, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeft = (int) millisUntilFinished;
                updateTimeLeft();
            }

            @Override
            public void onFinish() {
                tvScreen.setText("Time up !!");
                isRunning = false;
            }
        }.start();

        isRunning = true;
        isPause = false;
    }
    private void pauseTimer()
    {
        if(isRunning)
        {
            isRunning = false;
            countDownTimer.cancel();
        }
        else
        {
            isRunning = true;
            isPause = true;
            startTimer();
        }
    }
    private void updateTimeLeft()
    {
        int minutes = (timeLeft/1000)/60;
        int seconds = (timeLeft/1000)%60;

        String time = String.format( Locale.getDefault(),"%02d:%02d",minutes,seconds);
        time1 = time;
        tvScreen.setText(time);
    }

}
