package com.capgeminiTrainingPrograms.week4.day3;


import java.io.*;

class WriterThread extends Thread {
    private PipedOutputStream pipedOutputStream;

    public WriterThread(PipedOutputStream pipedOutputStream) {
        this.pipedOutputStream = pipedOutputStream;
    }

    @Override
    public void run() {
        try {
            String[] data = {"Hello", "from", "WriterThread!"};
            for (String str : data) {
                pipedOutputStream.write(str.getBytes());
                pipedOutputStream.write(' ');  // Add space between words
                System.out.println("WriterThread: Wrote: " + str);
                Thread.sleep(500);  // Simulate some delay
            }
            pipedOutputStream.close();  // Close the stream after writing
        } catch (IOException | InterruptedException e) {
            System.err.println("WriterThread encountered an error: " + e.getMessage());
        }
    }
}

class ReaderThread extends Thread {
    private PipedInputStream pipedInputStream;

    public ReaderThread(PipedInputStream pipedInputStream) {
        this.pipedInputStream = pipedInputStream;
    }

    @Override
    public void run() {
        try {
            int byteRead;
            StringBuilder receivedData = new StringBuilder();
            while ((byteRead = pipedInputStream.read()) != -1) {
                receivedData.append((char) byteRead);
            }
            System.out.println("ReaderThread: Received: " + receivedData.toString().trim());
            pipedInputStream.close();  // Close the stream after reading
        } catch (IOException e) {
            System.err.println("ReaderThread encountered an error: " + e.getMessage());
        }
    }
}

public class PipedStream {
    public static void main(String[] args) {
        PipedOutputStream pipedOutputStream = new PipedOutputStream();
        PipedInputStream pipedInputStream = new PipedInputStream();

        try {
            // Connect the PipedOutputStream to the PipedInputStream
            pipedOutputStream.connect(pipedInputStream);

            // Create and start Writer and Reader threads
            Thread writerThread = new WriterThread(pipedOutputStream);
            Thread readerThread = new ReaderThread(pipedInputStream);

            writerThread.start();
            readerThread.start();

            // Wait for threads to finish
            writerThread.join();
            readerThread.join();
        } catch (IOException | InterruptedException e) {
            System.err.println("Error in PipedStreamExample: " + e.getMessage());
        }
    }
}
