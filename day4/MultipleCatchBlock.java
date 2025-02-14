/*4. Multiple Catch Blocks
💡 Problem Statement:
Create a Java program that performs array operations.
Accept an integer array and an index number.
Retrieve and print the value at that index.
Handle the following exceptions:
ArrayIndexOutOfBoundsException if the index is out of range.
NullPointerException if the array is null.
Expected Behavior:
If valid, print "Value at index X: Y".
If the index is out of bounds, display "Invalid index!".
If the array is null, display "Array is not initialized!".*/
package com.capgeminiTrainingPrograms.week4.day4;

import java.util.Scanner;



public class MultipleCatchBlock {
    public static void main(String[] args) {
        // Initialize Scanner to take user input
        Scanner scanner = new Scanner(System.in);

        // Accept input for array size
        System.out.print("Enter array size: ");
        int size = scanner.nextInt();

        // Create an array of the given size
        int[] arr = new int[size];

        // Accept array values
        System.out.println("Enter " + size + " array elements: ");
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }

        // Accept index to retrieve value
        System.out.print("Enter the index to retrieve value: ");
        int index = scanner.nextInt();

        // Try to retrieve the value at the given index
        try {
            // Null array check (just for demo purposes)
            if (arr == null) {
                throw new NullPointerException();
            }

            // Attempt to retrieve the value at the given index
            System.out.println("Value at index " + index + ": " + arr[index]);
        }
        // Handle ArrayIndexOutOfBoundsException if index is out of bounds
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index!");
        }
        // Handle NullPointerException if array is null
        catch (NullPointerException e) {
            System.out.println("Array is not initialized!");
        }
    }
}
