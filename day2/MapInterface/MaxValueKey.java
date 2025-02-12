package com.capgeminiTrainingPrograms.week4.day2.MapInterface;

import java.util.*;

public class MaxValueKey {
    public static void main(String[] args) {
        Map<String, Integer> inputMap = new HashMap<>();
        inputMap.put("A", 10);
        inputMap.put("B", 20);
        inputMap.put("C", 15);

        String keyWithMaxValue = getKeyWithMaxValue(inputMap);
        System.out.println("Key with the highest value: " + keyWithMaxValue);
    }

    //Method to find the key with the highest value in the map
    public static String getKeyWithMaxValue(Map<String, Integer> map) {
        String maxKey = null;
        int maxValue = Integer.MIN_VALUE;

        //Iterating through the map
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxValue) {
                maxValue = entry.getValue();
                maxKey = entry.getKey();
            }
        }
        return maxKey;
    }
}
