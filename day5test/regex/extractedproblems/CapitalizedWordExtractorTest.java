package com.capgeminiTrainingPrograms.week4.day5.extractedproblems;

import static org.junit.jupiter.api.Assertions.*;

import com.capgeminiTrainingPrograms.week4.day5.regex.extractedproblems.CapitalizedWordExtractor;
import org.junit.jupiter.api.Test;
import java.util.List;

class CapitalizedWordExtractorTest {

    @Test
    void testExtractCapitalizedWords() {
        String text = " Eiffel Tower is in Paris and the Statue of Liberty is in New York.";
        List<String> words = CapitalizedWordExtractor.extractCapitalizedWords(text);

        assertEquals(7, words.size(), "Should extract exactly 7 capitalized words");
        assertTrue(words.containsAll(List.of("Eiffel", "Tower", "Paris", "Statue", "Liberty", "New", "York")));
    }

    @Test
    void testNoCapitalizedWords() {
        String text = "this sentence contains no capitalized words.";
        List<String> words = CapitalizedWordExtractor.extractCapitalizedWords(text);

        assertTrue(words.isEmpty(), "Should return an empty list when no capitalized words are found");
    }
}
