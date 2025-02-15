/*A valid username:
Can only contain letters (a-z, A-Z), numbers (0-9), and underscores (_)
Must start with a letter
Must be between 5 to 15 characters long
🔹 Example Inputs & Outputs
✅ "user_123" → Valid
❌ "123user" → Invalid (starts with a number)
❌ "us" → Invalid (too short)*/

package com.capgeminiTrainingPrograms.week4.day5.regex.basicregexproblems;

import java.util.regex.*;
import java.util.Scanner;

public class ValidateUsername {
    public static boolean isValidUsername(String username) {
        // Define the regex pattern
        String regex = "^[a-zA-Z][a-zA-Z0-9_]{4,14}$";

        // Compile the pattern
        Pattern pattern = Pattern.compile(regex);

        // Match the pattern with input
        Matcher matcher = pattern.matcher(username);

        // Return whether it matches
        return matcher.matches();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get user input
        System.out.print("Enter a username: ");
        String username = scanner.nextLine();

        // Validate and print result
        if (isValidUsername(username)) {
            System.out.println(" Valid username!");
        } else {
            System.out.println(" Invalid username!");
        }

        scanner.close();
    }
}