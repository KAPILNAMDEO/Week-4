package com.capgeminiTrainingPrograms.week4.day5.extractedproblems;

import static org.junit.jupiter.api.Assertions.*;

import com.capgeminiTrainingPrograms.week4.day5.regex.extractedproblems.ExtractsLinkFromWebPage;
import org.junit.jupiter.api.Test;

import java.util.List;

class ExtractsLinkFromWebPageTest {

    @Test
    void testValidLinks() {
        String text = "Visit https://www.google.com and http://example.org for more info.";
        List<String> expected = List.of("https://www.google.com", "http://example.org");
        assertEquals(expected, ExtractsLinkFromWebPage.extractLinkes(text));
    }

    @Test
    void testNoLinks() {
        String text = "There are no links in this text.";
        List<String> expected = List.of();
        assertEquals(expected, ExtractsLinkFromWebPage.extractLinkes(text));
    }
}
