package com.capgeminiTrainingPrograms.week4.day6Reflectionandannotations.reflection.basiclevel;

import java.lang.reflect.Field;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ReflectionDemoTest {
    @Test
    void testModifyPrivateField() throws Exception {
        Person person = new Person(25);
        Field ageField = Person.class.getDeclaredField("age");
        ageField.setAccessible(true);

        // Modify age field
        ageField.set(person, 40);

        // Check if the modification was successful
        assertEquals(40, ageField.get(person));
    }

    @Test
    void testRetrievePrivateField() throws Exception {
        Person person = new Person(35);
        Field ageField = Person.class.getDeclaredField("age");
        ageField.setAccessible(true);

        // Check if the retrieved value is correct
        assertEquals(35, ageField.get(person));
    }
}
