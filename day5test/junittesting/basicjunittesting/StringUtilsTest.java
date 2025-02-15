package com.capgeminiTrainingPrograms.week4.day5.junittesting.basicjunittesting;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {

        @Test
        void testReverse() {
            assertEquals("cba", StringUtils.reverse("abc"));
            assertEquals("madam", StringUtils.reverse("madam")); // Palindrome case
            assertEquals("", StringUtils.reverse("")); // Edge case: empty string
        }

        @Test
        void testIsPalindrome() {
            assertTrue(StringUtils.isPalindrome("madam"));
            assertTrue(StringUtils.isPalindrome("RaceCar")); // Case-insensitive
            assertFalse(StringUtils.isPalindrome("hello"));
        }

        @Test
        void testToUpperCase() {
            assertEquals("HELLO", StringUtils.toUpperCase("hello"));
            assertEquals("JAVA", StringUtils.toUpperCase("java"));
            assertEquals("123ABC", StringUtils.toUpperCase("123abc")); // Handles non-letters
        }
}


