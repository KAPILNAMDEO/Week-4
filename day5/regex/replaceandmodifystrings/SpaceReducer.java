package com.capgeminiTrainingPrograms.week4.day5.regex.replaceandmodifystrings;

import java.util.regex.*;

public class SpaceReducer {
    public static String replaceMultipleSpaces(String text) {
        // Initialize pattern for multiple spaces
        Pattern pattern = Pattern.compile("\\s+");
        Matcher matcher = pattern.matcher(text);

        // Replace multiple spaces with a single space
        return matcher.replaceAll(" ");
    }

    public static void main(String[] args) {
        String input = "This   is  an   example    with multiple   spaces.";
        String output = replaceMultipleSpaces(input);

        System.out.println("Original: " + input);
        System.out.println("Modified: " + output);
    }
}
