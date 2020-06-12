package generics.map;

import generics.max.Employee;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

/**
 * Created by Ken Kousen on 11/9/16.
 */
public class MapEmployees {
    public static List<Employee> createEmployees() {
        return Arrays.asList(
                new Employee(2, "Peter Gibbons"),
                new Employee(6, "Samir Nagheenanajar"),
                new Employee(1, "Michael Bolton"),
                new Employee(3, "Milton Waddams")
        );
    }

    public static void main(String[] args) {
        List<Employee> employees = createEmployees();

        employees.stream()
                .sorted(comparing(Employee::getId))
                .forEach(System.out::println);

        List<Integer> ids = employees.stream()
                .map(Employee::getId)
                .collect(toList());

        System.out.println("Employ ID:"+ ids);

        // Add employees to a map using id as key
        Map<Integer, Employee> employeeMap = employees.stream()
                .collect(toMap(Employee::getId, Function.identity()));
        employeeMap.forEach((id, emp) -> System.out.println(id + ": " + emp));


        // Sort employees by id and print them
        System.out.println("Sorted by key:");
        employeeMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> {
                    System.out.println(entry.getKey() + ": " + entry.getValue());
                });


        // Sort employees by name and print them
        System.out.println("Sorted by name:");
        employeeMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(comparing(Employee::getName)))
                // .sorted(Map.Entry.comparingByValue())
                .forEach(entry -> {
                    System.out.println(entry.getKey() + ": " + entry.getValue());
                });
    }
}
