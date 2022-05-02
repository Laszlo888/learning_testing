package com.greenfox;

import java.util.ArrayList;
import java.util.List;

public class Cohort {

    String cohort;
    List<Student> students;
    List<Mentor> mentors;

    public Cohort(String name) {
        this.cohort = name;
        students = new ArrayList<>();
        mentors = new ArrayList<>();
    }

    void addStudent(Student student){
        students.add(student);
    }

    void addMentor(Mentor mentor){
        mentors.add(mentor);
    }

    void info(){
        System.out.println("The " + cohort + " cohort has " + students.size() + " students and " + mentors.size() + " mentors.");
    }

}
