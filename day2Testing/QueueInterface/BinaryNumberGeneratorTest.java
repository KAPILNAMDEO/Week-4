package com.capgeminiTrainingPrograms.week4.day2.QueueInterface;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

import java.util.*;

class BinaryNumberGeneratorTest {

    @Test
    void testGenerateBinaryNumbers() {
        List<String> expected1 = Arrays.asList("1", "10", "11", "100", "101");
        assertEquals(expected1, BinaryNumberGenerator.generateBinaryNumbers(5));

        List<String> expected2 = Arrays.asList("1", "10", "11");
        assertEquals(expected2, BinaryNumberGenerator.generateBinaryNumbers(3));

        List<String> expected3 = Arrays.asList("1", "10", "11", "100", "101", "110", "111", "1000", "1001", "1010");
        assertEquals(expected3, BinaryNumberGenerator.generateBinaryNumbers(10));
    }


}
