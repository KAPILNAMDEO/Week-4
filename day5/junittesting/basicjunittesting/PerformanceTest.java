package com.capgeminiTrainingPrograms.week4.day5.junittesting.basicjunittesting;

public class PerformanceTest {
    public String longRunningTask() {
        try {
            Thread.sleep(1500); // Simulates a long-running operation (3 seconds)
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Restore the interrupted status
        }
        return "Completed";
    }
}
