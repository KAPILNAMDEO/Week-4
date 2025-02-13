package com.capgeminiTrainingPrograms.week4.day3;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class UppercaseToLowercaseConverter {

    public static void main(String[] args) {
        String inputFilePath = "C:\\Users\\HI\\IdeaProjects\\projectcapgemini\\week-4\\src\\main\\resources\\input.txt";  // Replace with your input file path
        String outputFilePath = "C:\\Users\\HI\\IdeaProjects\\projectcapgemini\\week-4\\src\\main\\resources\\output.txt"; // Replace with your output file path

        try {
            convertToLowercase(inputFilePath, outputFilePath);
            System.out.println("Conversion completed successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    // Method to convert uppercase letters to lowercase and write to a new file
    public static void convertToLowercase(String inputFilePath, String outputFilePath) throws IOException {
        try (
                // Create FileReader to read from the input file
                FileReader fileReader = new FileReader(inputFilePath, StandardCharsets.UTF_8);

                // Create BufferedReader to buffer input for efficient reading
                BufferedReader bufferedReader = new BufferedReader(fileReader);

                // Create FileWriter to write to the output file
                FileWriter fileWriter = new FileWriter(outputFilePath, StandardCharsets.UTF_8);

                // Create BufferedWriter to buffer output for efficient writing
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)
        ) {
            String line;

            // Read each line from the input file
            while ((line = bufferedReader.readLine()) != null) {
                // Convert the line to lowercase
                String lowerCaseLine = line.toLowerCase();

                // Write the converted line to the output file
                bufferedWriter.write(lowerCaseLine);
                bufferedWriter.newLine(); // Ensure a new line is added after each line of text
            }
        }
    }
}
