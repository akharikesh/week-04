package streams;

import java.io.*;

class WriterThread extends Thread {
    private PipedOutputStream pipedOutputStream;

    public WriterThread(PipedOutputStream pipedOutputStream) {
        this.pipedOutputStream = pipedOutputStream;
    }

    public void run() {
        try {
            for (int i = 1; i <= 5; i++) {
                String data = "Message " + i;
                pipedOutputStream.write(data.getBytes());
                System.out.println("Written: " + data);
                Thread.sleep(1000); 
            }
            pipedOutputStream.close(); 
        } catch (IOException | InterruptedException e) {
            System.out.println("WriterThread Exception: " + e.getMessage());
        }
    }
}

class ReaderThread extends Thread {
    private PipedInputStream pipedInputStream;

    public ReaderThread(PipedInputStream pipedInputStream) {
        this.pipedInputStream = pipedInputStream;
    }

    public void run() {
        try {
            int data;
            StringBuilder receivedData = new StringBuilder();
            while ((data = pipedInputStream.read()) != -1) {
                receivedData.append((char) data);
            }
            System.out.println("Received: " + receivedData.toString());
        } catch (IOException e) {
            System.out.println("ReaderThread Exception: " + e.getMessage());
        }
    }
}

public class pipedstreams {
    public static void main(String[] args) {
        try {
            PipedOutputStream pipedOutputStream = new PipedOutputStream();
            PipedInputStream pipedInputStream = new PipedInputStream(pipedOutputStream);

            Thread writerThread = new WriterThread(pipedOutputStream);
            Thread readerThread = new ReaderThread(pipedInputStream);

            writerThread.start();
            readerThread.start();

            writerThread.join();
            readerThread.join();
        } catch (IOException | InterruptedException e) {
            System.out.println("Main Exception: " + e.getMessage());
        }
    }
}

