package com.capgeminiTrainingPrograms.week4.day2.QueueInterface;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.util.LinkedList;
import java.util.Queue;
import static org.junit.jupiter.api.Assertions.*;

public class ReverseQueueTest {

    @Test
    public void testReverseQueue() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(10);
        queue.offer(20);
        queue.offer(30);

        Queue<Integer> expectedQueue = new LinkedList<>();
        expectedQueue.offer(30);
        expectedQueue.offer(20);
        expectedQueue.offer(10);

        ReverseQueue.reverseQueue(queue);

        assertEquals(expectedQueue, queue, "Queue should be reversed.");
    }

}
