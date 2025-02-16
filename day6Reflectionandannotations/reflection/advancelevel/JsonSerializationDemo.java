package com.capgeminiTrainingPrograms.week4.day6Reflectionandannotations.reflection.advancelevel;

import java.lang.reflect.Field;

class JsonSerializer {
    public static String toJson(Object obj) {
        StringBuilder json = new StringBuilder("{");

        Class<?> objClass = obj.getClass();
        Field[] fields = objClass.getDeclaredFields();
        boolean firstField = true;

        for (Field field : fields) {
            field.setAccessible(true);
            try {
                if (!firstField) {
                    json.append(", ");
                }
                json.append("\"").append(field.getName()).append("\": ");
                Object value = field.get(obj);

                if (value instanceof String) {
                    json.append("\"").append(value).append("\"");
                } else {
                    json.append(value);
                }
                firstField = false;
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        json.append("}");
        return json.toString();
    }
}

// Sample Class to Test
class Persons {
    private String name;
    private int age;
    private boolean isEmployed;

    public Persons(String name, int age, boolean isEmployed) {
        this.name = name;
        this.age = age;
        this.isEmployed = isEmployed;
    }
}

// Main Method to Demonstrate Usage
public class JsonSerializationDemo {
    public static void main(String[] args) {
        Persons person = new Persons("John Doe", 30, true);
        String json = JsonSerializer.toJson(person);
        System.out.println(json);
    }
}
