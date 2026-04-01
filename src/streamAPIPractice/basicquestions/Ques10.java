package streamAPIPractice.basicquestions;

import streamAPIPractice.Order;

import java.time.LocalDate;
import java.util.List;

// Problem:
// Check if all orders are DELIVERED
//
// Expected Concepts:
// -> allMatch()
public class Ques10 {
    private static final String DELIVERED_STATUS = "DELIVERED";

    public static void main(String[] args) {
        List<Order> orders = List.of(
                new Order(1, "Aman", 1200, "DELIVERED", LocalDate.now().minusDays(2), List.of("Laptop", "Mouse")),
                new Order(2, "Rahul", 800, "PLACED", LocalDate.now().minusDays(1), List.of("Keyboard")),
                new Order(3, "Aman", 1500, "SHIPPED", LocalDate.now().minusDays(3), List.of("Monitor")),
                new Order(4, "Sneha", 2000, "DELIVERED", LocalDate.now().minusDays(5), List.of("Phone", "Charger")),
                new Order(5, "Rahul", 500, "CANCELLED", LocalDate.now().minusDays(4), List.of("Cable"))
        );

        boolean areAllOrdersDelivered = orders.stream()
                .allMatch(order -> DELIVERED_STATUS.equals(order.getStatus()));

        System.out.println("Are all orders delivered: " + areAllOrdersDelivered);
    }
}
