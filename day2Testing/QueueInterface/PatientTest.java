package com.capgeminiTrainingPrograms.week4.day2.QueueInterface;

import static org.junit.jupiter.api.Assertions.*;



import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

class PatientTest {
    @Test
    void testPatientOrder() {
        PriorityQueue<Patient> queue = new PriorityQueue<>();
        queue.add(new Patient("John", 3));
        queue.add(new Patient("Alice", 5));
        queue.add(new Patient("Bob", 2));

        assertEquals("Alice", queue.poll().name);
        assertEquals("John", queue.poll().name);
        assertEquals("Bob", queue.poll().name);
    }


}