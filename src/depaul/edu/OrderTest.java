package depaul.edu;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.jupiter.api.Test;


class OrderTest {

	private Order order;
    private List<Product> items;

    @Before
    public void setUp() {
        items = new ArrayList<>();
        items.add(new ElectronicProduct("Laptop", 1200.0));
        items.add(new ClothingProduct("T-Shirt", 25.0));
        order = new Order("Sam Evans", "777 Clarendon St", items, 1245.0);
    }

    @Test
    public void testGetCustomerName() {
    	setUp();
        assertEquals("Sam Evans", order.getCustomerName());
    }

    @Test
    public void testGetShippingAddress() {
    	setUp();
        assertEquals("777 Clarendon St", order.getShippingAddress());
    }

    @Test
    public void testGetItems() {
    	setUp();
        assertEquals(items, order.getItems());
    }

    @Test
    public void testGetTotalPrice() {
    	setUp();
        assertEquals(1245.0, order.getTotalPrice(), 0.001);
    }

}
