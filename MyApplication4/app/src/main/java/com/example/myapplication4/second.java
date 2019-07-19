package com.example.myapplication4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class second extends AppCompatActivity {

    TextView screen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        screen = findViewById(R.id.screen);

        Intent i = getIntent();
        int result = i.getIntExtra("result",0);
        screen.setText(result+"");
    }
}
