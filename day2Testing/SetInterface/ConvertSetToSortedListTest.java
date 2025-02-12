package com.capgeminiTrainingPrograms.week4.day2.SetInterface;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import org.junit.jupiter.api.Test;

class ConvertSetToSortedListTest {

    @Test
    void testConvertSetToSortedList() {
        Set<Integer> inputSet = new HashSet<>(Arrays.asList(5, 3, 9, 1));
        List<Integer> expected = Arrays.asList(1, 3, 5, 9);

        List<Integer> result = new ArrayList<>(inputSet);
        Collections.sort(result);

        assertEquals(expected, result);
    }

}
