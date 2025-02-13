package com.capgeminiTrainingPrograms.week4.day3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import java.io.*;
import static org.junit.jupiter.api.Assertions.*;

class FileReadWriteTest {

    private static final String SOURCE_FILE = "C:\\Users\\HI\\IdeaProjects\\projectcapgemini\\week-4\\src\\test\\resources\\testsource.txt";
    private static final String DEST_FILE = "C:\\Users\\HI\\IdeaProjects\\projectcapgemini\\week-4\\src\\test\\resources\\testdestination.txt";

    @BeforeEach
    void setUp() throws IOException {
        // Create a test source file with sample content
        try (FileOutputStream fos = new FileOutputStream(SOURCE_FILE)) {
            fos.write("Hello, this is a test file.".getBytes());
        }
    }

    @Test
    void testFileCopySuccess() {
        // Call the main method to perform file copy
        FileReadWrite.main(new String[]{});

        // Verify destination file exists and content matches
        File destFile = new File(DEST_FILE);
        assertTrue(destFile.exists(), "Destination file should exist");

        try (FileInputStream fis = new FileInputStream(DEST_FILE)) {
            byte[] data = fis.readAllBytes();
            assertEquals("Hello, this is a test file.", new String(data));
        } catch (IOException e) {
            fail("Exception occurred while reading the destination file: " + e.getMessage());
        }
    }

    @Test
    void testSourceFileNotFound() {
        // Delete source file to simulate missing file scenario
        new File(SOURCE_FILE).delete();

        // Capture console output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        FileReadWrite.main(new String[]{});

        assertTrue(outContent.toString().contains("Source file not found"), "Error message should be displayed");
    }


}
