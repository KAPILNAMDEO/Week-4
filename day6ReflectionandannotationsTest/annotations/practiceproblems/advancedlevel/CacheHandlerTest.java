package com.capgeminiTrainingPrograms.week4.day6Reflectionandannotations.annotations.practiceproblems.advancedlevel;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CacheHandlerTest {

    @Test
    void testCacheWorks() {
        ExpensiveComputation computation = new ExpensiveComputation();

        int firstResult = (int) CacheHandler.invokeWithCache(computation, "computeFactorial", 4);
        int secondResult = (int) CacheHandler.invokeWithCache(computation, "computeFactorial", 4);

        assertEquals(firstResult, secondResult); // Should be same, fetched from cache
    }

    @Test
    void testDifferentInputsAreComputedSeparately() {
        ExpensiveComputation computation = new ExpensiveComputation();

        int result1 = (int) CacheHandler.invokeWithCache(computation, "computeFactorial", 3);
        int result2 = (int) CacheHandler.invokeWithCache(computation, "computeFactorial", 5);

        assertNotEquals(result1, result2); // Different inputs should yield different results
    }
}
