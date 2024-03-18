package depaul.edu;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class ElectronicProductTest {

	@Test
    public void testElectronicProductCreation() {
        ElectronicProduct electronicProduct = new ElectronicProduct("Laptop", 1200.0);
        assertEquals("Laptop", electronicProduct.getName());
        assertEquals(1200.0, electronicProduct.getPrice(), 0.001);
    }

}
