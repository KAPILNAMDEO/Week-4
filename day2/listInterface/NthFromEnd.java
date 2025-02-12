package com.capgeminiTrainingPrograms.week4.day2.listInterface;

import java.util.LinkedList;
import java.util.ListIterator;

public class NthFromEnd {
    public static <T> T findNthFromEnd(LinkedList<T> list, int n) {
        if (list == null || n <= 0) {
            throw new IllegalArgumentException("Invalid input: List cannot be null and N must be positive.");
        }

        ListIterator<T> first = list.listIterator();
        ListIterator<T> second = list.listIterator();

        // Move the first pointer N steps ahead
        for (int i = 0; i < n; i++) {
            if (!first.hasNext()) {
                throw new IllegalArgumentException("N is greater than the size of the list.");
            }
            first.next();
        }

        // Move both pointers until first reaches the end
        while (first.hasNext()) {
            first.next();
            second.next();
        }

        return second.next(); // Nth element from end
    }

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");

        int N = 2;
        System.out.println("Nth element from end: " + findNthFromEnd(list, N)); // Output: D
    }
}

