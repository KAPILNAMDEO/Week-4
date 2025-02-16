package com.capgeminiTrainingPrograms.week4.day6Reflectionandannotations.reflection.advancelevel;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class JsonSerializerTest {
    @Test
    void testToJsonWithValidObject() {
        Persons person = new Persons("Alice", 25, false);
        String json = JsonSerializer.toJson(person);

        assertEquals("{\"name\": \"Alice\", \"age\": 25, \"isEmployed\": false}", json);
    }

    @Test
    void testToJsonWithEmptyObject() {
        class EmptyClass {}
        EmptyClass emptyObj = new EmptyClass();
        String json = JsonSerializer.toJson(emptyObj);

        assertEquals("{}", json);
    }

    @Test
    void testToJsonWithDifferentDataTypes() {
        class TestClass {
            private int number = 10;
            private double price = 99.99;
            private String message = "Hello";
        }
        TestClass testObj = new TestClass();
        String json = JsonSerializer.toJson(testObj);

        assertEquals("{\"number\": 10, \"price\": 99.99, \"message\": \"Hello\"}", json);
    }
}
