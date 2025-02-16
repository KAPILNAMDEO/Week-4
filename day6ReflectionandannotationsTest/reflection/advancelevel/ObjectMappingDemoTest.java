package com.capgeminiTrainingPrograms.week4.day6Reflectionandannotations.reflection.advancelevel;

import java.util.HashMap;
import java.util.Map;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ObjectMapperTest {
    @Test
    void testToObjectWithValidFields() {
        // Create property map
        Map<String, Object> properties = new HashMap<>();
        properties.put("name", "Alice");
        properties.put("age", 25);

        // Convert map to object
        Person person = ObjectMapper.toObject(Person.class, properties);

        // Validate the mapped values using reflection
        assertEquals("Alice", person.getName());
        assertEquals(25, person.getAge());
    }

    @Test
    void testToObjectWithInvalidField() {
        Map<String, Object> properties = new HashMap<>();
        properties.put("name", "Bob");
        properties.put("invalidField", "SomeValue"); // This field does not exist

        // Convert map to object
        Person person = ObjectMapper.toObject(Person.class, properties);

        // Validate that only valid fields were set
        assertEquals("Bob", person.getName());
    }

    @Test
    void testToObjectWithEmptyMap() {
        Map<String, Object> properties = new HashMap<>();

        // Convert map to object
        Person person = ObjectMapper.toObject(Person.class, properties);

        // Ensure default values are retained
        assertNull(person.getName());
        assertEquals(0, person.getAge()); // Default value for int
    }
}
