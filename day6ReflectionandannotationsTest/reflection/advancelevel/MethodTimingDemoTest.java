package com.capgeminiTrainingPrograms.week4.day6Reflectionandannotations.reflection.advancelevel;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

class MethodTimerTest {
    @Test
    void testMethodExecutionTiming() {
        SampleMethods sample = new SampleMethods();

        // Capture console output to verify method execution
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        MethodTimer.measureExecutionTime(sample);

        String output = outputStream.toString();
        assertTrue(output.contains("Method: fastMethod executed in"));
        assertTrue(output.contains("Method: slowMethod executed in"));
    }
}
