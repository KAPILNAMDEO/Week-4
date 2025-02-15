package com.capgeminiTrainingPrograms.week4.day5.regex.advanceproblems;

import java.util.regex.*;

public class IPaddressValidator {
    public static boolean isValidIPAddress(String ip) {
        // Regular expression for IPv4 validation
        String regex = "^(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9]?[0-9])\\."
                + "(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9]?[0-9])\\."
                + "(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9]?[0-9])\\."
                + "(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9]?[0-9])$";

        // Compile pattern
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(ip);

        // Return whether IP matches the pattern
        return matcher.matches();
    }

    public static void main(String[] args) {
        String[] testIPs = {"192.168.1.1", "255.255.255.255", "256.100.50.25", "123.045.067.089"};

        for (String ip : testIPs) {
            System.out.println(ip + " is " + (isValidIPAddress(ip) ? "Valid" : "Invalid"));
        }
    }
}

