package com.capgeminiTrainingPrograms.week4.day6Reflectionandannotations.reflection.advancelevel;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

class ObjectMapper {
    public static <T> T toObject(Class<T> clazz, Map<String, Object> properties) {
        try {
            // Create an instance of the class
            T instance = clazz.getDeclaredConstructor().newInstance();

            // Iterate through the map and set values
            for (Map.Entry<String, Object> entry : properties.entrySet()) {
                String fieldName = entry.getKey();
                Object fieldValue = entry.getValue();

                try {
                    Field field = clazz.getDeclaredField(fieldName);
                    field.setAccessible(true); // Allow modification of private fields
                    field.set(instance, fieldValue);
                } catch (NoSuchFieldException e) {
                    System.out.println("Warning: No field named '" + fieldName + "' in class " + clazz.getSimpleName());
                }
            }
            return instance;
        } catch (Exception e) {
            throw new RuntimeException("Error creating object", e);
        }
    }
}

// Sample Class to Test
class Person {
    private String name;
    private int age;

    public void display() {
        System.out.println("Name: " + name + ", Age: " + age);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

// Main Method to Demonstrate Usage


public class ObjectMappingDemo {
    public static void main(String[] args) {
        // Create property map
        Map<String, Object> properties = new HashMap<>();
        properties.put("name", "John Doe");
        properties.put("age", 30);

        // Convert map to object
        Person person = ObjectMapper.toObject(Person.class, properties);

        // Display the mapped values
        person.display();
    }
}
