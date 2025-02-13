package com.capgeminiTrainingPrograms.week4.day3;

import java.io.*;
import java.nio.file.*;

public class ImageByteArrayConversion {

    public static void main(String[] args) {
        String originalImagePath = "C:\\Users\\HI\\IdeaProjects\\projectcapgemini\\week-4\\src\\main\\resources\\ImageOriginal.jpg"; // Provide the original image path
        String newImagePath = "C:\\Users\\HI\\IdeaProjects\\projectcapgemini\\week-4\\src\\main\\resources\\NewImage.jpg";     // Provide the new image path

        try {
            // Convert image to byte array
            byte[] imageBytes = imageToByteArray(originalImagePath);

            // Write byte array back to a new image file
            byteArrayToImage(imageBytes, newImagePath);

            // Verify that the new image file is identical to the original
            if (verifyImages(originalImagePath, newImagePath)) {
                System.out.println("The new image file is identical to the original.");
            } else {
                System.out.println("The new image file is not identical to the original.");
            }

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    // Method to convert an image file to a byte array
    public static byte[] imageToByteArray(String imagePath) throws IOException {
        File imageFile = new File(imagePath);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        try (FileInputStream fis = new FileInputStream(imageFile)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }
        }

        return baos.toByteArray();
    }

    // Method to write byte array back to an image file
    public static void byteArrayToImage(byte[] imageBytes, String newImagePath) throws IOException {
        try (ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
             FileOutputStream fos = new FileOutputStream(newImagePath)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = bais.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
        }
    }

    // Method to verify if two files are identical
    public static boolean verifyImages(String originalImagePath, String newImagePath) throws IOException {
        Path originalPath = Paths.get(originalImagePath);
        Path newPath = Paths.get(newImagePath);

        // Compare the sizes of the original and new images
        if (Files.size(originalPath) != Files.size(newPath)) {
            return false;
        }

        // Compare the content of the files byte by byte
        try (InputStream originalStream = Files.newInputStream(originalPath);
             InputStream newStream = Files.newInputStream(newPath)) {

            int byteOriginal, byteNew;
            while ((byteOriginal = originalStream.read()) != -1) {
                byteNew = newStream.read();
                if (byteOriginal != byteNew) {
                    return false;
                }
            }
        }

        return true;
    }
}
