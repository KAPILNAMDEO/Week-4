package com.capgeminiTrainingPrograms.week4.day3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import java.io.*;
import static org.junit.jupiter.api.Assertions.*;

class BufferedFileCopyTest {

    private static final String SOURCE_FILE = "src/test/java/com/capgeminiTrainingPrograms/week4/day3/Test_largeFile.txtt";
    private static final String DEST_FILE_BUFFERED = "src/test/java/com/capgeminiTrainingPrograms/week4/day3/test_copy_buffered.txt";
    private static final String DEST_FILE_UNBUFFERED = "src/test/java/com/capgeminiTrainingPrograms/week4/day3/test_copy_unbuffered.txt";
    private static final long FILE_SIZE = 5L * 1024 * 1024; // 5MB for testing

    @BeforeEach
    void setUp() throws IOException {
        // Create a test source file with sample content
        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(SOURCE_FILE))) {
            byte[] data = new byte[4096];
            for (long i = 0; i < FILE_SIZE / 4096; i++) {
                bos.write(data);
            }
        }
    }

    @Test
    void testCopyFileWithBuffer() {
        long timeTaken = BufferedFileCopy.copyFileWithBuffer(SOURCE_FILE, DEST_FILE_BUFFERED);
        File copiedFile = new File(DEST_FILE_BUFFERED);
        assertTrue(copiedFile.exists(), "Buffered copy should create a file");
        assertEquals(FILE_SIZE, copiedFile.length(), "Buffered copied file should match original size");
        assertTrue(timeTaken > 0, "Time taken should be positive");
    }

    @Test
    void testCopyFileWithoutBuffer() {
        long timeTaken = BufferedFileCopy.copyFileWithoutBuffer(SOURCE_FILE, DEST_FILE_UNBUFFERED);
        File copiedFile = new File(DEST_FILE_UNBUFFERED);
        assertTrue(copiedFile.exists(), "Unbuffered copy should create a file");
        assertEquals(FILE_SIZE, copiedFile.length(), "Unbuffered copied file should match original size");
        assertTrue(timeTaken > 0, "Time taken should be positive");
    }

    @AfterEach
    void tearDown() {
        // Clean up test files
        new File(SOURCE_FILE).delete();
        new File(DEST_FILE_BUFFERED).delete();
        new File(DEST_FILE_UNBUFFERED).delete();
    }
}