package com.capgeminiTrainingPrograms.week4.day2.SetInterface;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import java.util.Set;
import java.util.HashSet;

class SetEqualityCheckerTest {

    @Test
    void testAreSetsEqual() {
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        Set<Integer> set2 = new HashSet<>();
        set2.add(3);
        set2.add(2);
        set2.add(1);

        assertTrue(set1.equals(set2), "The sets should be equal");
    }
}
