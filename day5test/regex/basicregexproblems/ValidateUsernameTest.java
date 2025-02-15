package com.capgeminiTrainingPrograms.week4.day5.basicregexproblems;



import static org.junit.jupiter.api.Assertions.*;

import com.capgeminiTrainingPrograms.week4.day5.regex.basicregexproblems.ValidateUsername;
import org.junit.jupiter.api.Test;

public class ValidateUsernameTest {

    @Test
    void testValidUsernames() {
        assertTrue(ValidateUsername.isValidUsername("user_123")); // Valid case
        assertTrue(ValidateUsername.isValidUsername("A_user")); // Valid case
        assertTrue(ValidateUsername.isValidUsername("User12345")); // Valid case
    }

    @Test
    void testInvalidUsernames() {
        assertFalse(ValidateUsername.isValidUsername("123user")); // Starts with number
        assertFalse(ValidateUsername.isValidUsername("us")); // Too short
        assertFalse(ValidateUsername.isValidUsername("u$ername")); // Invalid character
        assertFalse(ValidateUsername.isValidUsername("usernametoolong123")); // Too long
        assertFalse(ValidateUsername.isValidUsername("_username")); // Starts with underscore
    }
}