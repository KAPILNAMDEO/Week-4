package com.capgeminiTrainingPrograms.week4.day6Reflectionandannotations.reflection.basiclevel;

import java.lang.reflect.Method;

class Calculator {
    private int multiply(int a, int b) {
        return a * b;
    }
}

public class ReflectionInvokeDemo {
    public static void main(String[] args) {
        try {
            Calculator calculator = new Calculator();

            // Get the private method "multiply"
            Method multiplyMethod = Calculator.class.getDeclaredMethod("multiply", int.class, int.class);

            // Make it accessible
            multiplyMethod.setAccessible(true);

            // Invoke the method
            int result = (int) multiplyMethod.invoke(calculator, 5, 10);

            // Display the result
            System.out.println("Multiplication Result: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

