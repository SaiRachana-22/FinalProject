package depaul.edu;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;


class PaymentProcessorTest {

	private PaymentProcessor paymentProcessor;

    @Before
    public void setUp() {
        paymentProcessor = new PaymentProcessor();
    }

    @Test
    public void testProcessPaymentWithCreditCard() {
        setUp();
        String input = "creditcard\nSam Evans\n1234567891234567\n123\n";
        double amount = 150.0;

        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertTrue(paymentProcessor.processPayment(amount));
    }

    @Test
    public void testProcessPaymentWithDebitCard() {
        setUp();
        String input = "debitcard\nSam Evans\n1234567891234567\n123\n";
        double amount = 150.0;

        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertTrue(paymentProcessor.processPayment(amount));
    }

    @Test
    public void testProcessPaymentWithInvalidPaymentType() {
        setUp();
        String input = "invalid\n";
        double amount = 150.0;

        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertFalse(paymentProcessor.processPayment(amount));
    }


}
