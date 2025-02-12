package com.capgeminiTrainingPrograms.week4.day2.MapInterface;

import java.io.*;
import java.util.*;
import java.util.regex.*;

public class WordFrequencyCounter {

    public static Map<String, Integer> countWordFrequency(String filePath) throws IOException {
        Map<String, Integer> wordCountMap = new HashMap<>();

        // Reading the file
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Remove punctuation and convert to lowercase
                line = line.replaceAll("[^a-zA-Z0-9\\s]", "").toLowerCase();

                // Split the line into words
                String[] words = line.split("\\s+");

                // Update the word count in the map
                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
                    }
                }
            }
        }

        return wordCountMap;
    }

    public static void printWordFrequencies(Map<String, Integer> wordCountMap) {
        System.out.println("Word Frequency Count:");
        for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        String filePath = "src/main/java/com/capgeminiTrainingPrograms/week4/day2/MapInterface/Input.txt"; // Replace with your file path

        try {
            Map<String, Integer> wordFrequencies = countWordFrequency(filePath);
            printWordFrequencies(wordFrequencies);
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}

