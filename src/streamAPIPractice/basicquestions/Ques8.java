package streamAPIPractice.basicquestions;

import streamAPIPractice.Order;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

// Problem Statement:
// Find the first order with amount greater than 1000
//
// Expected Concepts:
// -> filter
// -> findFirst
// -> Optional
public class Ques8 {
    static void main() {
        List<Order> orders = List.of(
                new Order(1, "Aman", 1200, "DELIVERED", LocalDate.now().minusDays(2), List.of("Laptop", "Mouse")),
                new Order(2, "Rahul", 800, "PLACED", LocalDate.now().minusDays(1), List.of("Keyboard")),
                new Order(3, "Aman", 1500, "SHIPPED", LocalDate.now().minusDays(3), List.of("Monitor")),
                new Order(4, "Sneha", 2000, "DELIVERED", LocalDate.now().minusDays(5), List.of("Phone", "Charger")),
                new Order(5, "Rahul", 500, "CANCELLED", LocalDate.now().minusDays(4), List.of("Cable"))
        );

        double thresholdAmount = 1000;

//        Optional<Order> firstOrder = orders.stream()
//                .filter(order -> order.getAmount() > thresholdAmount)
//                .findFirst();
//
//        System.out.println("First order with amount > 1000: " + firstOrder.orElse(null));

        Optional<Order> firstOrder = orders.stream()
                .filter(order -> order.getAmount() > thresholdAmount)
                .findFirst();

//        firstOrder.ifPresentOrElse(order ->
//                System.out.println("First order with amount > 1000: " + order), () -> System.out.println("No order found with amount > 1000")
//        );

        firstOrder.ifPresentOrElse(System.out::println, () -> System.out.println("No order found with amount > 1000"));
    }
}
