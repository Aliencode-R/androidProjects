package com.example.myapplication4;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "btn";
    TextView tvResult;
    Button btnAdd;
    EditText etVar1;
    EditText etVar2;
    ImageButton btnBrowse;
    EditText urlBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        etVar1 = findViewById(R.id.etVar1);
        etVar2 = findViewById(R.id.etVar2);
        tvResult = findViewById(R.id.tvResult);
        btnAdd = findViewById(R.id.btnAdd);
        urlBox = findViewById(R.id.urlBox);
        btnBrowse = findViewById(R.id.btnBrowse);
        btnAdd.setOnClickListener(new View.OnClickListener()
                                  {
                                      @Override
                                      public void onClick(View v) {
                                          int var1 = Integer.valueOf(etVar1.getText().toString());
                                          int var2 = Integer.valueOf(etVar2.getText().toString());

                                          int var3 = var1 + var2;
                                          tvResult.setText(String.valueOf(var3));

                                          Intent i = new Intent(MainActivity.this, second.class);
                                          i.putExtra("result", var3 );
                                          startActivity(i);
                                      }
                                  }

        );
        btnBrowse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = urlBox.getText().toString();
                Uri uri = Uri.parse(url);
                Intent i = new Intent(Intent.ACTION_VIEW, uri);
                try
                {
                    startActivity(i);
                } catch (ActivityNotFoundException anfe)
                {
                    Log.e(TAG, "onClick: url not available",anfe );
                    Toast.makeText(MainActivity.this, "this url is not reachable", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }

}
