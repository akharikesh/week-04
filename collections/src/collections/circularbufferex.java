package collections;

import java.util.Scanner;

class CircularBuffer {
    private int[] buffer;
    private int head = 0;   
    private int tail = 0;   
    private int size = 0;
    private int capacity;

    public CircularBuffer(int capacity) {
        this.capacity = capacity;
        buffer = new int[capacity];
    }

    public void enqueue(int value) {
        buffer[tail] = value;
        tail = (tail + 1) % capacity;

        if (size < capacity) {
            size++;
        } else {
            head = (head + 1) % capacity; 
        }
    }

    public void printBuffer() {
        System.out.print("Buffer: [");
        for (int i = 0; i < size; i++) {
            System.out.print(buffer[(head + i) % capacity]);
            if (i < size - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
}
public class circularbufferex {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter buffer size: ");
        int bufferSize = scanner.nextInt();

        CircularBuffer cb = new CircularBuffer(bufferSize);

        while (true) {
            System.out.print("Enter a number to enqueue (-1 to exit): ");
            int value = scanner.nextInt();
            if (value == -1) break;

            cb.enqueue(value);
            cb.printBuffer();
        }

        scanner.close();
        System.out.println("Final buffer state:");
        cb.printBuffer();
    }
}