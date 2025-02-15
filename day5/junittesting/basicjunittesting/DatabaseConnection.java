package com.capgeminiTrainingPrograms.week4.day5.junittesting.basicjunittesting;



public class DatabaseConnection {
    private boolean connected;

    // Method to establish a connection
    public void connect() {
        connected = true;
        System.out.println("Database connected.");
    }

    // Method to close the connection
    public void disconnect() {
        connected = false;
        System.out.println("Database disconnected.");
    }

    // Check connection status
    public boolean isConnected() {
        return connected;
    }
}

