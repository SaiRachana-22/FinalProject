package depaul.edu;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;


class CartBuilderTest {
	
	private ShoppingCart cart;
	private CartBuilder cartBuilder;
	private ProductFactory productFactory;

    @Before
	public void setUp() {
    	cart = ShoppingCart.getInstance();
	    cartBuilder = new CartBuilder(cart);
	    productFactory = new ProductFactory();
	}

	@Test
	public void testAddItem() {
        setUp();
 	    Product product1 = productFactory.createProduct("electronic", "Test Product 1", 1299.99);
   	    Product product2 = productFactory.createProduct("clothing", "Test Product 2", 25.99);
	    
 	    cartBuilder.addItem(product1).addItem(product2);

	    assertEquals(2, cart.getItems().size());
	    assertTrue(cart.getItems().contains(product1));
	    assertTrue(cart.getItems().contains(product2));
	    cart.clearCart();
	}
	
	@Test
	public void testRemoveItem() {
        setUp();
        Product product1 = productFactory.createProduct("electronic", "Test Product 1", 1299.99);
   	    Product product2 = productFactory.createProduct("clothing", "Test Product 2", 25.99);
	    cartBuilder.addItem(product1).addItem(product2);

	    cartBuilder.removeItem(product1);

	    assertEquals(1, cart.getItems().size());
	    assertFalse(cart.getItems().contains(product1));
	    assertTrue(cart.getItems().contains(product2));
	    cart.clearCart();
	}

	@Test
    public void testFinalizeOrder() {
        setUp();
        Product product1 = productFactory.createProduct("electronic", "Test Product 1", 1299.99);
   	    Product product2 = productFactory.createProduct("clothing", "Test Product 2", 25.99);
        cartBuilder.addItem(product1);
        cartBuilder.addItem(product2);

        
        String customerName = "Sam Evans";
        String shippingAddress = "777 Clarendon St, Chicago, USA";
        cartBuilder.setCustomerName(customerName);
        cartBuilder.setShippingAddress(shippingAddress);

        Order order = cartBuilder.finalizeOrder();

        assertNotNull(order);
        assertEquals(customerName, order.getCustomerName());
        assertEquals(shippingAddress, order.getShippingAddress());
        
        List<Product> items = order.getItems();
        assertEquals(2, items.size());
        assertTrue(items.contains(product1));
        assertTrue(items.contains(product2));

        double expectedTotalPrice = product1.getPrice() + product2.getPrice();
        assertEquals(expectedTotalPrice, order.getTotalPrice(), 0.01);
        
        assertTrue(cart.getItems().isEmpty()); // Cart should be cleared after finalizing the order
    }
}
