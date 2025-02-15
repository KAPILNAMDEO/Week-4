package com.capgeminiTrainingPrograms.week4.day5.junittesting.basicjunittesting;


import java.util.List;

public class ListManager {

    // Method to add an element to the list
    public static void addElement(List<Integer> list, int element) {
        list.add(element);
    }

    // Method to remove an element from the list
    public static boolean removeElement(List<Integer> list, int element) {
        return list.remove(Integer.valueOf(element)); // Removes by value, not index
    }

    // Method to get the size of the list
    public static int getSize(List<Integer> list) {
        return list.size();
    }
}
