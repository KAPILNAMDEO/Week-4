package com.capgeminiTrainingPrograms.week4.day6Reflectionandannotations.annotations.exercise;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class UncheckedWarningDemoTest {
    @Test
    void testAddElements() {
        UncheckedWarningDemo demo = new UncheckedWarningDemo();

        // Capture console output
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        demo.addElements();
        String output = out.toString().trim();

        assertTrue(output.contains("List elements:"));
    }
}
