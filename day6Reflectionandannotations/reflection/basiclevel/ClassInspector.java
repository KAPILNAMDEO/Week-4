package com.capgeminiTrainingPrograms.week4.day6Reflectionandannotations.reflection.basiclevel;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Scanner;

public class ClassInspector {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the fully qualified class name: ");
        String className = scanner.nextLine();
        scanner.close();

        try {
            // Load the class dynamically
            Class<?> clazz = Class.forName(className);

            // Display class name
            System.out.println("Class: " + clazz.getName());

            // Display fields
            System.out.println("\nFields:");
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                System.out.println(field);
            }

            // Display methods
            System.out.println("\nMethods:");
            Method[] methods = clazz.getDeclaredMethods();
            for (Method method : methods) {
                System.out.println(method);
            }

            // Display constructors
            System.out.println("\nConstructors:");
            Constructor<?>[] constructors = clazz.getDeclaredConstructors();
            for (Constructor<?> constructor : constructors) {
                System.out.println(constructor);
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found: " + className);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

