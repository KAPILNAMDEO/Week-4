package com.capgeminiTrainingPrograms.week4.day3;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class ByteArrayInputStreamExample {
    public static void main(String[] args) {
        byte[] data = "Hello, ByteArrayInputStream!".getBytes(); // Convert string to byte array
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(data);

        int byteData;
        while ((byteData = byteArrayInputStream.read()) != -1) {
            System.out.print((char) byteData); // Convert byte to char and print
        }

        try {
            byteArrayInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

