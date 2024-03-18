package depaul.edu;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class ClothingProductTest {

	@Test
    public void testClothingProductCreation() {
        ClothingProduct clothingProduct = new ClothingProduct("T-Shirt", 25.0);
        assertEquals("T-Shirt", clothingProduct.getName());
        assertEquals(25.0, clothingProduct.getPrice(), 0.001);
    }

}
