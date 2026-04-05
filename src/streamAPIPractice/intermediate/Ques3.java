package streamAPIPractice.intermediate;

import streamAPIPractice.Order;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// Problem:
// Group orders by customer name and get total order amount per customer
//
// Expected Concepts:
// -> groupingBy()
// -> summingDouble()
public class Ques3 {
    public static void main(String[] args) {
        List<Order> orders = List.of(
                new Order(1, "Aman", 1200, "DELIVERED", LocalDate.now().minusDays(2), List.of("Laptop", "Mouse")),
                new Order(2, "Rahul", 800, "PLACED", LocalDate.now().minusDays(1), List.of("Keyboard")),
                new Order(3, "Aman", 1500, "SHIPPED", LocalDate.now().minusDays(3), List.of("Monitor")),
                new Order(4, "Sneha", 2000, "DELIVERED", LocalDate.now().minusDays(5), List.of("Phone", "Charger")),
                new Order(5, "Rahul", 500, "CANCELLED", LocalDate.now().minusDays(4), List.of("Cable"))
        );

        Map<String, Double> totalAmountPerCustomer = orders.stream()
                .collect(Collectors.groupingBy(
                        Order::getCustomerName,
                        LinkedHashMap::new, // Preserves the order of insertion by customer name
                        Collectors.summingDouble(Order::getAmount)
                ));

        totalAmountPerCustomer.forEach((customer, totalAmount) -> System.out.println(customer + " -> " + totalAmount));

        System.out.println();

        // Sort by total amount in descending order: Top customers by revenue
        totalAmountPerCustomer.entrySet().stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .forEach(entry ->
                        System.out.println(entry.getKey() + " -> " + entry.getValue()));

        System.out.println();

        // Get the top customer by revenue
        totalAmountPerCustomer.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .ifPresent(entry ->
                        System.out.println("Top Customer: " + entry.getKey() + " -> " + entry.getValue()));

        System.out.println();

        // Using TreeMap (Sorted by Key): Sorted alphabetically by customer name
        Map<String, Double> map = orders.stream()
                .collect(Collectors.groupingBy(
                        Order::getCustomerName,
                        java.util.TreeMap::new,
                        Collectors.summingDouble(Order::getAmount)
                ));

        map.forEach((customer, totalAmount) -> System.out.println(customer + " -> " + totalAmount));
    }
}
