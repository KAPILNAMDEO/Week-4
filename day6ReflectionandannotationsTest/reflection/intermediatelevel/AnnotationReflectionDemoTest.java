package com.capgeminiTrainingPrograms.week4.day6Reflectionandannotations.reflection.intermediatelevel;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AnnotationReflectionTest {
    @Test
    void testAuthorAnnotationExists() {
        // Get the Book class
        Class<Book> bookClass = Book.class;

        // Check if @Author annotation is present
        assertTrue(bookClass.isAnnotationPresent(Author.class));

        // Retrieve the annotation
        Author author = bookClass.getAnnotation(Author.class);

        // Verify annotation value
        assertEquals("John Doe", author.name());
    }

    @Test
    void testAnnotationNotPresentOnOtherClass() {
        class UnrelatedClass {}

        // Ensure that an unrelated class does not have the annotation
        assertFalse(UnrelatedClass.class.isAnnotationPresent(Author.class));
    }
}
