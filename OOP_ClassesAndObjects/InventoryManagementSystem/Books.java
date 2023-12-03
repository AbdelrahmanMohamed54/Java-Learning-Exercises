package OOP_ClassesAndObjects.InventoryManagementSystem;

public class Books extends Product {
    private String author;
    private String genre;
    private int numberOfPages;
    private String language;

    public Books(int productId, String productName, double price, int quantityInStock, String supplierName, String category, String author, String genre, int numberOfPages, String language) {
        super(productId, productName, price, quantityInStock, supplierName, category);
        this.author = author;
        this.genre = genre;
        this.numberOfPages = numberOfPages;
        this.language = language;
    }

    public void displayBookDetails() {
        System.out.println("Product ID: " + productId);
        System.out.println("Product Name: " + productName);
        System.out.println("Author: " + author);
        System.out.println("Genre: " + genre);
        System.out.println("Number of Pages: " + numberOfPages);
        System.out.println("Language: " + language);
        System.out.println("Price: $" + price);
        System.out.println("Quantity in Stock: " + quantityInStock);
    }

    // Additional methods for Books-specific operations

    public void updateBookDetails(String author, String genre, int numberOfPages, String language) {
        this.author = author;
        this.genre = genre;
        this.numberOfPages = numberOfPages;
        this.language = language;
    }

    // This class can be extended by adding additional features or requirements based on my specific needs for the Books category in my inventory system. 
}
