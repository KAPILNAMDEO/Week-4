/*2. Unchecked Exception (Runtime Exception)
💡 Problem Statement:
Write a Java program that asks the user to enter two numbers and divides them. Handle possible exceptions such as:
ArithmeticException if division by zero occurs.
InputMismatchException if the user enters a non-numeric value.
Expected Behavior:
If the user enters valid numbers, print the result of the division.
If the user enters 0 as the denominator, catch and handle ArithmeticException.
If the user enters a non-numeric value, catch and handle InputMismatchException.*/

package com.capgeminiTrainingPrograms.week4.day4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UncheckedExceptionProgram {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        //code inside the try block to prevent code from exception
        try{
            System.out.print("Enter first number: ");
            int number1 = sc.nextInt();

            System.out.print("Enter second number: ");
            int number2 = sc.nextInt();

            int result =number1/number2;
            System.out.println("The result when divided two number is: "+ result);
        }
        //handle exception by using catch block
        catch (ArithmeticException e){
            System.out.println("Arithmetic Exception occured: "+e.getMessage());
        }
        catch (InputMismatchException e){
            System.out.println("Input MisMatch Exception occured ");
        }

    }
}
