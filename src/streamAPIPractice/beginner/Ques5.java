package streamAPIPractice.beginner;

import streamAPIPractice.Order;

import java.time.LocalDate;
import java.util.List;

// Problem Statement:
// Check if any order has amount greater than 1500

// Expected Concepts:
// -> anyMatch
public class Ques5 {
    static void main() {
        List<Order> orders = List.of(
                new Order(1, "Aman", 1200, "DELIVERED", LocalDate.now().minusDays(2), List.of("Laptop", "Mouse")),
                new Order(2, "Rahul", 800, "PLACED", LocalDate.now().minusDays(1), List.of("Keyboard")),
                new Order(3, "Aman", 1500, "SHIPPED", LocalDate.now().minusDays(3), List.of("Monitor")),
                new Order(4, "Sneha", 2000, "DELIVERED", LocalDate.now().minusDays(5), List.of("Phone", "Charger")),
                new Order(5, "Rahul", 500, "CANCELLED", LocalDate.now().minusDays(4), List.of("Cable"))
        );

        double thresholdAmount = 1500;

        boolean orderAmountGreaterThan1500 = orders.stream()
                .anyMatch(order -> order.getAmount() > thresholdAmount);

        System.out.println("Order Amount Greater than 1500: " + orderAmountGreaterThan1500);
    }
}
