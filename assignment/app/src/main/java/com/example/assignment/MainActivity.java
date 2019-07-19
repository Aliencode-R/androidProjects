package com.example.assignment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView screen;
    Button btnAdd, btnSub, btnMul, btnDiv;
    Button clear, equal;
    Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b0;
    double var1 , var2;
    boolean add = false, sub = false, mul = false, div = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        screen = findViewById(R.id.screen);
        btnAdd = findViewById(R.id.btnAdd);
        btnSub = findViewById(R.id.btnSub);
        btnMul = findViewById(R.id.btnMul);
        btnDiv = findViewById(R.id.btnDiv);
        clear = findViewById(R.id.clear);
        equal = findViewById(R.id.equal);
        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);
        b4 = findViewById(R.id.b4);
        b5 = findViewById(R.id.b5);
        b6 = findViewById(R.id.b6);
        b7 = findViewById(R.id.b7);
        b8 = findViewById(R.id.b8);
        b9 = findViewById(R.id.b9);
        b0 = findViewById(R.id.b0);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screen.setText(screen.getText().toString() + '1');
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screen.setText(screen.getText().toString() + '2');
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screen.setText(screen.getText().toString() + '3');
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screen.setText(screen.getText().toString() + '4');
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screen.setText(screen.getText().toString() + '5');
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screen.setText(screen.getText().toString() + '6');
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screen.setText(screen.getText().toString() + '7');
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screen.setText(screen.getText().toString() + '8');
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screen.setText(screen.getText().toString() + '9');
            }
        });
        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screen.setText(screen.getText().toString() + '0');
            }
        });


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                var1 = Double.parseDouble(screen.getText().toString());
                add = true;
                screen.setText(null);
            }
        });
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                var1 = Double.parseDouble(screen.getText().toString());
                sub = true;
                screen.setText(null);
            }
        });
        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                var1 = Double.parseDouble(screen.getText().toString());
                mul = true;
                screen.setText(null);
            }
        });
        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                var1 = Double.parseDouble(screen.getText().toString());
                div = true;
                screen.setText(null);
            }
        });
        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                var2 = Double.parseDouble(screen.getText().toString());
                screen.setText(null);
                if(add)
                {
                    double var3 = var1 + var2;
                    screen.setText(var3+"");
                    add = false;
                }
                else if(sub)
                {
                    double var3 = var1 - var2;
                    screen.setText(var3+"");
                    sub = false;
                }
                else if(mul)
                {
                    double var3 = var1 * var2;
                    screen.setText(var3+"");
                    mul = false;
                }
                else if(div)
                {
                    double var3 = var1 / var2;
                    screen.setText(var3+"");
                    div = false;
                }
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(screen.getText().toString().length() > 1)
                {
                    String name = screen.getText().toString();
                    screen.setText(name.substring(0,name.length()-1));
                }
                else
                {
                    screen.setText(null);
                }
            }
        });
    }
}
