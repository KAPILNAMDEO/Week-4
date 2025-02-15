package com.capgeminiTrainingPrograms.week4.day5.extractedproblems;

import static org.junit.jupiter.api.Assertions.*;

import com.capgeminiTrainingPrograms.week4.day5.regex.extractedproblems.EmailExtractor;
import org.junit.jupiter.api.Test;
import java.util.List;

class EmailExtractorTest {

    @Test
    void testExtractEmailsWithValidEmails() {
        String text = "Contact us at support@example.com and info@company.org for more details.";
        List<String> emails = EmailExtractor.extractEmails(text);

        assertEquals(2, emails.size(), "Should extract exactly 2 emails");
        assertTrue(emails.contains("support@example.com"), "Should contain support@example.com");
        assertTrue(emails.contains("info@company.org"), "Should contain info@company.org");
    }

    @Test
    void testExtractEmailsWithNoEmails() {
        String text = "This is just some text without any email addresses.";
        List<String> emails = EmailExtractor.extractEmails(text);

        assertTrue(emails.isEmpty(), "Should return an empty list when no emails are found");
    }
}
