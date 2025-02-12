package com.capgeminiTrainingPrograms.week4.day2.listInterface;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class ReverseListTest {

    @Test
    void testReverseArrayList() {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            list.add(i);
        }

        List<Integer> expected = new ArrayList<>();
        for (int i = 5; i >= 1; i--) {
            expected.add(i);
        }

        ReverseList.reverseList(list);
        assertEquals(expected, list, "ArrayList should be reversed correctly");
    }

    @Test
    void testReverseLinkedList() {
        List<Integer> list = new LinkedList<>();
        for (int i = 1; i <= 5; i++) {
            list.add(i);
        }

        List<Integer> expected = new LinkedList<>();
        for (int i = 5; i >= 1; i--) {
            expected.add(i);
        }

        ReverseList.reverseList(list);
        assertEquals(expected, list, "LinkedList should be reversed correctly");
    }


}