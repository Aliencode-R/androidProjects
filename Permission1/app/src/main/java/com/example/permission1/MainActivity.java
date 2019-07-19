package com.example.permission1;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnNetStat;
    TextView tvStatus;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnNetStat = findViewById(R.id.btnNetStat);
        tvStatus = findViewById(R.id.tvStatus);

        btnNetStat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConnectivityManager cm = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
                NetworkInfo netInfo = cm.getActiveNetworkInfo();
                boolean isConnected = netInfo != null && netInfo.isConnected();
                tvStatus.setText(isConnected ? "Connected": " Not Connected");
                
            }
        });
    }



}
