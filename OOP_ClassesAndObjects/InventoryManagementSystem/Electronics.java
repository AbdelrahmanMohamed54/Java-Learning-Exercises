package OOP_ClassesAndObjects.InventoryManagementSystem;

public class Electronics extends Product {
    private String brand;
    private String model;
    private String warrantyInfo;
    private String technicalSpecifications;
    private String maintenanceHistory;
    private double averageRating;
    private int numberOfReviews;
    private boolean stockAlert;

    public Electronics(int productId, String productName, double price, int quantityInStock, String supplierName, String category, String brand) {
        super(productId, productName, price, quantityInStock, supplierName, category);
        this.brand = brand;
        this.brand = brand;
        this.model = model;
        this.warrantyInfo = warrantyInfo;
        this.technicalSpecifications = technicalSpecifications;
        this.maintenanceHistory = "";
        this.averageRating = 0.0;
        this.numberOfReviews = 0;
        this.stockAlert = false;
    }

    public void displayElectronicsDetails() {
        System.out.println("Product ID: " + productId);
        System.out.println("Product Name: " + productName);
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Warranty Information: " + warrantyInfo);
        System.out.println("Technical Specifications: " + technicalSpecifications);
        System.out.println("Price: $" + price);
        System.out.println("Quantity in Stock: " + quantityInStock);
        System.out.println("Maintenance History: " + maintenanceHistory);
        System.out.println("Average Rating: " + averageRating);
        System.out.println("Number of Reviews: " + numberOfReviews);
        System.out.println("Stock Alert: " + stockAlert);
    }

    public void updateElectronicsDetails(String brand, String model, String warrantyInfo, String technicalSpecifications) {
        this.brand = brand;
        this.model = model;
        this.warrantyInfo = warrantyInfo;
        this.technicalSpecifications = technicalSpecifications;
    }

    public void addMaintenanceRecord(String maintenanceRecord) {
        this.maintenanceHistory += maintenanceRecord + "\n";
    }

    public void addReview(double rating) {
        averageRating = ((averageRating * numberOfReviews) + rating) / (numberOfReviews + 1);
        numberOfReviews++;
    }

    public void setStockAlert(boolean stockAlert) {
        this.stockAlert = stockAlert;
    }

    // This class can be extended by adding additional features or requirements based on my specific needs for the Electronics category in my inventory system. 
}
