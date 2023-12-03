package OOP_ClassesAndObjects.InventoryManagementSystem;

public class Clothing extends Product {
    private String size;
    private String material;
    private String style;
    private String gender;

    public Clothing(int productId, String productName, double price, int quantityInStock, String supplierName, String category, String size, String material, String style, String gender) {
        super(productId, productName, price, quantityInStock, supplierName, category);
        this.size = size;
        this.material = material;
        this.style = style;
        this.gender = gender;
    }

    public void displayClothingDetails() {
        System.out.println("Product ID: " + productId);
        System.out.println("Product Name: " + productName);
        System.out.println("Size: " + size);
        System.out.println("Material: " + material);
        System.out.println("Style: " + style);
        System.out.println("Gender: " + gender);
        System.out.println("Price: $" + price);
        System.out.println("Quantity in Stock: " + quantityInStock);
    }

    // Additional methods for Clothing-specific operations

    public void updateClothingDetails(String size, String material, String style, String gender) {
        this.size = size;
        this.material = material;
        this.style = style;
        this.gender = gender;
    }

    // This class can be extended by adding additional features or requirements based on my specific needs for the clothing category in my inventory system. 
}
