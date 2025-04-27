package streams;

import java.io.*;

public class studentdatastream {
    public static void main(String[] args) {
        String fileName = "students.dat";

        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName))) {
            dos.writeInt(101);
            dos.writeUTF("Alice");
            dos.writeDouble(8.5);

            dos.writeInt(102);
            dos.writeUTF("Bob");
            dos.writeDouble(9.1);

            dos.writeInt(103);
            dos.writeUTF("Charlie");
            dos.writeDouble(7.8);

            System.out.println("Student data written to " + fileName);

        } catch (IOException e) {
            System.err.println("Write Error: " + e.getMessage());
        }

        try (DataInputStream dis = new DataInputStream(new FileInputStream(fileName))) {
            System.out.println("\nRetrieved Student Records:");
            while (dis.available() > 0) {
                int roll = dis.readInt();
                String name = dis.readUTF();
                double gpa = dis.readDouble();
                System.out.println("Roll: " + roll + ", Name: " + name + ", GPA: " + gpa);
            }

        } catch (IOException e) {
            System.err.println("Read Error: " + e.getMessage());
        }
    }
}
