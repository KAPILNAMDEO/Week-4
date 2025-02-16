package com.capgeminiTrainingPrograms.week4.day6Reflectionandannotations.reflection.basiclevel;

import java.lang.reflect.Constructor;

class Student {
    private String name;

    public Student() {
        this.name = "Default Student";
    }

    public Student(String name) {
        this.name = name;
    }

    public void display() {
        System.out.println("Student Name: " + name);
    }
}

public class ReflectionObjectCreation {
    public static void main(String[] args) {
        try {
            // Get the default constructor of Student class
            Constructor<Student> constructor = Student.class.getDeclaredConstructor();

            // Create an instance dynamically
            Student student = constructor.newInstance();

            // Invoke method to display student details
            student.display();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


