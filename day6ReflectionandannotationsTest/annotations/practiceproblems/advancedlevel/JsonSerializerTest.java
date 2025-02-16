package com.capgeminiTrainingPrograms.week4.day6Reflectionandannotations.annotations.practiceproblems.advancedlevel;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class JsonSerializerTest {

    @Test
    void testJsonSerialization() {
        Users user = new Users("Alice", 30, false);
        String json = JsonSerializer.toJson(user);

        assertTrue(json.contains("\"user_name\": \"Alice\""));
        assertTrue(json.contains("\"user_age\": \"30\""));
        assertTrue(json.contains("\"is_active\": \"false\""));
    }
}
