package com.example.assignment2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText etToDo;
    Button btnAdd;
    ListView lvItems;
    ArrayList<String> Items;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etToDo = findViewById(R.id.etToDo);
        btnAdd = findViewById(R.id.btnAdd);
        lvItems = findViewById(R.id.lvItems);
        Items = new ArrayList<>();


        final ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_expandable_list_item_1,
                android.R.id.text1,
                Items

        );
        lvItems.setAdapter(adapter);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String enteredText = etToDo.getText().toString();
                Items.add(enteredText);
                adapter.notifyDataSetChanged();
                etToDo.setText(null);

                Toast.makeText(MainActivity.this,
                        "Item Added !!", Toast.LENGTH_LONG).show();
            }
        });

    }
}
