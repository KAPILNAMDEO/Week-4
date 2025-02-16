package com.capgeminiTrainingPrograms.week4.day6Reflectionandannotations.annotations.exercise;

class Animal {
    public void makeSound() {
        System.out.println("Animal makes a sound.");
    }
}
class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Dog barks.");
    }
}

public class OverrideDemo {
    public static void main(String[] args) {
        Animal myDog = new Dog(); // Upcasting
        myDog.makeSound(); // Calls overridden method in Dog
    }
}

