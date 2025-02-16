package com.capgeminiTrainingPrograms.week4.day6Reflectionandannotations.reflection.advancelevel;

import java.lang.reflect.Method;

class SampleMethods {
    public void fastMethod() {
        System.out.println("Fast method executed.");
    }

    public void slowMethod() {
        try {
            Thread.sleep(1000); // Simulating delay
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Slow method executed.");
    }
}



class MethodTimer {
    public static void measureExecutionTime(Object obj) {
        Class<?> clazz = obj.getClass();
        Method[] methods = clazz.getDeclaredMethods();

        for (Method method : methods) {
            if (method.getParameterCount() == 0) { // Ensuring method has no parameters
                try {
                    long startTime = System.nanoTime();
                    method.invoke(obj); // Invoke method dynamically
                    long endTime = System.nanoTime();
                    long executionTime = endTime - startTime;

                    System.out.println("Method: " + method.getName() + " executed in " + executionTime + " nanoseconds.");
                } catch (Exception e) {
                    System.err.println("Error executing method: " + method.getName());
                    e.printStackTrace();
                }
            }
        }
    }
}

public class MethodTimingDemo {
    public static void main(String[] args) {
        SampleMethods sample = new SampleMethods();
        MethodTimer.measureExecutionTime(sample);
    }
}
