package com.capgeminiTrainingPrograms.week4.day5.basicregexproblems;


import com.capgeminiTrainingPrograms.week4.day5.regex.basicregexproblems.LicensePlateValidator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LicensePlateValidatorTest {

    @Test
    void testValidLicenseNumbers() {
        assertTrue(LicensePlateValidator.isValidLicenseNumber("AB1234"), "AB1234 should be valid");
        assertTrue(LicensePlateValidator.isValidLicenseNumber("XY6789"), "XY6789 should be valid");
        assertTrue(LicensePlateValidator.isValidLicenseNumber("ZZ0000"), "ZZ0000 should be valid");
    }

    @Test
    void testInvalidLicenseNumbers() {
        assertFalse(LicensePlateValidator.isValidLicenseNumber("A12345"), "A12345 should be invalid (only one letter)");
        assertFalse(LicensePlateValidator.isValidLicenseNumber("ABC123"), "ABC123 should be invalid (three letters instead of two)");
        assertFalse(LicensePlateValidator.isValidLicenseNumber("Z91234"), "Z91234 should be invalid (only one letter)");
        assertFalse(LicensePlateValidator.isValidLicenseNumber("12AB34"), "12AB34 should be invalid (does not start with two letters)");
        assertFalse(LicensePlateValidator.isValidLicenseNumber("AB12C4"), "AB12C4 should be invalid (contains non-digit after letters)");
    }
}
