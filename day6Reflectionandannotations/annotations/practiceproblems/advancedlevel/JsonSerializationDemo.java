package com.capgeminiTrainingPrograms.week4.day6Reflectionandannotations.annotations.practiceproblems.advancedlevel;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

// Define the annotation
@Retention(RetentionPolicy.RUNTIME) // Retained at runtime for Reflection
@Target(ElementType.FIELD) // Can only be applied to fields
@interface JsonField {
    String name(); // Specifies the JSON key name
}

class Users {

    @JsonField(name = "user_name")
    private String username;

    @JsonField(name = "user_age")
    private int age;

    @JsonField(name = "is_active")
    private boolean active;

    public Users(String username, int age, boolean active) {
        this.username = username;
        this.age = age;
        this.active = active;
    }
}


class JsonSerializer {

    public static String toJson(Object obj) {
        Class<?> clazz = obj.getClass();
        Map<String, String> jsonMap = new HashMap<>();

        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(JsonField.class)) {
                JsonField annotation = field.getAnnotation(JsonField.class);
                field.setAccessible(true);
                try {
                    Object value = field.get(obj);
                    jsonMap.put(annotation.name(), value.toString());
                } catch (IllegalAccessException e) {
                    throw new RuntimeException("Failed to access field: " + field.getName(), e);
                }
            }
        }

        // Convert the map to a JSON-like string
        StringBuilder jsonBuilder = new StringBuilder("{");
        jsonMap.forEach((key, value) -> jsonBuilder.append("\"").append(key).append("\": \"").append(value).append("\", "));
        if (jsonBuilder.length() > 1) {
            jsonBuilder.setLength(jsonBuilder.length() - 2); // Remove last comma
        }
        jsonBuilder.append("}");

        return jsonBuilder.toString();
    }
}

public class JsonSerializationDemo {
    public static void main(String[] args) {
        Users user = new Users("JohnDoe", 25, true);
        String json = JsonSerializer.toJson(user);
        System.out.println(json);
    }
}
