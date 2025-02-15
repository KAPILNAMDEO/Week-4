/*9️⃣ Censor Bad Words in a Sentence
Given a list of bad words, replace them with ****.
🔹 Example Input:
"This is a damn bad example with some stupid words."
🔹 Expected Output:
"This is a **** bad example with some **** words."*/
package com.capgeminiTrainingPrograms.week4.day5.regex.replaceandmodifystrings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CensorBadWords {
    public static String censorBadWords(String text, String[] badWords) {
        for (String word : badWords) {
            // Create a regex pattern to match the word as a whole word
            Pattern pattern = Pattern.compile("\\b" + word + "\\b", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(text);

            // Replace the bad word with asterisks
            text = matcher.replaceAll("****");
        }
        return text;
    }

    public static void main(String[] args) {
        String input = "This is a damn bad example with some stupid words.";
        String[] badWords = {"damn", "stupid"};

        String output = censorBadWords(input, badWords);

        System.out.println("Original: " + input);
        System.out.println("Censored: " + output);
    }
}

