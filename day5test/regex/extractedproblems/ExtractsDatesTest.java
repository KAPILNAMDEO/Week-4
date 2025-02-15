package com.capgeminiTrainingPrograms.week4.day5.extractedproblems;

import com.capgeminiTrainingPrograms.week4.day5.regex.extractedproblems.ExtractsDates;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class ExtractsDatesTest {

    @Test
    void testExtractValidDates() {
        String text = "The events are scheduled for 12/05/2023, 15/08/2024, and 29/02/2020.";
        List<String> dates = ExtractsDates.extractdates(text);

        assertEquals(3, dates.size(), "Should extract exactly 3 dates");
        assertTrue(dates.containsAll(List.of("12/05/2023", "15/08/2024", "29/02/2020")));
    }

    @Test
    void testNoDatesFound() {
        String text = "There are no valid dates in this text.";
        List<String> dates = ExtractsDates.extractdates(text);

        assertTrue(dates.isEmpty(), "Should return an empty list when no dates are found");
    }
}
