package com.capgeminiTrainingPrograms.week4.day6Reflectionandannotations.annotations.practiceproblems.intermediatelevel;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void testValidUsername() {
        assertDoesNotThrow(() -> new User("JohnDoe"));
    }

    @Test
    void testInvalidUsername() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> new User("VeryLongUsername"));

        assertTrue(exception.getMessage().contains("exceeds max length"));
    }
}
