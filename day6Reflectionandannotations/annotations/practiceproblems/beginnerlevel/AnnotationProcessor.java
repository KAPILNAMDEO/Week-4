package com.capgeminiTrainingPrograms.week4.day6Reflectionandannotations.annotations.practiceproblems.beginnerlevel;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

// Define the annotation
@Retention(RetentionPolicy.RUNTIME) // Retained at runtime for reflection
@Target(ElementType.METHOD) // Can only be applied to methods
@interface ImportantMethod {
    String level() default "HIGH"; // Optional parameter with a default value
}

class Application {

    @ImportantMethod(level = "CRITICAL")
    public void processData() {
        System.out.println("Processing data...");
    }

    @ImportantMethod // Uses default level "HIGH"
    public void saveData() {
        System.out.println("Saving data...");
    }

    public void logData() {
        System.out.println("Logging data...");
    }
}



public class AnnotationProcessor {
    public static void main(String[] args) {
        Class<Application> clazz = Application.class;
        Method[] methods = clazz.getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(ImportantMethod.class)) {
                ImportantMethod annotation = method.getAnnotation(ImportantMethod.class);
                System.out.println("Method: " + method.getName() + " | Importance Level: " + annotation.level());
            }
        }
    }
}

