package com.capgeminiTrainingPrograms.week4.day6Reflectionandannotations.reflection.intermediatelevel;

import java.lang.reflect.Method;
import java.util.Scanner;

class MathOperations {
    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }
}

public class ReflectionMethodInvocation {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter method name (add, subtract, multiply): ");
            String methodName = scanner.nextLine();

            System.out.print("Enter first number: ");
            int num1 = scanner.nextInt();

            System.out.print("Enter second number: ");
            int num2 = scanner.nextInt();
            scanner.close();

            // Create an instance of MathOperations
            MathOperations mathOperations = new MathOperations();

            // Get the method dynamically
            Method method = MathOperations.class.getMethod(methodName, int.class, int.class);

            // Invoke the method dynamically
            int result = (int) method.invoke(mathOperations, num1, num2);

            System.out.println("Result: " + result);
        } catch (NoSuchMethodException e) {
            System.out.println("Invalid method name!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
