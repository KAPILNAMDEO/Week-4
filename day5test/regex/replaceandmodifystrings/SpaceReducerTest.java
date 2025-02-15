package com.capgeminiTrainingPrograms.week4.day5.replaceandmodifystrings;

import com.capgeminiTrainingPrograms.week4.day5.regex.replaceandmodifystrings.SpaceReducer;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SpaceReducerTest {

    @Test
    void testReplaceMultipleSpaces() {
        String input = "This   is  an   example    with multiple   spaces.";
        String expected = "This is an example with multiple spaces.";
        String result = SpaceReducer.replaceMultipleSpaces(input);

        assertEquals(expected, result);
    }

    @Test
    void testNoExtraSpaces() {
        String input = "This is normal text.";
        String result = SpaceReducer.replaceMultipleSpaces(input);

        assertEquals(input, result);
    }
}
