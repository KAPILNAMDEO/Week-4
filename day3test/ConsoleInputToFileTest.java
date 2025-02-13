package com.capgeminiTrainingPrograms.week4.day3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import java.io.*;
import static org.junit.jupiter.api.Assertions.*;

class ConsoleInputToFileTest {

    private static final String FILE_NAME = "src/test/java/com/capgeminiTrainingPrograms/week4/day3/test_userdata.txt";

    @Test
    void testUserInputToFile() throws IOException {
        // Simulate user input
        String simulatedInput = "John\n25\nJava\n";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);

        // Run the main method
        ConsoleInputToFile.main(new String[]{});

        // Verify file exists
        File file = new File(FILE_NAME);
        assertTrue(file.exists(), "File should be created");

        // Verify file content
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            assertEquals("Name: John", reader.readLine());
            assertEquals("Age: 25", reader.readLine());
            assertEquals("Favorite Language: Java", reader.readLine());
        }
    }

    @AfterEach
    void tearDown() {
        // Delete the test file
        File file = new File(FILE_NAME);
        if (file.exists()) {
            file.delete();
        }
    }
}