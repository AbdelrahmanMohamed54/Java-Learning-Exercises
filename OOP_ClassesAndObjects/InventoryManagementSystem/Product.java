package OOP_ClassesAndObjects.InventoryManagementSystem;

public class Product {
    protected int productId;
    protected String productName;
    protected double price;
    protected int quantityInStock;
    protected int unitsSold;
    protected double totalRevenue;
    protected String supplierName;
    protected String category; // Added for product categorization

    public Product(int productId, String productName, double price, int quantityInStock,
                   String supplierName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.quantityInStock = quantityInStock;
        this.unitsSold = 0;
        this.totalRevenue = 0.0;
        this.supplierName = supplierName;
        this.category = category;
    }

    public void displayDetails() {
        System.out.println("Product ID: " + productId);
        System.out.println("Product Name: " + productName);
        System.out.println("Price: $" + price);
        System.out.println("Quantity in Stock: " + quantityInStock);
        System.out.println("Units Sold: " + unitsSold);
        System.out.println("Total Revenue: $" + totalRevenue);
        System.out.println("Supplier: " + supplierName);
        System.out.println("Category: " + category);
    }

    public void updateStock(int quantity) {
        quantityInStock += quantity;
    }

    public void recordSale(int quantity) {
        unitsSold += quantity;
        totalRevenue += quantity * calculateFinalPrice();
        updateStock(-quantity);
    }

    public double calculateFinalPrice() {
        // Add logic for discounts if needed
        return price;
    }

    // Setter methods for updating product details
    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Additional methods for other product-related operations
}


// This class can be further extended based on additional requirements, such as methods for managing discounts, handling returns, or any other functionality relevant to my inventory system.