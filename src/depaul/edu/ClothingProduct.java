package depaul.edu;


public class ClothingProduct implements Product {
	
    private String name;
    private double price;

    public ClothingProduct(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }
    
}