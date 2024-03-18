package depaul.edu;

import java.util.Scanner;


public class MainClass {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        UserAuthentication authentication = new UserAuthentication();
        ProductCatalog productCatalog = new ProductCatalog();
        ShoppingCart cart = ShoppingCart.getInstance();  // Using the Singleton instance
        PaymentProcessor paymentProcessor = new PaymentProcessor();
        ShoppingApplication shoppingApplication = new ShoppingApplication(scanner, authentication, productCatalog, cart, paymentProcessor);
        shoppingApplication.start();
	}

}