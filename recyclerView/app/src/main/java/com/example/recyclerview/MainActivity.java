package com.example.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "RV";
    RecyclerView rvCourses;
    ArrayList<Course> courses = Course.generateNRandomCourses(100);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvCourses = findViewById(R.id.rvCourses);
        rvCourses.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(courses);
        rvCourses.setAdapter(adapter);
    }
}
