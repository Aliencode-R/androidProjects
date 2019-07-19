package com.example.lec51;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    String[] names = new String[]{
            "Rishabh",
            "Rajat",
            "Vaibhav",
            "Rishabh",
            "Ashish",
            "Nishant",
            "Ankit",
            "Sankalp",
            "Nikhil",
            "Aliencode-R"
    };
    ListView lvNames;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvNames = findViewById(R.id.lvNames);
        ArrayAdapter<String> namesAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_expandable_list_item_1,
                android.R.id.text1,
                names

        );
        lvNames.setAdapter(namesAdapter);

    }
}
