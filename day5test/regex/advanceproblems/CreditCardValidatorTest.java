package com.capgeminiTrainingPrograms.week4.day5.advanceproblems;

import com.capgeminiTrainingPrograms.week4.day5.regex.advanceproblems.CreditCardValidator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CreditCardValidatorTest {

    @Test
    void testValidCreditCards() {
        assertTrue(CreditCardValidator.isValidCreditCard("4111111111111111"), "4111111111111111 should be a valid Visa card");
        assertTrue(CreditCardValidator.isValidCreditCard("5111111111111111"), "5111111111111111 should be a valid MasterCard");
    }

    @Test
    void testInvalidCreditCards() {
        assertFalse(CreditCardValidator.isValidCreditCard("6111111111111111"), "6111111111111111 should be invalid (does not start with 4 or 5)");
        assertFalse(CreditCardValidator.isValidCreditCard("42222222222222"), "42222222222222 should be invalid (not 16 digits)");
        assertFalse(CreditCardValidator.isValidCreditCard("511111111111111"), "511111111111111 should be invalid (only 15 digits)");
        assertFalse(CreditCardValidator.isValidCreditCard("abc1111111111111"), "abc1111111111111 should be invalid (contains letters)");
    }
}
