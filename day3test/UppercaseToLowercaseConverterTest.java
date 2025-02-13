package com.capgeminiTrainingPrograms.week4.day3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import java.io.*;
import static org.junit.jupiter.api.Assertions.*;

class UppercaseToLowercaseConverterTest {

    private static final String INPUT_FILE_PATH = "testInput.txt";  // Test input file
    private static final String OUTPUT_FILE_PATH = "testOutput.txt"; // Test output file

    @BeforeEach
    void setUp() throws IOException {
        // Create a test input file with mixed case text
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(INPUT_FILE_PATH))) {
            writer.write("HELLO WORLD\n");
            writer.write("JAVA PROGRAMMING\n");
            writer.write("WELCOME TO OPENAI\n");
        }
    }

    @Test
    void testConvertToLowercase() throws IOException {
        // Run the method to convert the text in the input file to lowercase and write to the output file
        UppercaseToLowercaseConverter.convertToLowercase(INPUT_FILE_PATH, OUTPUT_FILE_PATH);

        // Verify that the output file has been created
        File outputFile = new File(OUTPUT_FILE_PATH);
        assertTrue(outputFile.exists(), "Output file should be created.");

        // Read the content from the output file and check if all text is in lowercase
        try (BufferedReader reader = new BufferedReader(new FileReader(OUTPUT_FILE_PATH))) {
            String line;
            int lineNumber = 1;
            while ((line = reader.readLine()) != null) {
                switch (lineNumber) {
                    case 1:
                        assertEquals("hello world", line, "Line 1 should be converted to lowercase.");
                        break;
                    case 2:
                        assertEquals("java programming", line, "Line 2 should be converted to lowercase.");
                        break;
                    case 3:
                        assertEquals("welcome to openai", line, "Line 3 should be converted to lowercase.");
                        break;
                    default:
                        fail("Unexpected line found.");
                }
                lineNumber++;
            }
        }
    }


}
