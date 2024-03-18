package depaul.edu;

import java.util.ArrayList;
import java.util.List;


public class ProductCatalog {
	
	private List<Product> products;

    public ProductCatalog() {
        this.products = new ArrayList<>();
    }

    // Method to add a product to the catalog
    public void addProduct(Product product) {
        products.add(product);
    }

    // Method to get all products in the catalog
    public List<Product> getAllProducts() {
        return new ArrayList<>(products);
    }
    
}