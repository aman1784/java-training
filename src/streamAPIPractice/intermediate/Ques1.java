package streamAPIPractice.intermediate;

import streamAPIPractice.Order;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// Problem:
// Group orders by customer name
//
// Expected Concepts:
// -> collect()
// -> Collectors.groupingBy()
public class Ques1 {
    public static void main(String[] args) {
        List<Order> orders = List.of(
                new Order(1, "Aman", 1200, "DELIVERED", LocalDate.now().minusDays(2), List.of("Laptop", "Mouse")),
                new Order(2, "Rahul", 800, "PLACED", LocalDate.now().minusDays(1), List.of("Keyboard")),
                new Order(3, "Aman", 1500, "SHIPPED", LocalDate.now().minusDays(3), List.of("Monitor")),
                new Order(4, "Sneha", 2000, "DELIVERED", LocalDate.now().minusDays(5), List.of("Phone", "Charger")),
                new Order(5, "Rahul", 500, "CANCELLED", LocalDate.now().minusDays(4), List.of("Cable"))
        );

        Map<String, List<Order>> groupedOrders = orders.stream()
                .collect(Collectors.groupingBy(Order::getCustomerName));

        groupedOrders.forEach((customerName, listOfOrders) -> System.out.println(customerName + " -> " + listOfOrders));

        System.out.println();

        // LinkedHashMap -> Preserves the order of insertion
        groupedOrders = orders.stream()
                .collect(Collectors.groupingBy(
                        Order::getCustomerName,
                        LinkedHashMap::new,
                        Collectors.toList()
                ));

        // Better Readability
        groupedOrders.forEach((customer, ordersList) -> {
            System.out.println("Customer: " + customer);
            ordersList.forEach(System.out::println);
            System.out.println("----------");
        });

        System.out.println();

        // Count Instead of List per customer
        Map<String, Long> orderCountByCustomer = orders.stream()
                .collect(Collectors.groupingBy(
                        Order::getCustomerName,
                        LinkedHashMap::new,
                        Collectors.counting()
                ));

        orderCountByCustomer.forEach((customer, count) -> System.out.println(customer + " -> " + count));

        System.out.println();

        // Count Instead of List
        Map<String, Double> totalAmountByCustomer = orders.stream()
                .collect(Collectors.groupingBy(Order::getCustomerName,
                        LinkedHashMap::new,
                        Collectors.summingDouble(Order::getAmount)
                        ));

        totalAmountByCustomer.forEach((customer, totalAmount) -> System.out.println(customer + " -> " + totalAmount));
    }
}
