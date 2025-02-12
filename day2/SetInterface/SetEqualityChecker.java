package com.capgeminiTrainingPrograms.week4.day2.SetInterface;

import java.util.HashSet;
import java.util.Set;

public class SetEqualityChecker {
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        Set<Integer> set2 = new HashSet<>();
        set2.add(3);
        set2.add(2);
        set2.add(1);

        System.out.println("Are the sets equal? " + areSetsEqual(set1, set2));
    }

    public static boolean areSetsEqual(Set<Integer> set1, Set<Integer> set2) {
        return set1.equals(set2);
    }
}

