package streamAPIPractice;

import java.time.LocalDate;
import java.util.List;

public class Order {
    private int orderId;
    private String customerName;
    private double amount;
    private String status; // "PLACED", "SHIPPED", "DELIVERED", "CANCELLED"
    private LocalDate orderDate;
    private List<String> items;

    // Constructor
    public Order(int orderId, String customerName, double amount, String status, LocalDate orderDate, List<String> items) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.amount = amount;
        this.status = status;
        this.orderDate = orderDate;
        this.items = items;
    }

    // Getters
    public int getOrderId() { return orderId; }
    public String getCustomerName() { return customerName; }
    public double getAmount() { return amount; }
    public String getStatus() { return status; }
    public LocalDate getOrderDate() { return orderDate; }
    public List<String> getItems() { return items; }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", customerName='" + customerName + '\'' +
                ", amount=" + amount +
                ", status='" + status + '\'' +
                ", orderDate=" + orderDate +
                ", items=" + items +
                '}';
    }
}