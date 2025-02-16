package com.capgeminiTrainingPrograms.week4.day6Reflectionandannotations.annotations.practiceproblems.intermediatelevel;

import org.junit.jupiter.api.Test;
import java.lang.reflect.Method;
import static org.junit.jupiter.api.Assertions.*;

class LogExecutionTimeTest {
    @Test
    void testLogExecutionTimeAnnotation() throws Exception {
        PerformanceTest obj = new PerformanceTest();
        Method fastMethod = PerformanceTest.class.getMethod("fastMethod");
        Method slowMethod = PerformanceTest.class.getMethod("slowMethod");
        Method normalMethod = PerformanceTest.class.getMethod("normalMethod");

        assertTrue(fastMethod.isAnnotationPresent(LogExecutionTime.class));
        assertTrue(slowMethod.isAnnotationPresent(LogExecutionTime.class));
        assertFalse(normalMethod.isAnnotationPresent(LogExecutionTime.class));

        long fastStart = System.nanoTime();
        fastMethod.invoke(obj);
        long fastEnd = System.nanoTime();

        long slowStart = System.nanoTime();
        slowMethod.invoke(obj);
        long slowEnd = System.nanoTime();

        assertTrue((slowEnd - slowStart) > (fastEnd - fastStart),
                "Slow method should take longer than fast method.");
    }
}
