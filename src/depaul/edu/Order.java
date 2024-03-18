package depaul.edu;

import java.util.List;


public class Order {
    private String customerName;
    private String shippingAddress;
    private List<Product> items;
    private double totalPrice;

    public Order(String customerName, String shippingAddress, List<Product> items, double totalPrice) {
        this.customerName = customerName;
        this.shippingAddress = shippingAddress;
        this.items = items;
        this.totalPrice = totalPrice;
    }

    // Getters for order details
    public String getCustomerName() {
        return customerName;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public List<Product> getItems() {
        return items;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}
