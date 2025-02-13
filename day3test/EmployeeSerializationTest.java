package com.capgeminiTrainingPrograms.week4.day3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import java.io.*;
import java.util.*;



class EmployeeSerializationTest {

    private static final String TEST_FILE_NAME = "C:\\Users\\HI\\IdeaProjects\\projectcapgemini\\week-4\\src\\test\\resources\\employees.ser";

    @BeforeEach
    void setUp() {
        // Cleanup before each test to ensure clean slate
        File file = new File(TEST_FILE_NAME);
        if (file.exists()) {
            file.delete();
        }
    }

    @Test
    void testSaveEmployees() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "John Doe", "IT", 75000));
        employees.add(new Employee(2, "Jane Smith", "HR", 68000));

        // Save the employees
        EmployeeSerialization.saveEmployees(employees);

        // Verify that the file was created and contains the expected number of employees
        File file = new File(TEST_FILE_NAME);
        assertTrue(file.exists(), "Serialized file should exist.");

        List<Employee> loadedEmployees = EmployeeSerialization.loadEmployees();
        assertEquals(2, loadedEmployees.size(), "The number of employees should be 2.");
    }

    @Test
    void testLoadEmployees() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "John Doe", "IT", 75000));
        employees.add(new Employee(2, "Jane Smith", "HR", 68000));

        // Save the employees
        EmployeeSerialization.saveEmployees(employees);

        // Load the employees
        List<Employee> loadedEmployees = EmployeeSerialization.loadEmployees();

        // Verify the loaded employees
        assertNotNull(loadedEmployees, "Loaded employees should not be null.");
        assertEquals(2, loadedEmployees.size(), "The number of loaded employees should be 2.");
        assertEquals("John Doe", loadedEmployees.get(0).toString(), "First employee name should be John Doe.");
        assertEquals("Jane Smith", loadedEmployees.get(1).toString(), "Second employee name should be Jane Smith.");
    }

    @Test
    void testFileNotFoundOnLoad() {
        // Attempt to load employees from a non-existent file
        List<Employee> loadedEmployees = EmployeeSerialization.loadEmployees();

        // Verify that an empty list is returned
        assertTrue(loadedEmployees.isEmpty(), "Loaded employees should be empty when the file is not found.");
    }

    @Test
    void testSaveAndLoadWithEmptyList() {
        List<Employee> emptyList = new ArrayList<>();

        // Save the empty list
        EmployeeSerialization.saveEmployees(emptyList);

        // Load the employees
        List<Employee> loadedEmployees = EmployeeSerialization.loadEmployees();

        // Verify the loaded list is empty
        assertTrue(loadedEmployees.isEmpty(), "Loaded employees should be empty.");
    }

    @AfterEach
    void tearDown() {
        // Clean up after each test
        File file = new File(TEST_FILE_NAME);
        if (file.exists()) {
            file.delete();
        }
    }
}
