package streamAPIPractice.intermediate;

import streamAPIPractice.Order;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

// Problem:
// Partition Order on the staus: isDelivered
//
// Expected Concepts:
// -> partitioningBy()
// -> mapping()
public class Ques6 {
    public static void main(String[] args) {
        List<Order> orders = List.of(
                new Order(1, "Aman", 1200, "DELIVERED", LocalDate.now().minusDays(2), List.of("Laptop", "Mouse")),
                new Order(2, "Rahul", 800, "PLACED", LocalDate.now().minusDays(1), List.of("Keyboard")),
                new Order(3, "Aman", 1500, "SHIPPED", LocalDate.now().minusDays(3), List.of("Monitor")),
                new Order(4, "Sneha", 2000, "DELIVERED", LocalDate.now().minusDays(5), List.of("Phone", "Charger")),
                new Order(5, "Rahul", 500, "CANCELLED", LocalDate.now().minusDays(4), List.of("Cable"))
        );

        Map<Boolean, Set<String>> isDelivered = orders.stream()
                .collect(Collectors.partitioningBy(order ->
                        "DELIVERED".equals(order.getStatus()),
                        Collectors.mapping(
                                Order::getCustomerName,
                                Collectors.toSet()
                        )
                ));

        isDelivered.forEach((isDeliver, customers) -> {
            System.out.println(isDeliver ? "Delivered Orders:" : "Not Delivered Orders:");
            customers.forEach(System.out::println);
        });
    }
}
