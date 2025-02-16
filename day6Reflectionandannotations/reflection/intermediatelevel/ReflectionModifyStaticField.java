package com.capgeminiTrainingPrograms.week4.day6Reflectionandannotations.reflection.intermediatelevel;

import java.lang.reflect.Field;

class Configuration {
    private static String API_KEY = "DEFAULT_KEY";

    public static String getApiKey() {
        return API_KEY;
    }
}

public class ReflectionModifyStaticField {
    public static void main(String[] args) {
        try {
            // Get the private static field
            Field apiKeyField = Configuration.class.getDeclaredField("API_KEY");

            // Make the field accessible
            apiKeyField.setAccessible(true);

            // Modify the static field value
            apiKeyField.set(null, "NEW_API_KEY");

            // Print the modified value
            System.out.println("Modified API_KEY: " + Configuration.getApiKey());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
