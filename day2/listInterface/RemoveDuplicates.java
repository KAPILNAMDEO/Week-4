package com.capgeminiTrainingPrograms.week4.day2.listInterface;

import java.util.*;

public class RemoveDuplicates {
    public static <T> List<T> removeDuplicates(List<T> list) {
        return new ArrayList<>(new LinkedHashSet<>(list));
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, 1, 2, 2, 3, 4);
        System.out.println("Original List: " + numbers);

        List<Integer> uniqueList = removeDuplicates(numbers);
        System.out.println("List After Removing Duplicates: " + uniqueList);
    }
}
