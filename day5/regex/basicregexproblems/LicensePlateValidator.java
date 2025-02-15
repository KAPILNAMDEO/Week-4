/*2️ Validate a License Plate Number
License plate format: Starts with two uppercase letters, followed by four digits.
Example: "AB1234" is valid, but "A12345" is invalid.*/
package com.capgeminiTrainingPrograms.week4.day5.regex.basicregexproblems;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LicensePlateValidator {
    public static boolean isValidLicenseNumber(String LicenseNumber){
        String regex="^[A-Z]{2}\\d{4}";
        // Compile the pattern
        Pattern pattern=Pattern.compile(regex);

        // Match the pattern with input
        Matcher matcher=pattern.matcher(LicenseNumber);
        return matcher.matches();
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        // Get user input
        System.out.println("Enter License Number ");
        String LicenseNumber= sc.nextLine();

        // Validate and print result
        if(isValidLicenseNumber(LicenseNumber)){
            System.out.println("Valid License Number!");
        }
        else{
            System.out.println("InValid License Number!");
        }

    }
}
