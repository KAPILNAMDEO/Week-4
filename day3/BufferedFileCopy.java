package com.capgeminiTrainingPrograms.week4.day3;

import java.io.*;

public class BufferedFileCopy {
    public static void main(String[] args) {
        String sourceFile = "src/main/java/com/capgeminiTrainingPrograms/week4/day3/LargeFile.txt";
        String destFileBuffered = "src/main/java/com/capgeminiTrainingPrograms/week4/day3/copy_buffered.txt";
        String destFileUnbuffered = "src/main/java/com/capgeminiTrainingPrograms/week4/day3/copy_unbuffered.txt";
        System.out.println("reading file....");
        long bufferedTime = copyFileWithBuffer(sourceFile, destFileBuffered);
        long unbufferedTime = copyFileWithoutBuffer(sourceFile, destFileUnbuffered);

        System.out.println("Buffered Stream Time: " + bufferedTime + " ns");
        System.out.println("Unbuffered Stream Time: " + unbufferedTime + " ns");
    }

    public static long copyFileWithBuffer(String source, String destination) {
        long startTime = System.nanoTime();
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destination))) {

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            System.out.println("Error copying file with buffer: " + e.getMessage());
        }
        return System.nanoTime() - startTime;
    }

    public static long copyFileWithoutBuffer(String source, String destination) {
        long startTime = System.nanoTime();
        try (FileInputStream fis = new FileInputStream(source);
             FileOutputStream fos = new FileOutputStream(destination)) {

            int byteData;
            while ((byteData = fis.read()) != -1) {
                fos.write(byteData);
            }
        } catch (IOException e) {
            System.out.println("Error copying file without buffer: " + e.getMessage());
        }
        return System.nanoTime() - startTime;
    }
}
