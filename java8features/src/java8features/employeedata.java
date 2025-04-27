package java8features;

import java.util.*;
import java.util.stream.Collectors;

class Employee {
    private int id;
    private String name;
    private String department;
    private double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getDepartment() { return department; }
    public double getSalary() { return salary; }

    @Override
    public String toString() {
        return id + " - " + name + " (" + department + ", $" + salary + ")";
    }
}

public class employeedata {

    public static void processEmployees(List<Employee> employees) {
        List<Employee> filteredAndSorted = employees.stream()
            .filter(e -> e.getDepartment().equals("Engineering") && e.getSalary() > 80000)
            .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
            .collect(Collectors.toList());

        System.out.println("Filtered & Sorted Employees:");
        filteredAndSorted.forEach(System.out::println);

        Map<String, List<Employee>> groupedByDept = filteredAndSorted.stream()
            .collect(Collectors.groupingBy(Employee::getDepartment));

        Map<String, Double> averageSalaries = groupedByDept.entrySet().stream()
            .collect(Collectors.toMap(
                Map.Entry::getKey,
                entry -> entry.getValue().stream()
                              .mapToDouble(Employee::getSalary)
                              .average()
                              .orElse(0.0)
            ));

        System.out.println("\nAverage Salary per Department:");
        averageSalaries.forEach((dept, avgSalary) -> 
            System.out.println(dept + ": $" + avgSalary));
    }

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee(1, "Alice", "Engineering", 90000),
            new Employee(2, "Bob", "Engineering", 85000),
            new Employee(3, "Charlie", "HR", 75000),
            new Employee(4, "David", "Engineering", 78000),
            new Employee(5, "Eve", "Marketing", 82000)
        );

        processEmployees(employees);
    }
}

