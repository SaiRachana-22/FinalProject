package depaul.edu;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import org.junit.Before;
import org.junit.jupiter.api.Test;


class ProductCatalogTest {

	private ProductCatalog catalog;
	private ProductFactory productFactory;

    @Before
    public void setUp() {
        catalog = new ProductCatalog();
        productFactory = new ProductFactory();
    }

    @Test
    public void testAddProduct() {
    	setUp();
    	Product product1 = productFactory.createProduct("electronic", "Test Product 1", 10.0);
    	catalog.addProduct(product1);
        assertTrue(catalog.getAllProducts().contains(product1));
    }

    @Test
    public void testGetAllProduct() {
    	setUp();
    	Product product1 = productFactory.createProduct("electronic", "Test Product 1", 10.0);
    	Product product2 = productFactory.createProduct("clothing", "Test Product 2", 20.0);
    	catalog.addProduct(product1);
    	catalog.addProduct(product2);
    	assertEquals(2, catalog.getAllProducts().size());
    	assertTrue(catalog.getAllProducts().contains(product1));
    	assertTrue(catalog.getAllProducts().contains(product2));
    }
    
    
}
