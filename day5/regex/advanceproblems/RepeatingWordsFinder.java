package com.capgeminiTrainingPrograms.week4.day5.regex.advanceproblems;

import java.util.*;
import java.util.regex.*;

public class RepeatingWordsFinder {
    public static Set<String> findRepeatingWords(String text) {
        // Regex to match words
        String regex = "\\b(\\w+)\\b";

        // Compile pattern
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        // Map to count word occurrences
        Map<String, Integer> wordCount = new HashMap<>();

        while (matcher.find()) {
            String word = matcher.group().toLowerCase(); // Convert to lowercase for case-insensitive matching
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        // Collect words that appear more than once
        Set<String> repeatingWords = new HashSet<>();
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            if (entry.getValue() > 1) {
                repeatingWords.add(entry.getKey());
            }
        }

        return repeatingWords;
    }

    public static void main(String[] args) {
        String text = "This is is a repeated repeated word test.";

        Set<String> repeatingWords = findRepeatingWords(text);

        if (repeatingWords.isEmpty()) {
            System.out.println("No repeating words found.");
        } else {
            System.out.println("Repeating Words: " + String.join(", ", repeatingWords));
        }
    }
}

