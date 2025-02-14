package com.capgeminiTrainingPrograms.week4.day4;

import java.util.Scanner;

public class IntegerDivision {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking two integers as input
        System.out.print("Enter the numerator: ");
        int numerator = scanner.nextInt();

        System.out.print("Enter the denominator: ");
        int denominator = scanner.nextInt();

        try {
            // Performing the division
            int result = numerator / denominator;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            // Handling division by zero
            System.out.println("Error: Cannot divide by zero.");
        } finally {
            // Ensuring "Operation completed" is always printed
            System.out.println("Operation completed.");
        }

        scanner.close();
    }
}
