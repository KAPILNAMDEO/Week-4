package com.capgeminiTrainingPrograms.week4.day4;

public class ExceptionPropagationByTwoMethods {
    public static void method1() {
        int result = 10 / 0; // This will throw ArithmeticException
    }

    public static void method2() {
        method1(); // Exception propagates to this method
    }

    public static void main(String[] args) {
        try {
            method2(); // Exception propagates to main
        } catch (ArithmeticException e) {
            System.out.println("Handled exception in main");
        }
    }
}
