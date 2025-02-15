package com.capgeminiTrainingPrograms.week4.day5.junittesting.basicjunittesting;

import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;
import static org.junit.jupiter.api.Assertions.*;

class NumberUtilsTest {

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6}) // Even numbers
    void testIsEven_ValidEvenNumbers(int number) {
        assertTrue(NumberUtils.isEven(number), number + " should be even.");
    }

    @ParameterizedTest
    @ValueSource(ints = {7, 9}) // Odd numbers
    void testIsEven_InvalidOddNumbers(int number) {
        assertFalse(NumberUtils.isEven(number), number + " should be odd.");
    }
}
