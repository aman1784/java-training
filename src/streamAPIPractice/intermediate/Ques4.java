package streamAPIPractice.intermediate;

import streamAPIPractice.Order;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

// Problem:
// Group orders by status and get list of customer names per status
//
// Expected Concepts:
// -> groupingBy()
// -> mapping()
public class Ques4 {
    public static void main(String[] args) {
        List<Order> orders = List.of(
                new Order(1, "Aman", 1200, "DELIVERED", LocalDate.now().minusDays(2), List.of("Laptop", "Mouse")),
                new Order(2, "Rahul", 800, "PLACED", LocalDate.now().minusDays(1), List.of("Keyboard")),
                new Order(3, "Aman", 1500, "SHIPPED", LocalDate.now().minusDays(3), List.of("Monitor")),
                new Order(4, "Sneha", 2000, "DELIVERED", LocalDate.now().minusDays(5), List.of("Phone", "Charger")),
                new Order(5, "Rahul", 500, "CANCELLED", LocalDate.now().minusDays(4), List.of("Cable")),
                new Order(5, "Rahul", 500, "CANCELLED", LocalDate.now().minusDays(4), List.of("Cable"))
        );

        Map<String, List<String>> result1 = orders.stream()
                .collect(Collectors.groupingBy(
                        Order::getStatus,
                        Collectors.mapping(
                                Order::getCustomerName,
                                Collectors.toList()
                        )
                ));

        result1.forEach((status, customers) -> System.out.println(status + " -> " + customers));

        System.out.println();

        // Using Set to remove duplicates
        Map<String, Set<String>> result2 = orders.stream()
                .collect(Collectors.groupingBy(
                        Order::getStatus,
                        Collectors.mapping(
                                Order::getCustomerName,
                                Collectors.toSet()
                        )
                        ));

        result2.forEach((status, customers) -> System.out.println(status + " -> " + customers));

        System.out.println();

        Map<String, List<String>> result3 = orders.stream()
                .collect(Collectors.groupingBy(
                        Order::getStatus,
                        Collectors.mapping(
                                Order::getCustomerName,
                                Collectors.collectingAndThen(
                                        Collectors.toSet(),
                                        set -> set.stream().sorted().toList()
                                )
                        )
                ));

        result3.forEach((status, customers) -> System.out.println(status + " -> " + customers));
    }
}
