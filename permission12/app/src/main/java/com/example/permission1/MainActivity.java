package com.example.permission1;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button btnDial;
    EditText etNum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnDial = findViewById(R.id.btnDial);
        etNum = findViewById(R.id.etNum);

        btnDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int perm = ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE);
                if(perm == PackageManager.PERMISSION_GRANTED)
                {
                    callNumber();
                }
                else
                {
                    ActivityCompat.requestPermissions(
                            MainActivity.this,
                            new String[]
                                    { Manifest.permission.CALL_PHONE},
                                    8700
                    );
                }

            }
        });


    }
    void callNumber()
    {
        String telNo = etNum.getText().toString();
        Uri uri = Uri.parse("tel:" + telNo);
        Intent i = new Intent(Intent.ACTION_CALL, uri);
        startActivity(i);
    }
}
