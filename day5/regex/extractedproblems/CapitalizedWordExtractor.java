package com.capgeminiTrainingPrograms.week4.day5.regex.extractedproblems;



import java.util.*;
import java.util.regex.*;

public class CapitalizedWordExtractor {
    public static List<String> extractCapitalizedWords(String text) {
        String regex = "\\b[A-Z][a-z]*\\b"; // Matches words starting with a capital letter

        // Compile pattern
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        // List to store extracted words
        List<String> capitalizedWords = new ArrayList<>();

        while (matcher.find()) {
            capitalizedWords.add(matcher.group());
        }

        return capitalizedWords;
    }

    public static void main(String[] args) {
        String text = "The Eiffel Tower is in Paris and the Statue of Liberty is in New York.";

        List<String> capitalizedWords = extractCapitalizedWords(text);

        if (capitalizedWords.isEmpty()) {
            System.out.println("No capitalized words found.");
        } else {
            System.out.println("Extracted Capitalized Words:");
            System.out.println(String.join(", ", capitalizedWords));
        }
    }
}

