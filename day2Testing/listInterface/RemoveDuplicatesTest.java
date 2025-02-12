package com.capgeminiTrainingPrograms.week4.day2.listInterface;

import static org.junit.jupiter.api.Assertions.*;



import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RemoveDuplicatesTest {

    @Test
    void testRemoveDuplicatesWithDuplicates() {
        List<Integer> numbers = Arrays.asList(3, 1, 2, 2, 3, 4);
        List<Integer> expected = Arrays.asList(3, 1, 2, 4); // Preserves first occurrence order

        List<Integer> result = RemoveDuplicates.removeDuplicates(numbers);

        assertEquals(expected, result, "List should retain first occurrences and remove duplicates");
    }

    @Test
    void testRemoveDuplicatesWithoutDuplicates() {
        List<Integer> numbers = Arrays.asList(5, 6, 7, 8);
        List<Integer> expected = Arrays.asList(5, 6, 7, 8); // No duplicates, remains unchanged

        List<Integer> result = RemoveDuplicates.removeDuplicates(numbers);

        assertEquals(expected, result, "List without duplicates should remain unchanged");
    }
}
