package depaul.edu;

import java.util.ArrayList;
import java.util.List;


// Singleton Design Pattern Implementation
public class ShoppingCart {
    
	private static ShoppingCart instance;
    private List<Product> items;
    
    private ShoppingCart() {
        this.items = new ArrayList<>();
    }
    
    public static synchronized ShoppingCart getInstance() {
        if (instance == null) {
            instance = new ShoppingCart();
        }
        return instance;
    }
    
    // Method to add a product to the shopping cart    
    public void addItem(Product product) {
        items.add(product);
    }

    // Method to remove a product from the shopping cart
    public void removeItem(Product product) {
        items.remove(product);
    }

    // Method to get all products in the shopping cart
    public List<Product> getItems() {
        return new ArrayList<>(items);
    }
    
    // Method to calculate total price for the products in the shopping cart
    public double calculateTotalPrice() {
        double totalPrice = 0;
        for (Product item : items) {
            totalPrice += item.getPrice();
        }
        return totalPrice;
    }

    // Method to clear the shopping cart
    public void clearCart() {
        items.clear();
    }
}