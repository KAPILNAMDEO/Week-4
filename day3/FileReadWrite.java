package com.capgeminiTrainingPrograms.week4.day3;

import java.io.*;

public class FileReadWrite {
    public static void main(String[] args) {
        String sourceFile = "src/main/java/com/capgeminiTrainingPrograms/week4/day3/Source.txt";  // Source file name
        String destinationFile = "src/main/java/com/capgeminiTrainingPrograms/week4/day3/Destination.txt";  // Destination file name

        try (FileInputStream fis = new FileInputStream(sourceFile);
             FileOutputStream fos = new FileOutputStream(destinationFile)) {

            int byteData;
            while ((byteData = fis.read()) != -1) {
                fos.write(byteData);
            }
            System.out.println("File copied successfully.");
        } catch (FileNotFoundException e) {
            System.out.println("Source file not found: " + sourceFile);
        } catch (IOException e) {
            System.out.println("An error occurred while reading/writing the file.");
            e.printStackTrace();
        }
    }
}

