package streamAPIPractice.beginner;

import streamAPIPractice.Order;

import java.time.LocalDate;
import java.util.List;
import java.util.OptionalDouble;

// Problem
// Find the maximum order amount
//
// Expected Concepts:
// -> mapToDouble()
// -> max()
public class Ques21 {
    public static void main(String[] args) {
        List<Order> orders = List.of(
                new Order(1, "Aman", 1200, "DELIVERED", LocalDate.now().minusDays(2), List.of("Laptop", "Mouse")),
                new Order(2, "Rahul", 800, "PLACED", LocalDate.now().minusDays(1), List.of("Keyboard")),
                new Order(3, "Aman", 1500, "SHIPPED", LocalDate.now().minusDays(3), List.of("Monitor")),
                new Order(4, "Sneha", 2000, "DELIVERED", LocalDate.now().minusDays(5), List.of("Phone", "Charger")),
                new Order(5, "Rahul", 500, "CANCELLED", LocalDate.now().minusDays(4), List.of("Cable"))
        );

        OptionalDouble maxOptional = orders.stream()
                .mapToDouble(Order::getAmount)
                .max();

        maxOptional.ifPresentOrElse(System.out::println, () -> System.out.println(0.0));
    }
}
