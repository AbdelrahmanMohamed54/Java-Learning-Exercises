package OOP_ClassesAndObjects.InventoryManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class InventoryManager {
    private List<Product> products;

    public InventoryManager() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void updateProductDetails(int productId, double price, int quantity) {
        for (Product product : products) {
            if (product.productId == productId) {
                product.price = price;
                product.updateStock(quantity);
                break;
            }
        }
    }

    public void generateLowStockReport() {
        System.out.println("\nLow Stock Report:");
        for (Product product : products) {
            if (product.quantityInStock < 5) {
                System.out.println("Product ID: " + product.productId);
                System.out.println("Product Name: " + product.productName);
                System.out.println("Quantity in Stock: " + product.quantityInStock);
                System.out.println("------------------------------");
            }
        }
    }

    public void generateProductCatalog() {
        System.out.println("\nProduct Catalog:");
        for (Product product : products) {
            product.displayDetails();
            System.out.println("------------------------------");
        }
    }

    public Product findProductById(int productId) {
        for (Product product : products) {
            if (product.productId == productId) {
                return product;
            }
        }
        return null;
    }

    // Additional methods for managing the inventory, sales, and revenue tracking
    public void recordSale(int productId, int quantity) {
        Product product = findProductById(productId);
        if (product != null) {
            product.recordSale(quantity);
        }
    }

    // You can add more methods as needed based on the specific requirements
}


// Adjustments can be made based on the specific requirements and business logic of my Inventory.