/*7️⃣ Extract Links from a Web Page
🔹 Example Text:
"Visit https://www.google.com and http://example.org for more info."
🔹 Expected Output:
https://www.google.com, http://example.org*/
package com.capgeminiTrainingPrograms.week4.day5.regex.extractedproblems;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractsLinkFromWebPage {
    public static List<String> extractLinkes(String text) {
        String regex = "https?://(www\\.)?([a-zA-Z0-9.-]+)"; // Matches links

        // Compile pattern
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        // List to store extracted links
        List<String> links = new ArrayList<>();

        while (matcher.find()) {
            links.add(matcher.group());
        }

        return links;
    }

    public static void main(String[] args) {
        String text = "Visit https://www.google.com and http://example.org for more info.";

        List<String> links = extractLinkes(text);

        if (links.isEmpty()) {
            System.out.println("No linkes found.");
        } else {
            System.out.println("Extracted links  are:");
            System.out.println(String.join(", ", links));
        }
    }
}
