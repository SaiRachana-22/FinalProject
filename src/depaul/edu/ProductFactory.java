package depaul.edu;


//Factory Design Pattern Implementation
public class ProductFactory {
	
    public static Product createProduct(String type, String name, double price) {
        if(type.equalsIgnoreCase("electronic"))
        	return new ElectronicProduct(name, price);
        else if(type.equalsIgnoreCase("clothing"))
            return new ClothingProduct(name, price);
        else
            throw new IllegalArgumentException("Invalid product type: " + type);
    }
}