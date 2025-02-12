package com.capgeminiTrainingPrograms.week4.day2.SetInterface;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import java.util.Set;
import java.util.HashSet;



class SymmetricDifferenceTest {

    @Test
    void testSymmetricDifference() {
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        Set<Integer> set2 = new HashSet<>();
        set2.add(3);
        set2.add(4);
        set2.add(5);

        Set<Integer> expected = new HashSet<>();
        expected.add(1);
        expected.add(2);
        expected.add(4);
        expected.add(5);

        assertEquals(expected, SymmetricDifference.getSymmetricDifference(set1, set2));
    }


}
