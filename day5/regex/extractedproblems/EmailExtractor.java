package com.capgeminiTrainingPrograms.week4.day5.regex.extractedproblems;



import java.util.regex.*;
import java.util.*;

public class EmailExtractor {
    public static List<String> extractEmails(String text) {
        String regex = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}";

        // Compile pattern
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        // List to store extracted emails
        List<String> emails = new ArrayList<>();

        while (matcher.find()) {
            emails.add(matcher.group());
        }

        return emails;
    }

    public static void main(String[] args) {
        String text = "Contact us at support@example.com and info@company.org for more details.";

        List<String> emails = extractEmails(text);

        if (emails.isEmpty()) {
            System.out.println("No email addresses found.");
        } else {
            System.out.println("Extracted Email Addresses:");
            for (String email : emails) {
                System.out.println(email);
            }
        }
    }
}

