package com.example.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder> {

    public RecyclerViewAdapter(ArrayList<Course> courses) {
        this.courses = courses;
    }

    ArrayList<Course> courses ;

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater li = (LayoutInflater) viewGroup.getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = li.inflate(R.layout.list_item_course, viewGroup,false);

        return new RecyclerViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder recyclerViewHolder, int i) {

        Course course = courses.get(i);
        recyclerViewHolder.tvCourseName.setText(course.getName());
        recyclerViewHolder.tvTeacherName.setText(course.getTeacherName());
        recyclerViewHolder.tvLectures.setText(course.getLectures()+"");

    }

    @Override
    public int getItemCount() {
        return courses.size();
    }

    class RecyclerViewHolder extends RecyclerView.ViewHolder{
        TextView tvCourseName, tvTeacherName, tvLectures;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            tvCourseName = itemView.findViewById(R.id.tvCourseName);
            tvTeacherName = itemView.findViewById(R.id.tvTeacherName);
            tvLectures = itemView.findViewById(R.id.tvLectures);

        }
    }
}
