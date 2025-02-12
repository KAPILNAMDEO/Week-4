package com.capgeminiTrainingPrograms.week4.day2.listInterface;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ListRotatorTest {

    @Test
    void testRotateByTwoPositions() {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50));
        List<Integer> expected = Arrays.asList(30, 40, 50, 10, 20);

        ListRotator.rotateList(numbers, 2);

        assertEquals(expected, numbers, "List should be rotated by 2 positions");
    }

    @Test
    void testRotateByZeroPositions() {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50));
        List<Integer> expected = Arrays.asList(10, 20, 30, 40, 50);

        ListRotator.rotateList(numbers, 0);

        assertEquals(expected, numbers, "Rotating by 0 should return the same list");
    }
}
