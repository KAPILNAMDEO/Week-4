/*Reverse a List
Write a program to reverse the elements of a given List without using built-in reverse methods. Implement it
 for both ArrayList and LinkedList.
Example:
Input: [1, 2, 3, 4, 5] → Output: [5, 4, 3, 2, 1].*/

package com.capgeminiTrainingPrograms.week4.day2.listInterface;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ReverseList {

    // Generic method to reverse a list without using built-in methods
    public static <T> void reverseList(List<T> list) {
        int left = 0, right = list.size() - 1;
        while (left < right) {
            // Swap elements
            T temp = list.get(left);
            list.set(left, list.get(right));
            list.set(right, temp);

            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        // ArrayList example
        List<Integer> arrayList = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            arrayList.add(i);
        }
        System.out.println("Original ArrayList: " + arrayList);
        reverseList(arrayList);
        System.out.println("Reversed ArrayList: " + arrayList);

        // LinkedList example
        List<Integer> linkedList = new LinkedList<>();
        for (int i = 1; i <= 5; i++) {
            linkedList.add(i);
        }
        System.out.println("Original LinkedList: " + linkedList);
        reverseList(linkedList);
        System.out.println("Reversed LinkedList: " + linkedList);
    }
}
