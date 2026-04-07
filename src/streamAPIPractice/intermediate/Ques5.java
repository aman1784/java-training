package streamAPIPractice.intermediate;

import streamAPIPractice.Order;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// Problem:
// Partition orders into:
// 1. High value (amount > 1000)
// 2. Low value (amount <= 1000)
//
// Expected Concepts:
// -> partitioningBy()
public class Ques5 {
    public static void main(String[] args) {
        List<Order> orders = List.of(
                new Order(1, "Aman", 1200, "DELIVERED", LocalDate.now().minusDays(2), List.of("Laptop", "Mouse")),
                new Order(2, "Rahul", 800, "PLACED", LocalDate.now().minusDays(1), List.of("Keyboard")),
                new Order(3, "Aman", 1500, "SHIPPED", LocalDate.now().minusDays(3), List.of("Monitor")),
                new Order(4, "Sneha", 2000, "DELIVERED", LocalDate.now().minusDays(5), List.of("Phone", "Charger")),
                new Order(5, "Rahul", 500, "CANCELLED", LocalDate.now().minusDays(4), List.of("Cable"))
        );

        double thresholdAmount = 1000;

        Map<Boolean, List<Order>> partitionedOrders = orders.stream()
                .collect(Collectors.partitioningBy(order -> order.getAmount() > thresholdAmount));

        // Print partitioned orders: WAY 1
        partitionedOrders.forEach((isHighValue, order) -> {
            System.out.println(isHighValue ? "High Value Orders" : "Low Value Orders");
            order.forEach(System.out::println);
        });

        // Print partitioned orders: WAY 2
        List<Order> highValueOrders = partitionedOrders.get(true);
        List<Order> lowValueOrders = partitionedOrders.get(false);

        System.out.println("High Value Orders:");
        highValueOrders.forEach(System.out::println);
        System.out.println("Low Value Orders:");
        lowValueOrders.forEach(System.out::println);

        System.out.println("\n=========================\n");

        // Count High vs Low Orders: WAY 1
        long highValueCount = highValueOrders.size();
        long lowValueCount = lowValueOrders.size();

        System.out.println("High Value Orders Count: " + highValueCount);
        System.out.println("Low Value Orders Count: " + lowValueCount);

        // Count High vs Low Orders: WAY 2
        Map<Boolean, Long> partitionedOrderCount = orders.stream()
                .collect(Collectors.partitioningBy(order -> order.getAmount() > thresholdAmount, Collectors.counting()));

        partitionedOrderCount.forEach((isHighValue, count) -> {
            System.out.print(isHighValue ? "High Value Orders Count: " : "Low Value Orders Count: ");
            System.out.println(count);
        });

        System.out.println("\n=========================\n");

        // Sum High vs Low Orders
        Map<Boolean, Double> partitionedOrderSum = orders.stream()
                .collect(Collectors.partitioningBy(order -> order.getAmount() >thresholdAmount, Collectors.summingDouble(Order::getAmount)));

        Double sumOfHighValueOrders = partitionedOrderSum.get(true);
        Double sumOfLowValueOrders = partitionedOrderSum.get(false);

        System.out.println("Sum of High Value Orders: " + sumOfHighValueOrders);
        System.out.println("sum of Low Value Orders: " + sumOfLowValueOrders);
    }
}
