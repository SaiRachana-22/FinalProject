package depaul.edu;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class ProductFactoryTest {

	@Test
    public void testCreateElectronicProduct() {
        Product electronicProduct = ProductFactory.createProduct("electronic", "Laptop", 1200.0);
        assertTrue(electronicProduct instanceof ElectronicProduct);
        assertEquals("Laptop", electronicProduct.getName());
        assertEquals(1200.0, electronicProduct.getPrice(), 0.001);
    }

    @Test
    public void testCreateClothingProduct() {
        Product clothingProduct = ProductFactory.createProduct("clothing", "T-Shirt", 25.0);
        assertTrue(clothingProduct instanceof ClothingProduct);
        assertEquals("T-Shirt", clothingProduct.getName());
        assertEquals(25.0, clothingProduct.getPrice(), 0.001);
    }

    @Test
    public void testInvalidProductType() {
    	try {
            ProductFactory.createProduct("invalid", "Invalid Product", 0.0);
            fail("Expected IllegalArgumentException was not thrown");
        } catch (IllegalArgumentException e) {
            // If an IllegalArgumentException is thrown, this test will pass
        }
    }

}
