package com.capgeminiTrainingPrograms.week4.day3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import java.io.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class StudentDataStreamTest {

    private static final String FILE_PATH = "C:\\Users\\HI\\IdeaProjects\\projectcapgemini\\week-4\\src\\test\\resources\\teststudentDetails.txt";  // Test binary file path

    @BeforeEach
    void setUp() throws IOException {
        // Create some student objects to store in the binary file
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Alice", 3.8));
        students.add(new Student(2, "Bob", 3.5));
        students.add(new Student(3, "Charlie", 3.9));

        // Store student details in the binary file before each test
        StudentDataStream.storeStudentDetails(FILE_PATH, students);
    }

    @Test
    void testStoreAndRetrieveStudentDetails() throws IOException {
        // Retrieve the student details from the binary file
        List<Student> retrievedStudents = StudentDataStream.retrieveStudentDetails(FILE_PATH);

        // Verify that the retrieved student details match the expected values
        assertEquals(3, retrievedStudents.size(), "The number of students retrieved should be 3.");

        // Check the first student's details
        assertEquals(1, retrievedStudents.get(0).getRollNumber(), "First student roll number should be 1.");
        assertEquals("Alice", retrievedStudents.get(0).getName(), "First student name should be Alice.");
        assertEquals(3.8, retrievedStudents.get(0).getGpa(), 0.01, "First student GPA should be 3.8.");

        // Check the second student's details
        assertEquals(2, retrievedStudents.get(1).getRollNumber(), "Second student roll number should be 2.");
        assertEquals("Bob", retrievedStudents.get(1).getName(), "Second student name should be Bob.");
        assertEquals(3.5, retrievedStudents.get(1).getGpa(), 0.01, "Second student GPA should be 3.5.");

        // Check the third student's details
        assertEquals(3, retrievedStudents.get(2).getRollNumber(), "Third student roll number should be 3.");
        assertEquals("Charlie", retrievedStudents.get(2).getName(), "Third student name should be Charlie.");
        assertEquals(3.9, retrievedStudents.get(2).getGpa(), 0.01, "Third student GPA should be 3.9.");
    }


}
