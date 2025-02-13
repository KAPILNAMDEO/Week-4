package com.capgeminiTrainingPrograms.week4.day3;

import java.io.*;

public class ConsoleInputToFile {
    public static void main(String[] args) {
        String fileName = "src/main/java/com/capgeminiTrainingPrograms/week4/day3/user_data.txt";

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileWriter writer = new FileWriter(fileName)) {

            System.out.print("Enter your name: ");
            String name = reader.readLine();

            System.out.print("Enter your age: ");
            String age = reader.readLine();

            System.out.print("Enter your favorite programming language: ");
            String language = reader.readLine();

            writer.write("Name: " + name + "\n");
            writer.write("Age: " + age + "\n");
            writer.write("Favorite Language: " + language + "\n");

            System.out.println("User data saved successfully to " + fileName);
        } catch (IOException e) {
            System.out.println("An error occurred while reading input or writing to file: " + e.getMessage());
        }
    }
}
