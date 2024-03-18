package depaul.edu;


public class MockPaymentGateway {
	
	public boolean processPayment(String name, Long number, int cvv, double amount) {
		// Assuming that payment is always successful in our case
		System.out.println("Validating the card details.....");
		System.out.println("Processing payment of $" + amount);
		System.out.println("Payment successful!");
        return true;
    }

}
