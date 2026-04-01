package streamAPIPractice.beginner;

import streamAPIPractice.Order;

import java.time.LocalDate;
import java.util.List;

// Problem Statement:
// Check if all orders have amount greater than 300
//
// Expected Concepts:
// -> allMatch
public class Ques6 {
    static void main() {
        List<Order> orders = List.of(
                new Order(1, "Aman", 1200, "DELIVERED", LocalDate.now().minusDays(2), List.of("Laptop", "Mouse")),
                new Order(2, "Rahul", 800, "PLACED", LocalDate.now().minusDays(1), List.of("Keyboard")),
                new Order(3, "Aman", 1500, "SHIPPED", LocalDate.now().minusDays(3), List.of("Monitor")),
                new Order(4, "Sneha", 2000, "DELIVERED", LocalDate.now().minusDays(5), List.of("Phone", "Charger")),
                new Order(5, "Rahul", 500, "CANCELLED", LocalDate.now().minusDays(4), List.of("Cable"))
        );

        double thresholdAmount = 300;

        boolean areAllOrdersAboveThreshold = orders.stream()
                .allMatch(order -> order.getAmount() > thresholdAmount);

        System.out.println("All orders have amount greater than 300: " + areAllOrdersAboveThreshold);
    }
}
