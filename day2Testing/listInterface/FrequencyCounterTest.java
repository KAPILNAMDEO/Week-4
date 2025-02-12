package com.capgeminiTrainingPrograms.week4.day2.listInterface;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FrequencyCounterTest {

    @Test
    void testCountFrequencyBasic() {
        List<String> words = Arrays.asList("apple", "banana", "apple", "orange");
        Map<String, Integer> expected = new HashMap<>();
        expected.put("apple", 2);
        expected.put("banana", 1);
        expected.put("orange", 1);

        assertEquals(expected, FrequencyCounter.countFrequency(words), "Frequency count should match expected values");
    }

    @Test
    void testCountFrequencyEmptyList() {
        List<String> words = new ArrayList<>();
        Map<String, Integer> expected = new HashMap<>();

        assertEquals(expected, FrequencyCounter.countFrequency(words), "Empty list should return an empty map");
    }

    @Test
    void testCountFrequencySingleElement() {
        List<String> words = Collections.singletonList("grape");
        Map<String, Integer> expected = new HashMap<>();
        expected.put("grape", 1);

        assertEquals(expected, FrequencyCounter.countFrequency(words), "Single element list should return a map with one entry");
    }


}
