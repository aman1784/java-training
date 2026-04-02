package streamAPIPractice.beginner;


import streamAPIPractice.Order;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

// Problem:
// Sort all orders by amount (descending) and if amount is same then sort by name
//
// Expected Concepts:
// -> sorted()
// -> Comparator
// -> thenComparing
public class Ques15 {
    public static void main(String[] args) {
        List<Order> orders = List.of(
                new Order(1, "Aman", 1200, "DELIVERED", LocalDate.now().minusDays(2), List.of("Laptop", "Mouse")),
                new Order(2, "Rahul", 800, "PLACED", LocalDate.now().minusDays(1), List.of("Keyboard")),
                new Order(3, "Aman", 1500, "SHIPPED", LocalDate.now().minusDays(3), List.of("Monitor")),
                new Order(4, "Sneha", 1200, "DELIVERED", LocalDate.now().minusDays(5), List.of("Phone", "Charger")),
                new Order(5, "Rahul", 500, "CANCELLED", LocalDate.now().minusDays(4), List.of("Cable"))
        );

        List<Order> sortedOrders = orders.stream()
                .sorted(Comparator.comparingDouble(Order::getAmount).reversed()
                        .thenComparing(Order::getCustomerName))
                .toList();

        sortedOrders.forEach(System.out::println);
    }
}
