package streamAPIPractice.beginner;

import streamAPIPractice.Order;

import java.time.LocalDate;
import java.util.List;

// Problem Statement:
// Get a list of customer names who have placed orders with amount greater than 1000.

// Expected Concepts:
// -> filter
// -> map
public class Ques1 {
    static void main(String[] args) {
        List<Order> orders = List.of(
                new Order(1, "Aman", 1200, "DELIVERED", LocalDate.now().minusDays(2), List.of("Laptop", "Mouse")),
                new Order(2, "Rahul", 800, "PLACED", LocalDate.now().minusDays(1), List.of("Keyboard")),
                new Order(3, "Aman", 1500, "SHIPPED", LocalDate.now().minusDays(3), List.of("Monitor")),
                new Order(4, "Sneha", 2000, "DELIVERED", LocalDate.now().minusDays(5), List.of("Phone", "Charger")),
                new Order(5, "Rahul", 500, "CANCELLED", LocalDate.now().minusDays(4), List.of("Cable"))
        );

        double threshold = 1000;

        List<String> customerNames = orders.stream()
                .filter(order -> order.getAmount() > threshold)
                .map(Order::getCustomerName)
                .toList();

        System.out.println(customerNames);
    }
}
