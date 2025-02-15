package com.capgeminiTrainingPrograms.week4.day5.junittesting.basicjunittesting;


public class ExceptionHandler {

    // Method to perform division and throw ArithmeticException if b is zero
    public static int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return a / b;
    }
}
