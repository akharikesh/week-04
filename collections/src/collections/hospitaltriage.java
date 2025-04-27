package collections;

import java.util.*;

class Patient implements Comparable<Patient> {
    String name;
    int severity;

    public Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }

    public int compareTo(Patient other) {
        return Integer.compare(other.severity, this.severity);
    }

    public String toString() {
        return name + " (Severity: " + severity + ")";
    }
}
public class hospitaltriage {
	public static void main(String[] args) {
        PriorityQueue<Patient> triageQueue = new PriorityQueue<>();

        triageQueue.add(new Patient("John", 3));
        triageQueue.add(new Patient("Alice", 5));
        triageQueue.add(new Patient("Bob", 2));

        System.out.println("Treatment Order:");
        while (!triageQueue.isEmpty()) {
            Patient patient = triageQueue.poll();
            System.out.println(patient);
        }
    }
}
