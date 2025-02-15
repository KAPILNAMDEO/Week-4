package com.capgeminiTrainingPrograms.week4.day5.regex.advanceproblems;

import java.util.*;
import java.util.regex.*;

public class ProgrammingLanguageExtractor {
    public static List<String> extractLanguages(String text) {
        // List of programming languages to match
        String regex = "\\b(JavaScript|Java|Python|Go|C\\+\\+|C#|Ruby|Swift|PHP|Kotlin|Rust|TypeScript)\\b";

        // Compile pattern
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        // List to store extracted languages
        List<String> languages = new ArrayList<>();

        while (matcher.find()) {
            languages.add(matcher.group());
        }

        return languages;
    }

    public static void main(String[] args) {
        String text = "I love Java, Python, and JavaScript, but I haven't tried Go yet.";

        List<String> languages = extractLanguages(text);

        if (languages.isEmpty()) {
            System.out.println("No programming languages found.");
        } else {
            System.out.println("Extracted Languages: " + String.join(", ", languages));
        }
    }
}

