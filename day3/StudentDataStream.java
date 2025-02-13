package com.capgeminiTrainingPrograms.week4.day3;

import java.io.*;
import java.util.*;

class Student {
    private int rollNumber;
    private String name;
    private double gpa;

    public Student(int rollNumber, String name, double gpa) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.gpa = gpa;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public String getName() {
        return name;
    }

    public double getGpa() {
        return gpa;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollNumber=" + rollNumber +
                ", name='" + name + '\'' +
                ", gpa=" + gpa +
                '}';
    }
}

public class StudentDataStream {

    public static void main(String[] args) {
        String filePath = "C:\\Users\\HI\\IdeaProjects\\projectcapgemini\\week-4\\src\\test\\resources\\studentDetails.txt";  // Path to the binary file

        // Create some student objects to store
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Alice", 3.8));
        students.add(new Student(2, "Bob", 3.5));
        students.add(new Student(3, "Charlie", 3.9));

        // Store student details in the binary file
        try {
            storeStudentDetails(filePath, students);
            System.out.println("Student details stored successfully.");
        } catch (IOException e) {
            System.out.println("Error storing student details: " + e.getMessage());
        }

        // Retrieve and print student details from the binary file
        try {
            List<Student> retrievedStudents = retrieveStudentDetails(filePath);
            System.out.println("Retrieved student details:");
            retrievedStudents.forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("Error retrieving student details: " + e.getMessage());
        }
    }

    // Method to store student details in a binary file
    public static void storeStudentDetails(String filePath, List<Student> students) throws IOException {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(filePath))) {
            for (Student student : students) {
                dos.writeInt(student.getRollNumber());  // Write roll number
                dos.writeUTF(student.getName());        // Write name (UTF-8 encoded string)
                dos.writeDouble(student.getGpa());      // Write GPA
            }
        }
    }

    // Method to retrieve student details from a binary file
    public static List<Student> retrieveStudentDetails(String filePath) throws IOException {
        List<Student> students = new ArrayList<>();
        try (DataInputStream dis = new DataInputStream(new FileInputStream(filePath))) {
            while (dis.available() > 0) {
                int rollNumber = dis.readInt();  // Read roll number
                String name = dis.readUTF();     // Read name
                double gpa = dis.readDouble();   // Read GPA
                students.add(new Student(rollNumber, name, gpa));
            }
        }
        return students;
    }
}
