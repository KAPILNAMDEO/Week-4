package com.capgeminiTrainingPrograms.week4.day5.advanceproblems;

import com.capgeminiTrainingPrograms.week4.day5.regex.advanceproblems.SSNValidator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SSNValidatorTest {

    @Test
    void testValidSSN() {
        assertTrue(SSNValidator.isValidSSN("123-45-6789"));
    }

    @Test
    void testInvalidSSN_NoHyphens() {
        assertFalse(SSNValidator.isValidSSN("123456789"));
    }
}
