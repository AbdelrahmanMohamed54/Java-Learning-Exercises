package OOP_ClassesAndObjects.InventoryManagementSystem;

import java.util.Scanner;

public class InventoryUI {
    private InventoryManager inventoryManager;
    private Scanner scanner;

    public InventoryUI(InventoryManager inventoryManager) {
        this.inventoryManager = inventoryManager;
        this.scanner = new Scanner(System.in);
    }

    public void startMenu() {
        boolean exit = false;

        while (!exit) {
            System.out.println("\nInventory Management System Menu:");
            System.out.println("1. Add Product");
            System.out.println("2. Update Product Details");
            System.out.println("3. Generate Low Stock Report");
            System.out.println("4. Generate Product Catalog");
            System.out.println("5. Record Sale");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    updateProductDetails();
                    break;
                case 3:
                    inventoryManager.generateLowStockReport();
                    break;
                case 4:
                    inventoryManager.generateProductCatalog();
                    break;
                case 5:
                    recordSale();
                    break;
                case 6:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    private void addProduct() {
        System.out.print("Enter Product ID: ");
        int productId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // Collect other product details based on your class structure
        // ...

        // Create and add the product to the inventory
        Product product = new Product(productId, "Sample Product", 10.0, 50, "Sample Supplier", "Sample Category");
        inventoryManager.addProduct(product);
        System.out.println("Product added successfully!");
    }

    private void updateProductDetails() {
        System.out.print("Enter Product ID to update: ");
        int productId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // Check if the product exists
        Product product = inventoryManager.findProductById(productId);
        if (product != null) {
            // Collect updated details based on your class structure
            // ...

            // Update the product details
            inventoryManager.updateProductDetails(productId, 15.0, 20);
            System.out.println("Product details updated successfully!");
        } else {
            System.out.println("Product not found.");
        }
    }

    private void recordSale() {
        System.out.print("Enter Product ID to record sale: ");
        int productId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // Check if the product exists
        Product product = inventoryManager.findProductById(productId);
        if (product != null) {
            System.out.print("Enter quantity sold: ");
            int quantitySold = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            // Record the sale
            inventoryManager.recordSale(productId, quantitySold);
            System.out.println("Sale recorded successfully!");
        } else {
            System.out.println("Product not found.");
        }
    }
}

// This InventoryUI class provides a simple text-based user interface with options to add a product, update product details, generate reports, record sales, and exit the system. 
// The UI and the way user input is handled can be customized based on the business requirements and the level of sophistication required in the application.