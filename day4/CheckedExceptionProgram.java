/*1. Checked Exception (Compile-time Exception)
💡 Problem Statement:
Create a Java program that reads a file named "data.txt". If the file does not exist, handle the IOException properly and display a user-friendly message.
Expected Behavior:
If the file exists, print its contents.
If the file does not exist, catch the IOException and print "File not found".*/
package com.capgeminiTrainingPrograms.week4.day4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CheckedExceptionProgram {
    public static void main(String[] args) {
        String filename="data.txt";
        //written the code inside the try block
        try {
            BufferedReader bufferedReader=new BufferedReader(new FileReader(filename));
            String line;
            while((line=bufferedReader.readLine())!=null){
                System.out.println(line);
            }
        }
        //handle the exception by catch block
        catch (FileNotFoundException e){
            System.out.println("File not found exception: "+e.getMessage());
        }
        catch (IOException e){
            System.out.println("An error occured while reading the file: "+ e.getMessage());
        }

    }
}
