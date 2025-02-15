package com.capgeminiTrainingPrograms.week4.day5.regex.advanceproblems;

import java.util.*;
import java.util.regex.*;

public class CurrencyExtractor {
    public static List<String> extractCurrencyValues(String text) {
        // Regex to match currency values like $45.99, 10.50, $100, etc.
        String regex = "\\$?\\d+(\\.\\d{2})?";

        // Compile pattern
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        // List to store extracted values
        List<String> currencyValues = new ArrayList<>();

        while (matcher.find()) {
            currencyValues.add(matcher.group());
        }

        return currencyValues;
    }

    public static void main(String[] args) {
        String text = "The price is $45.99, and the discount is 10.50.";

        List<String> currencyValues = extractCurrencyValues(text);

        if (currencyValues.isEmpty()) {
            System.out.println("No currency values found.");
        } else {
            System.out.println("Extracted Currency Values: " + String.join(", ", currencyValues));
        }
    }
}
