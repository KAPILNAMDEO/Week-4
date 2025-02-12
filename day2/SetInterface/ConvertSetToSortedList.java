package com.capgeminiTrainingPrograms.week4.day2.SetInterface;

import java.util.*;

public class ConvertSetToSortedList {
    public static void main(String[] args) {
        Set<Integer> hashSet = new HashSet<>(Arrays.asList(5, 3, 9, 1));

        List<Integer> sortedList = new ArrayList<>(new TreeSet<>(hashSet));

        System.out.println(sortedList); // Output: [1, 3, 5, 9]
    }
}

