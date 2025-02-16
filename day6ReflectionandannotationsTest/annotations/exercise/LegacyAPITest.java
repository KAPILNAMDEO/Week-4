package com.capgeminiTrainingPrograms.week4.day6Reflectionandannotations.annotations.exercise;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LegacyAPITest {
    @Test
    void testOldFeature() {
        LegacyAPI api = new LegacyAPI();

        // Capture console output
        java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(out));

        api.oldFeature();
        String output = out.toString().trim();

        assertEquals("Warning: This is an old feature and should not be used.", output);
    }

    @Test
    void testNewFeature() {
        LegacyAPI api = new LegacyAPI();

        java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(out));

        api.newFeature();
        String output = out.toString().trim();

        assertEquals("This is the new recommended feature.", output);
    }
}
