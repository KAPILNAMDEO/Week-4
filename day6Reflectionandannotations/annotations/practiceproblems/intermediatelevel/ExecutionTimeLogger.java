package com.capgeminiTrainingPrograms.week4.day6Reflectionandannotations.annotations.practiceproblems.intermediatelevel;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

// Define the annotation
@Retention(RetentionPolicy.RUNTIME) // Retained at runtime for reflection
@Target(ElementType.METHOD) // Can only be applied to methods
@interface LogExecutionTime {
}

class PerformanceTest {

    @LogExecutionTime
    public void fastMethod() {
        System.out.println("Executing fast method...");
    }

    @LogExecutionTime
    public void slowMethod() {
        System.out.println("Executing slow method...");
        try {
            Thread.sleep(500); // Simulating a slow process
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void normalMethod() {
        System.out.println("Executing normal method...");
    }
}



public class ExecutionTimeLogger {
    public static void main(String[] args) throws Exception {
        PerformanceTest obj = new PerformanceTest();
        Method[] methods = obj.getClass().getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(LogExecutionTime.class)) {
                long startTime = System.nanoTime();
                method.invoke(obj);
                long endTime = System.nanoTime();

                System.out.println("Method: " + method.getName() +
                        " | Execution Time: " + (endTime - startTime) / 1_000_000.0 + " ms");
                System.out.println("----------------------");
            }
        }
    }
}

