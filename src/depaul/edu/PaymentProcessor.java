package depaul.edu;

import java.util.Scanner;


public class PaymentProcessor {
	
	private MockPaymentGateway paymentGateway;

    public PaymentProcessor() {
        this.paymentGateway = new MockPaymentGateway();
    }
	
	public boolean processPayment(double amount) {
		// Simulate payment processing with a mock payment gateway
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		String name;
		Long number;
		int cvv;
		System.out.println("Select Payment Type: (creditcard/debitcard)");
		String paymentType = scanner.nextLine();
		if(paymentType.equalsIgnoreCase("creditcard")) {
			System.out.println("Enter name on the credit card: ");
			name = scanner.nextLine();
			System.out.println("Enter the credit card number: ");
			number = scanner.nextLong();
			scanner.nextLine(); 
			System.out.println("Enter CVV: ");
			cvv = scanner.nextInt();
			scanner.nextLine(); 
		}
		else if(paymentType.equalsIgnoreCase("debitcard")) {
			System.out.println("Enter name on the debit card: ");
			name = scanner.nextLine();
			System.out.println("Enter the debit card number: ");
			number = scanner.nextLong();
			scanner.nextLine(); 
			System.out.println("Enter CVV: ");
			cvv = scanner.nextInt();
			scanner.nextLine(); 
		}
		else {
			System.out.println("Invalid payment type: " + paymentType);
		    return false;
		}
		
        return paymentGateway.processPayment(name, number, cvv, amount);
    }
	
}