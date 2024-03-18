package depaul.edu;


// Builder Design Pattern Implementation
public class CartBuilder {
    private ShoppingCart cart;
    private String customerName;
    private String shippingAddress;

    public CartBuilder(ShoppingCart cart) {
        this.cart = cart;
    }

    // Method to add an item to the cart
    public CartBuilder addItem(Product product) {
        cart.addItem(product);
        return this;
    }

    // Method to remove an item from the cart
    public CartBuilder removeItem(Product product) {
        cart.removeItem(product);
        return this;
    }

    // Method to set customer name
    public CartBuilder setCustomerName(String customerName) {
        this.customerName = customerName;
        return this;
    }

    // Method to set shipping address
    public CartBuilder setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
        return this;
    }

    // Method to finalize the order and return an Order object
    public Order finalizeOrder() {
        Order order = new Order(customerName, shippingAddress, cart.getItems(), cart.calculateTotalPrice());
        cart.clearCart();
        return order;
    }
}
