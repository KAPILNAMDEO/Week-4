package com.capgeminiTrainingPrograms.week4.day2.listInterface;

import java.util.*;

public class ListRotator {
    public static <T> void rotateList(List<T> list, int positions) {
        int size = list.size();
        if (size == 0 || positions % size == 0) return; // No rotation needed

        positions = positions % size; // Handle cases where positions > size
        List<T> temp = new ArrayList<>(list.subList(0, positions)); // Store first part

        for (int i = 0; i < size - positions; i++) {
            list.set(i, list.get(i + positions)); // Shift elements left
        }

        for (int i = 0; i < positions; i++) {
            list.set(size - positions + i, temp.get(i)); // Append stored elements
        }
    }

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50));

        System.out.println("Original List: " + numbers);
        rotateList(numbers, 2);
        System.out.println("Rotated List: " + numbers);
    }
}

