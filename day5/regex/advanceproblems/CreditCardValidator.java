package com.capgeminiTrainingPrograms.week4.day5.regex.advanceproblems;

import java.util.regex.*;

public class CreditCardValidator {
    public static boolean isValidCreditCard(String cardNumber) {
        // Regular expression for Visa (starts with 4, 16 digits) and MasterCard (starts with 5, 16 digits)
        String regex = "^(4\\d{15}|5\\d{15})$";

        // Compile pattern
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(cardNumber);

        // Return whether card number matches the pattern
        return matcher.matches();
    }

    public static void main(String[] args) {
        String[] testCards = {"4111111111111111", "5111111111111111", "6111111111111111", "42222222222222"};

        for (String card : testCards) {
            System.out.println(card + " is " + (isValidCreditCard(card) ? "Valid" : "Invalid"));
        }
    }
}

