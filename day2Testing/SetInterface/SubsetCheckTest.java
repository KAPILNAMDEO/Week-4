package com.capgeminiTrainingPrograms.week4.day2.SetInterface;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

public class SubsetCheckTest {

    @Test
    public void testIsSubset() {
        Set<Integer> set1 = new HashSet<>();
        set1.add(2);
        set1.add(3);

        Set<Integer> set2 = new HashSet<>();
        set2.add(1);
        set2.add(2);
        set2.add(3);
        set2.add(4);

        assertTrue(SubsetCheck.isSubset(set1, set2));
    }


}

