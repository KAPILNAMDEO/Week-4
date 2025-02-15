package com.capgeminiTrainingPrograms.week4.day5.advanceproblems;

import com.capgeminiTrainingPrograms.week4.day5.regex.advanceproblems.IPaddressValidator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class IPaddressValidatorTest {

    @Test
    void testValidIPAddresses() {
        assertTrue(IPaddressValidator.isValidIPAddress("192.168.1.1"), "192.168.1.1 should be valid");
        assertTrue(IPaddressValidator.isValidIPAddress("127.0.0.1"), "127.0.0.1 should be valid");
        assertTrue(IPaddressValidator.isValidIPAddress("255.255.255.255"), "255.255.255.255 should be valid");
    }

    @Test
    void testInvalidIPAddresses() {
        assertFalse(IPaddressValidator.isValidIPAddress("256.100.50.25"), "256.100.50.25 should be invalid (out of range)");
        assertFalse(IPaddressValidator.isValidIPAddress("123.045.067.089"), "123.045.067.089 should be invalid (leading zeros not allowed)");
        assertFalse(IPaddressValidator.isValidIPAddress("192.168.1"), "192.168.1 should be invalid (not enough octets)");
        assertFalse(IPaddressValidator.isValidIPAddress("192.168.1.256"), "192.168.1.256 should be invalid (out of range)");
        assertFalse(IPaddressValidator.isValidIPAddress("192.168.1.-1"), "192.168.1.-1 should be invalid (negative number)");
        assertFalse(IPaddressValidator.isValidIPAddress("192.168.1.abc"), "192.168.1.abc should be invalid (non-numeric)");
        assertFalse(IPaddressValidator.isValidIPAddress("192.168..1"), "192.168..1 should be invalid (missing octet)");
    }
}
