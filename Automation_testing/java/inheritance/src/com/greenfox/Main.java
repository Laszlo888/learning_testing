package com.greenfox;

import java.util.ArrayList;

public class Main {

  //  Create a Person class with the following fields:
  //  name: the name of the person
  //  age: the age of the person (whole number)
  //  gender: the gender of the person (male / female)
  //  And the following methods:
  //  getGoal(): prints "My goal is: Live for the moment!"
  //  introduce(): prints "Hi, I'm name, a age year old gender.
  //  And the following constructors:
  //  Person(name, age, gender)
  //  Person(): sets name to Jane Doe, age to 30, gender to female
  //
  //  Create a Student class that has the same fields and methods as the Person class, and has the
  //  following additional
  //  fields:
  //  previousOrganization: the name of the student’s previous company / school
  //  skippedDays: the number of days skipped from the course
  //  methods:
  //  getGoal(): prints "Be a junior software developer."
  //  introduce(): prints "Hi, I'm name, a age year old gender from previousOrganization who
  //  skipped skippedDays days from the course already."
  //  skipDays(numberOfDays): increases skippedDays by numberOfDays
  //  The Student class has the following constructors:
  //  Student(name, age, gender, previousOrganization): beside the given parameters, it sets
  //  skippedDays to 0
  //  Student(): sets name to Jane Doe, age to 30, gender to female, previousOrganization to The
  //  School of Life, skippedDays to 0
  //
  //  Create a Mentor class that has the same fields and methods as the Person class, and has the
  //  following additional
  //  fields:
  //  level: the level of the mentor (junior / intermediate / senior)
  //  methods:
  //  getGoal(): prints "Educate brilliant junior software developers."
  //  introduce(): prints "Hi, I'm name, a age year old gender level mentor."
  //  The Mentor class has the following constructors:
  //  Mentor(name, age, gender, level)
  //  Mentor(): sets name to Jane Doe, age to 30, gender to female, level to intermediate
  //
  //  Create a Sponsor class that has the same fields and methods as the Person class, and has the
  //  following additional
  //  fields:
  //  company: name of the company
  //  hiredStudents: number of students hired
  //  method:
  //  introduce(): prints "Hi, I'm name, a age year old gender who represents company and hired
  //  hiredStudents students so far."
  //  hire(): increases hiredStudents by 1
  //  getGoal(): prints "Hire brilliant junior software developers."
  //  The Sponsor class has the following constructors:
  //  Sponsor(name, age, gender, company): beside the given parameters, it sets hiredStudents to 0
  //  Sponsor(): sets name to Jane Doe, age to 30, gender to female, company to Google and
  //  hiredStudents to 0
  //
  //  Create a Cohort class that has the following
  //  fields:
  //  name: the name of the cohort
  //  students: a list of Students
  //  mentors: a list of Mentors
  //  methods:
  //  addStudent(Student): adds the given Student to students list
  //  addMentor(Mentor): adds the given Mentor to mentors list
  //  info(): prints "The name cohort has students.size() students and mentors.size() mentors."
  //  The Cohort class has the following constructors:
  //  Cohort(name): beside the given parameter it sets students and mentors to empty lists
  //
  //    Test input
  //
  //    ArrayList<Person> people = new ArrayList<>();
  //    Person mark = new Person("Mark", 46, "male");
  //    people.add(mark);
  //    Person jane = new Person();
  //    people.add(jane);
  //    Student john = new Student("John Doe", 20, "male", "BME");
  //    people.add(john);
  //    Student student = new Student();
  //    people.add(student);
  //    Mentor gandhi = new Mentor("Gandhi", 148, "male", "senior");
  //    people.add(gandhi);
  //    Mentor mentor = new Mentor();
  //    people.add(mentor);
  //    Sponsor sponsor = new Sponsor();
  //    people.add(sponsor);
  //    Sponsor elon = new Sponsor("Elon Musk", 46, "male", "SpaceX");
  //    people.add(elon);
  //
  //    student.skipDays(3);
  //
  //    for (int i = 0; i < 5; i++) {
  //        elon.hire();
  //    }
  //
  //    for (int i = 0; i < 3; i++) {
  //        sponsor.hire();
  //    }
  //
  //    for(Person person : people) {
  //        person.introduce();
  //        person.getGoal();
  //    }
  //
  //    Cohort awesome = new Cohort("AWESOME");
  //    awesome.addStudent(student);
  //    awesome.addStudent(john);
  //    awesome.addMentor(mentor);
  //    awesome.addMentor(gandhi);
  //    awesome.info();
  //
  //    Test output
  //
  //    Hi, I'm Mark, a 46 year old male.
  //    My goal is: Live for the moment.
  //    Hi, I'm Jane Doe, a 30 year old female.
  //    My goal is: Live for the moment.
  //    Hi, I'm John Doe, a 20 year old male from BME who skipped 0 days from the course already.
  //    My goal is: Be a junior software developer.
  //    Hi, I'm Jane Doe, a 30 year old female from The School of Life who skipped 3 days
  //    from the course already.
  //    My goal is: Be a junior software developer.
  //    Hi, I'm Gandhi, a 148 year old male senior mentor.
  //    My goal is: Educate brilliant junior software developers.
  //    Hi, I'm Jane Doe, a 30 year old female intermediate mentor.
  //    My goal is: Educate brilliant junior software developers.
  //    Hi, I'm Jane Doe, a 30 year old female who represents Google and hired 3 students so far.
  //    My goal is: Hire brilliant junior software developers.
  //    Hi, I'm Elon Musk, a 46 year old male who represents SpaceX and hired 5 students so far.
  //    My goal is: Hire brilliant junior software developers.
  //    The AWESOME cohort has 2 students and 2 mentors.

  public static void main(String[] args) {

    ArrayList<Person> people = new ArrayList<>();

    Person mark = new Person("Mark", 46, "male");
    people.add(mark);
    Person jane = new Person();
    people.add(jane);
    Student john = new Student("John Doe", 20, "male", "BME");
    people.add(john);
    Student student = new Student();
    people.add(student);
    Mentor gandhi = new Mentor("Gandhi", 148, "male", "senior");
    people.add(gandhi);
    Mentor mentor = new Mentor();
    people.add(mentor);
    Sponsor sponsor = new Sponsor();
    people.add(sponsor);
    Sponsor elon = new Sponsor("Elon Musk", 46, "male", "SpaceX");
    people.add(elon);

    student.skipDays(3);

    for (int i = 0; i < 5; i++) {
      elon.hire();
    }

    for (int i = 0; i < 3; i++) {
      sponsor.hire();
    }

    for (Person person : people) {
      person.introduce();
      person.getGoal();
    }

    Cohort awesome = new Cohort("AWESOME");
    awesome.addStudent(student);
    awesome.addStudent(john);
    awesome.addMentor(mentor);
    awesome.addMentor(gandhi);
    awesome.info();
  }
}
