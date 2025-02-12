package com.capgeminiTrainingPrograms.week4.day2.listInterface;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.LinkedList;


public class NthFromEndTest {

    @Test
    void testFindNthFromEndValidCase() {
        LinkedList<String> list = new LinkedList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");

        assertEquals("D", NthFromEnd.findNthFromEnd(list, 2), "2nd element from end should be 'D'");
    }

    @Test
    void testFindNthFromEndFirstElement() {
        LinkedList<String> list = new LinkedList<>();
        list.add("X");
        list.add("Y");
        list.add("Z");

        assertEquals("X", NthFromEnd.findNthFromEnd(list, 3), "3rd element from end should be 'X'");
    }

}
