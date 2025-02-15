package com.capgeminiTrainingPrograms.week4.day5.replaceandmodifystrings;

import com.capgeminiTrainingPrograms.week4.day5.regex.replaceandmodifystrings.CensorBadWords;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CensorBadWordsTest {

    @Test
    void testCensorBadWords() {
        String input = "This is a damn bad example with some stupid words.";
        String[] badWords = {"damn", "stupid"};
        String expected = "This is a **** bad example with some **** words.";

        String result = CensorBadWords.censorBadWords(input, badWords);

        assertEquals(expected, result, "Bad words should be replaced with ****");
    }

    @Test
    void testNoBadWords() {
        String input = "This is a clean sentence.";
        String[] badWords = {"damn", "stupid"};

        String result = CensorBadWords.censorBadWords(input, badWords);

        assertEquals(input, result, "If no bad words are found, text should remain unchanged");
    }
}
