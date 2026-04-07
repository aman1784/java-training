package streamAPIPractice.intermediate;

import streamAPIPractice.Order;

import java.time.LocalDate;
import java.util.List;

// Problem:
// Count total number of items across all orders
//
// Expected Concepts:
// -> flatMap()
// -> count()
public class Ques11 {
    public static void main(String[] args) {
        List<Order> orders = List.of(
                new Order(1, "Aman", 1200, "DELIVERED", LocalDate.now().minusDays(2), List.of("Laptop", "Mouse")),
                new Order(2, "Rahul", 800, "PLACED", LocalDate.now().minusDays(1), List.of("Keyboard")),
                new Order(3, "Aman", 1500, "SHIPPED", LocalDate.now().minusDays(3), List.of("Monitor")),
                new Order(4, "Sneha", 2000, "DELIVERED", LocalDate.now().minusDays(5), List.of("Phone", "Charger")),
                new Order(5, "Rahul", 500, "CANCELLED", LocalDate.now().minusDays(4), List.of("Cable", "Charger"))
        );

        // Count Total Items: WAY 1
        long totalItems = orders.stream()
                .mapToLong(order -> order.getItems().size())
                .sum();

        System.out.println("Total Items: " + totalItems);

        // Count Total Items: WAY 2
        long totalItems2 = orders.stream()
                .flatMap(order -> order.getItems().stream())
                .count();

        System.out.println("Total Items: " + totalItems2);
    }
}
