package depaul.edu;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;


class ShoppingCartTest {

	private ShoppingCart cart;
	private ProductFactory productFactory;

    @Before
    public void setUp() {
        cart = ShoppingCart.getInstance();
        cart.clearCart(); // Clear the cart before each test
        productFactory = new ProductFactory();
    }

    @Test
    public void testAddItem() {
    	setUp();
        Product electronicProduct = productFactory.createProduct("electronic", "Laptop", 1000.0);
        cart.addItem(electronicProduct);
        assertEquals(1, cart.getItems().size());
        assertTrue(cart.getItems().contains(electronicProduct));
    }

    @Test
    public void testRemoveItem() {
    	setUp();
        Product clothingProduct = productFactory.createProduct("clothing", "T-Shirt", 20.0);
        cart.addItem(clothingProduct);
        cart.removeItem(clothingProduct);
        assertEquals(0, cart.getItems().size());
        assertFalse(cart.getItems().contains(clothingProduct));
    }
    
    @Test
    public void testGetItems() {
    	setUp();
    	Product product1 = productFactory.createProduct("electronic", "Test Product 1", 10.0);
    	Product product2 = productFactory.createProduct("clothing", "Test Product 2", 20.0);
        cart.addItem(product1);
        cart.addItem(product2);
        List<Product> items = cart.getItems();
        assertEquals(2, items.size());
        assertTrue(items.contains(product1));
        assertTrue(items.contains(product2));
    }

    @Test
    public void testCalculateTotalPrice() {
    	setUp();
    	Product product1 = productFactory.createProduct("electronic", "Test Product 1", 10.0);
    	Product product2 = productFactory.createProduct("clothing", "Test Product 2", 20.0);
    	cart.addItem(product1);
        cart.addItem(product2);
        assertEquals(30.0, cart.calculateTotalPrice(), 0.01); // delta = 0.01 for double comparison
    }
    
    @Test
    public void testClearCart() {
    	setUp();
    	Product product1 = productFactory.createProduct("electronic", "Test Product 1", 10.0);
    	Product product2 = productFactory.createProduct("clothing", "Test Product 2", 20.0);
        cart.addItem(product1);
        cart.addItem(product2);
        cart.clearCart();
        List<Product> items = cart.getItems();
        assertEquals(0, items.size());
    }
    
}
