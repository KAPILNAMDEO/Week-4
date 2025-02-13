package com.capgeminiTrainingPrograms.week4.day3;



import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class WordCountInFile {

    public static void main(String[] args) {
        // Specify the file path here
        String filePath = "C:\\Users\\HI\\IdeaProjects\\projectcapgemini\\week-4\\src\\main\\resources\\WordCountInFile.txt";

        // Use a HashMap to count the frequency of each word
        Map<String, Integer> wordCountMap = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            // Read the file line by line
            while ((line = reader.readLine()) != null) {
                // Split the line into words
                String[] words = line.split("\\W+"); // Use non-word characters as delimiters

                // Update the word count map
                for (String word : words) {
                    if (!word.isEmpty()) {
                        word = word.toLowerCase(); // Convert to lowercase to count words case-insensitively
                        wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
                    }
                }
            }

            // Sort the words based on frequency
            List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(wordCountMap.entrySet());
            sortedList.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));

            // Display the total word count and top 5 most frequent words
            System.out.println("Total words in the file: " + wordCountMap.size());

            System.out.println("Top 5 most frequent words:");
            for (int i = 0; i < 5 && i < sortedList.size(); i++) {
                Map.Entry<String, Integer> entry = sortedList.get(i);
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

