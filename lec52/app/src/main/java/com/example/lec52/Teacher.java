package com.example.lec52;

import java.util.ArrayList;

public class Teacher {

    String name;
    String course;

    public Teacher(String name, String course) {
        this.name = name;
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public String getCourse() {
        return course;
    }

    public static ArrayList<Teacher> getTeachers(){
        ArrayList<Teacher> teachers = new ArrayList<>();
        teachers.add(new Teacher("rishabh","c++"));
        teachers.add(new Teacher("Maning","ds"));
        teachers.add(new Teacher("anna","c#"));
        teachers.add(new Teacher("luffy","rubberMan"));
        teachers.add(new Teacher("zoro","swordsman"));
        teachers.add(new Teacher("nami","cat burglar"));
        teachers.add(new Teacher("ussop","shooter"));
        teachers.add(new Teacher("sanji","black leg"));
        teachers.add(new Teacher("chopper","reindeer"));
        teachers.add(new Teacher("robin","assassin"));

        return teachers;


    }
}
