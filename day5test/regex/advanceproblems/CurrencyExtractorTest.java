package com.capgeminiTrainingPrograms.week4.day5.advanceproblems;

import com.capgeminiTrainingPrograms.week4.day5.regex.advanceproblems.CurrencyExtractor;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

class CurrencyExtractorTest {

    @Test
    void testExtractCurrencyValues() {
        String text = "The price is $45.99, and the discount is 10.50.";
        List<String> expected = List.of("$45.99", "10.50");
        assertEquals(expected, CurrencyExtractor.extractCurrencyValues(text));
    }

    @Test
    void testNoCurrencyValues() {
        String text = "This text contains no prices or amounts.";
        List<String> expected = List.of();
        assertEquals(expected, CurrencyExtractor.extractCurrencyValues(text));
    }
}
