package com.greenfox;

public class Person {
    String name;
    int age;
    String gender;


    public Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public Person() {
        name = "Jane Doe";
        age = 30;
        gender = "female";
    }

    void getGoal() {
        System.out.println("My goal is: Live for the moment!");
    }

    void introduce() {
        System.out.println("Hi, I'm " + name + ", a " + age + " year old " + gender + ".");
    }
}
