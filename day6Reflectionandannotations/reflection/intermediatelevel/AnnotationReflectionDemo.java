package com.capgeminiTrainingPrograms.week4.day6Reflectionandannotations.reflection.intermediatelevel;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// Step 1: Define the custom annotation
@Retention(RetentionPolicy.RUNTIME)
@interface Author {
    String name();
}

// Step 2: Apply the annotation to a class
@Author(name = "John Doe")
class Book {
    public void display() {
        System.out.println("Book class method called.");
    }
}

// Step 3: Use Reflection to Retrieve the Annotation
public class AnnotationReflectionDemo {
    public static void main(String[] args) {
        try {
            // Get the class object
            Class<Book> bookClass = Book.class;

            // Retrieve the annotation from the class
            if (bookClass.isAnnotationPresent(Author.class)) {
                Author author = bookClass.getAnnotation(Author.class);
                System.out.println("Author: " + author.name());
            } else {
                System.out.println("No @Author annotation present.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
