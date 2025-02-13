package com.capgeminiTrainingPrograms.week4.day3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import java.io.*;
import static org.junit.jupiter.api.Assertions.*;

class ImageByteArrayConversionTest {

    private static final String ORIGINAL_IMAGE_PATH = "C:\\Users\\HI\\IdeaProjects\\projectcapgemini\\week-4\\src\\test\\resources\\TestImageOriginal.jpg"; // Provide the original image path
    private static final String NEW_IMAGE_PATH = "C:\\Users\\HI\\IdeaProjects\\projectcapgemini\\week-4\\src\\test\\resources\\TestNewImage.jpg";     // Provide the new image path

    @Test
    void testImageConversionAndVerification() throws IOException {
        // Step 1: Convert the original image to a byte array
        byte[] imageBytes = ImageByteArrayConversion.imageToByteArray(ORIGINAL_IMAGE_PATH);

        // Step 2: Write the byte array back to a new image file
        ImageByteArrayConversion.byteArrayToImage(imageBytes, NEW_IMAGE_PATH);

        // Step 3: Verify that the new image file is created and identical to the original image
        File newImageFile = new File(NEW_IMAGE_PATH);

        // Check if the new image file exists
        assertTrue(newImageFile.exists(), "New image file should be created.");

        // Verify that the new image file is identical to the original
        boolean areIdentical = ImageByteArrayConversion.verifyImages(ORIGINAL_IMAGE_PATH, NEW_IMAGE_PATH);

        // Assert that the images are identical
        assertTrue(areIdentical, "The new image should be identical to the original.");
    }
}
