package depaul.edu;

import java.util.Scanner;


public class ShoppingApplication {
	
    private Scanner scanner;
    private UserAuthentication authentication;
    private ProductCatalog productCatalog;
    private ShoppingCart cart;
    private PaymentProcessor paymentProcessor;

    public ShoppingApplication(Scanner scanner, UserAuthentication authentication, ProductCatalog productCatalog, ShoppingCart cart, PaymentProcessor paymentProcessor) {
        this.scanner = scanner;
        this.authentication = authentication;
        this.productCatalog = productCatalog;
        this.cart = cart;
        this.paymentProcessor = paymentProcessor;
    }

    public void start() {
    	
    	Logger.log("Shopping application started.");
    	System.out.println("Welcome to the Shopping Application!!");
    	

        // Simulate user authentication
    	boolean isAuthenticated = false;
    	String username;
    	String password;
    	do {
    		System.out.print("Enter the username for login: ");
            username = scanner.nextLine();
            System.out.print("Enter the password for login: ");
            password = scanner.nextLine();
            isAuthenticated = authentication.authenticateUser(username, password);

            if (!isAuthenticated) {
            	Logger.logError("Login failed for: " + username);
            }
    	} while (isAuthenticated != true);
        
        Logger.log("Login successful for: " + username);
        
        // Add products using the ProductFactory
        productCatalog.addProduct(ProductFactory.createProduct("electronic", "Smartphone", 599.99));
        productCatalog.addProduct(ProductFactory.createProduct("electronic", "Laptop", 999.99));
        productCatalog.addProduct(ProductFactory.createProduct("clothing", "T-shirt", 29.99));
        productCatalog.addProduct(ProductFactory.createProduct("clothing", "Jeans", 39.99));
        
        
        int choice;
        do {
            System.out.println("\nWhat would you like to do?");
            System.out.println("1. Browse available products");
            System.out.println("2. Add a product to the shopping cart");
            System.out.println("3. View shopping cart");
            System.out.println("4. Checkout the shopping cart");
            System.out.println("5. Exit the shopping application");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    browseAvailableProducts();
                    break;
                case 2:
                    addProductToCart();
                    break;
                case 3:
                    viewShoppingCart();
                    break;
                case 4:
                    checkoutCart();
                    break;
                case 5:
                	exitApp();
                	break;
                default:
                    System.out.println("Invalid choice!! Please try again by entering a valid choice (Enter the number only): ");
                    Logger.logError("Invalid choice!! Please try again by entering a valid choice (Enter the number only)");
            }
        } while(choice != 5);
        scanner.close();
        Logger.log("Shopping application ended.");
    }


    // 1. Browse available products
    private void browseAvailableProducts() {
        System.out.println("Available products:");
        for (Product product : productCatalog.getAllProducts()) {
            System.out.println("Product: " + product.getName() + ", Price: $" + product.getPrice());
        }
    }

    
    // 2. Add a product to the shopping cart
    private void addProductToCart() {
        System.out.print("Enter product name to add it to the cart: ");
        String cartProductName = scanner.nextLine();
        Product cartProduct = null;
        for (Product product : productCatalog.getAllProducts()) {
            if (product.getName().equalsIgnoreCase(cartProductName)) {
                cartProduct = product;
                break;
            }
        }
        if (cartProduct != null) {
            cart.addItem(cartProduct);
            System.out.println("Product: " + cartProduct.getName() + " added to the shopping cart.");
            Logger.log("Product: " + cartProduct.getName() + " added to the shopping cart.");
        } else {
            System.out.println("Product not found in the catalog.");
            Logger.logError("Product not found in the catalog.");
        }
    }

    
    // 3. View shopping cart
    private void viewShoppingCart() {
        System.out.println("Items in the shopping cart:");
        for (Product item : cart.getItems()) {
            System.out.println("Product: " + item.getName() + ", Price: $" + item.getPrice());
        }
        System.out.println("Total price: $" + cart.calculateTotalPrice());
    }

    
    // 4. Checkout the shopping cart
    private void checkoutCart() {
    	if (cart.getItems().isEmpty()) {
            System.out.println("Your shopping cart is empty. Please add items before checking out.");
            return; // Continue shopping
        }
    	
    	Logger.log("Checkout process initiated.");
    	
        // When user has confirmed all details and wants to finalize the order
        String customerName = authentication.getCurrentUser();
        System.out.print("Enter shipping address: ");
        String shippingAddress = scanner.nextLine();
        
        // Processing the payment
        double totalPrice = cart.calculateTotalPrice();
        boolean paymentSuccess = paymentProcessor.processPayment(totalPrice);

        if (paymentSuccess) {
        	// Creating a CartBuilder instance with the existing ShoppingCart instance
        	Logger.log("Payment Successful.");
            CartBuilder cartBuilder = new CartBuilder(cart);

            // Set customer name and shipping address
            cartBuilder.setCustomerName(customerName);
            cartBuilder.setShippingAddress(shippingAddress);

            // Finalize the order
            Order order = cartBuilder.finalizeOrder();

            // Display order details
            System.out.println("Order placed successfully!");
            System.out.println("Order details:");
            System.out.println("Customer Name: " + order.getCustomerName());
            System.out.println("Shipping Address: " + order.getShippingAddress());
            System.out.println("Total Price: $" + order.getTotalPrice());
            
            Logger.log("Order placed successfully!");
            Logger.log("Order details:");
            Logger.log("Customer Name: " + order.getCustomerName());
            Logger.log("Shipping Address: " + order.getShippingAddress());
            Logger.log("Total Price: $" + order.getTotalPrice());
            
            System.out.println("Thank you for shopping with us!");            
        }
        else {
        	System.out.println("Payment processing failed. Please try again.");
        	Logger.logError("Payment processing failed.");
            return; // Continue shopping
        }
        
    }
    
    
    // 5. Exit the shopping application
    private void exitApp() {
    	System.out.println("Exited successfully from the Shopping Application.");
    }
}
