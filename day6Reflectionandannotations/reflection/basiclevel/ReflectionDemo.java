package com.capgeminiTrainingPrograms.week4.day6Reflectionandannotations.reflection.basiclevel;

import java.lang.reflect.Field;

class Person {
    private int age;

    public Person(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}

public class ReflectionDemo {
    public static void main(String[] args) {
        try {
            Person person = new Person(25);

            // Get the private field "age"
            Field ageField = Person.class.getDeclaredField("age");

            // Make it accessible
            ageField.setAccessible(true);

            // Modify the value
            ageField.set(person, 30);

            // Retrieve the modified value
            System.out.println("Modified Age: " + ageField.get(person));
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
