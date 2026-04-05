package streamAPIPractice.intermediate;

import streamAPIPractice.Order;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// Problem:
// Count number of orders per status
//
// Expected Concepts:
// -> groupingBy()
// -> counting()
public class Ques2 {
    public static void main(String[] args) {
        List<Order> orders = List.of(
                new Order(1, "Aman", 1200, "DELIVERED", LocalDate.now().minusDays(2), List.of("Laptop", "Mouse")),
                new Order(2, "Rahul", 800, "PLACED", LocalDate.now().minusDays(1), List.of("Keyboard")),
                new Order(3, "Aman", 1500, "SHIPPED", LocalDate.now().minusDays(3), List.of("Monitor")),
                new Order(4, "Sneha", 2000, "DELIVERED", LocalDate.now().minusDays(5), List.of("Phone", "Charger")),
                new Order(5, "Rahul", 500, "CANCELLED", LocalDate.now().minusDays(4), List.of("Cable"))
        );

        Map<String, Long> numberOfOrdersPerStatus = orders.stream()
                .collect(Collectors.groupingBy(
                        Order::getStatus,
                        Collectors.counting()
                        ));

        numberOfOrdersPerStatus.forEach((status, count) -> System.out.println(status + " -> " + count));

        System.out.println();

        // Sort by count in descending order
        numberOfOrdersPerStatus.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(entry ->
                        System.out.println(entry.getKey() + " -> " + entry.getValue()));

        System.out.println();

        // Calculate Percentage Distribution
        long total = orders.size();

        Map<String, Double> percentage = orders.stream()
                .collect(Collectors.groupingBy(
                        Order::getStatus,
                        Collectors.collectingAndThen(
                                Collectors.counting(),
                                count -> (count * 100.0) / total
                        )
                ));

        percentage.forEach((status, percent) -> System.out.println(status + " -> " + percent + "%"));
    }
}
