package com.capgeminiTrainingPrograms.week4.day2.MapInterface;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class WordFrequencyCounterTest {

    private String testFilePath;

    @BeforeEach
    void setUp() throws IOException {
        // Create a temporary file to use in the tests
        testFilePath = "testInput.txt";
        String content = "Hello world, hello Java!";  // Example content for the file
        Files.write(Paths.get(testFilePath), content.getBytes());
    }

    @Test
    void testCountWordFrequency() throws IOException {
        // Count word frequencies using the method
        Map<String, Integer> wordFrequencies = WordFrequencyCounter.countWordFrequency(testFilePath);

        // Assert that the word frequencies are counted correctly
        assertEquals(2, wordFrequencies.get("hello"));
        assertEquals(1, wordFrequencies.get("world"));
        assertEquals(1, wordFrequencies.get("java"));
    }

    @Test
    void testCaseInsensitivity() throws IOException {
        // Test case insensitivity by changing the case of input text
        String content = "HELLO World, hello JAVA!";
        Files.write(Paths.get(testFilePath), content.getBytes());

        Map<String, Integer> wordFrequencies = WordFrequencyCounter.countWordFrequency(testFilePath);

        // Assert that "HELLO" and "hello" are counted as the same word
        assertEquals(2, wordFrequencies.get("hello"));
        assertEquals(1, wordFrequencies.get("world"));
        assertEquals(1, wordFrequencies.get("java"));
    }

    @Test
    void testPunctuationHandling() throws IOException {
        // Test that punctuation is removed correctly
        String content = "Hello, world... hello Java!";
        Files.write(Paths.get(testFilePath), content.getBytes());

        Map<String, Integer> wordFrequencies = WordFrequencyCounter.countWordFrequency(testFilePath);

        // Assert that punctuation is removed and the words are counted
        assertEquals(2, wordFrequencies.get("hello"));
        assertEquals(1, wordFrequencies.get("world"));
        assertEquals(1, wordFrequencies.get("java"));
    }

    @Test
    void testEmptyFile() throws IOException {
        // Test with an empty file
        String content = "";
        Files.write(Paths.get(testFilePath), content.getBytes());

        Map<String, Integer> wordFrequencies = WordFrequencyCounter.countWordFrequency(testFilePath);

        // Assert that the result is an empty map for an empty file
        assertTrue(wordFrequencies.isEmpty());
    }

    @Test
    void testMultipleSpaces() throws IOException {
        // Test with multiple spaces between words
        String content = "Hello    world   hello     Java!";
        Files.write(Paths.get(testFilePath), content.getBytes());

        Map<String, Integer> wordFrequencies = WordFrequencyCounter.countWordFrequency(testFilePath);

        // Assert that multiple spaces are handled correctly
        assertEquals(2, wordFrequencies.get("hello"));
        assertEquals(1, wordFrequencies.get("world"));
        assertEquals(1, wordFrequencies.get("java"));
    }

    @Test
    void testFileNotFound() {
        // Test with a non-existent file path
        String invalidFilePath = "nonExistentFile.txt";
        assertThrows(IOException.class, () -> {
            WordFrequencyCounter.countWordFrequency(invalidFilePath);
        });
    }
}
