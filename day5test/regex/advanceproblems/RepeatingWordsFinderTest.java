package com.capgeminiTrainingPrograms.week4.day5.advanceproblems;

import static org.junit.jupiter.api.Assertions.*;

import com.capgeminiTrainingPrograms.week4.day5.regex.advanceproblems.RepeatingWordsFinder;
import org.junit.jupiter.api.Test;

import java.util.Set;

class RepeatingWordsFinderTest {

    @Test
    void testFindRepeatingWords() {
        String text = "This is is a repeated repeated word test.";
        Set<String> expected = Set.of("is", "repeated");
        assertEquals(expected, RepeatingWordsFinder.findRepeatingWords(text));
    }

    @Test
    void testNoRepeatingWords() {
        String text = "Every word here is unique.";
        Set<String> expected = Set.of();
        assertEquals(expected, RepeatingWordsFinder.findRepeatingWords(text));
    }
}
