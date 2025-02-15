package com.capgeminiTrainingPrograms.week4.day5.advanceproblems;

import com.capgeminiTrainingPrograms.week4.day5.regex.advanceproblems.ProgrammingLanguageExtractor;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

class ProgrammingLanguageExtractorTest {

    @Test
    void testExtractLanguages() {
        String text = "I love Java, Python, and JavaScript, but I haven't tried Go yet.";
        List<String> expected = List.of("Java", "Python", "JavaScript", "Go");
        assertEquals(expected, ProgrammingLanguageExtractor.extractLanguages(text));
    }

    @Test
    void testNoLanguagesFound() {
        String text = "I enjoy playing chess and reading books.";
        List<String> expected = List.of();
        assertEquals(expected, ProgrammingLanguageExtractor.extractLanguages(text));
    }
}
