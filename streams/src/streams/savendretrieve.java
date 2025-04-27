package streams;

import java.io.*;
import java.util.*;

class Employee implements Serializable {
    private static final long serialVersionUID = 1L;  
    int id;
    String name;
    String department;
    double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee ID: " + id + ", Name: " + name +
                ", Department: " + department + ", Salary: " + salary;
    }
}

public class savendretrieve {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Employee> employees = new ArrayList<>();

        System.out.print("Enter number of employees to add: ");
        int n = input.nextInt();
        input.nextLine(); 

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Employee " + (i + 1));
            System.out.print("ID: ");
            int id = input.nextInt();
            input.nextLine(); 

            System.out.print("Name: ");
            String name = input.nextLine();

            System.out.print("Department: ");
            String department = input.nextLine();

            System.out.print("Salary: ");
            double salary = input.nextDouble();
            input.nextLine(); 

            employees.add(new Employee(id, name, department, salary));
        }

        String filename = "employees.ser";

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(employees);
            System.out.println("\nEmployees have been serialized successfully into " + filename);
        } catch (IOException e) {
            System.out.println("Error during serialization: " + e.getMessage());
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            List<Employee> deserializedEmployees = (List<Employee>) ois.readObject();
            System.out.println("\nDeserialized Employees:");
            for (Employee emp : deserializedEmployees) {
                System.out.println(emp);
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error during deserialization: " + e.getMessage());
        }

        input.close();
    }
}


