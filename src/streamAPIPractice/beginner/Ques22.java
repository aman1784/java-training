package streamAPIPractice.beginner;

import streamAPIPractice.Order;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

// Problem:
// Find the minimum order amount
//
// Expected Concepts:
// -> mapToDouble()
// -> min()
public class Ques22 {
    public static void main(String[] args) {
        List<Order> orders = List.of(
                new Order(1, "Aman", 1200, "DELIVERED", LocalDate.now().minusDays(2), List.of("Laptop", "Mouse")),
                new Order(2, "Rahul", 800, "PLACED", LocalDate.now().minusDays(1), List.of("Keyboard")),
                new Order(3, "Aman", 1500, "SHIPPED", LocalDate.now().minusDays(3), List.of("Monitor")),
                new Order(4, "Sneha", 2000, "DELIVERED", LocalDate.now().minusDays(5), List.of("Phone", "Charger")),
                new Order(5, "Rahul", 500, "CANCELLED", LocalDate.now().minusDays(4), List.of("Cable"))
        );

        // double
        double averageMinimumAmount = orders.stream()
                .mapToDouble(Order::getAmount)
                .min().orElse(0.0);

        System.out.println(averageMinimumAmount);

        // Optional<Order>: METHOD 1
        Optional<Order> optionalOrder = orders.stream()
                .min(Comparator.comparingDouble(Order::getAmount));

        optionalOrder.ifPresentOrElse(System.out::println, () -> System.out.println("No order found"));

        // Optional<Order>: METHOD 2
        orders.stream()
                .min(Comparator.comparingDouble(Order::getAmount))
                .ifPresentOrElse(
                        System.out::println,
                        () -> System.out.println("No order found")
                );
    }
}
