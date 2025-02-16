package com.capgeminiTrainingPrograms.week4.day6Reflectionandannotations.annotations.practiceproblems.intermediatelevel;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

// Define the annotation
@Retention(RetentionPolicy.RUNTIME) // Retained at runtime for reflection
@Target(ElementType.FIELD) // Can only be applied to fields
@interface MaxLength {
    int value(); // Defines the maximum allowed length
}



class User {

    @MaxLength(10) // Maximum length allowed for username
    private String username;

    public User(String username) {
        validateMaxLength(this, username);
        this.username = username;
    }

    // Validation logic using Reflection
    private void validateMaxLength(Object obj, String value) {
        Class<?> clazz = obj.getClass();
        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(MaxLength.class)) {
                MaxLength annotation = field.getAnnotation(MaxLength.class);
                if (value.length() > annotation.value()) {
                    throw new IllegalArgumentException("Field " + field.getName() +
                            " exceeds max length of " + annotation.value());
                }
            }
        }
    }

    public String getUsername() {
        return username;
    }
}

public class MaxLengthTest {
    public static void main(String[] args) {
        try {
            User user1 = new User("JohnDoe"); // Valid case
            System.out.println("User created: " + user1.getUsername());

            User user2 = new User("VeryLongUsername"); // Invalid case (exceeds limit)
            System.out.println("User created: " + user2.getUsername());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
