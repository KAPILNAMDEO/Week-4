package com.capgeminiTrainingPrograms.week4.day6Reflectionandannotations.annotations.exercise;

import java.util.ArrayList;

public class UncheckedWarningDemo {

    @SuppressWarnings("unchecked")
    public void addElements() {
        ArrayList list = new ArrayList(); // Raw type (without generics)
        list.add("Hello");
        list.add(42);
        list.add(3.14);

        System.out.println("List elements: " + list);
    }

    public static void main(String[] args) {
        UncheckedWarningDemo demo = new UncheckedWarningDemo();
        demo.addElements();
    }
}

