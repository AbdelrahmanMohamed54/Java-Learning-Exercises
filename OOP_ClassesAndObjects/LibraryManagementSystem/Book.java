package OOP_ClassesAndObjects.LibraryManagementSystem;

import java.util.ArrayList;
import java.util.List;

// Represents a Book in the library
public class Book {
    private String title;
    private String author;
    private boolean checkedOut;

    // Constructor to initialize the book
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.checkedOut = false;
    }

    // Getter methods
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isCheckedOut() {
        return checkedOut;
    }

    // Methods to check out and return the book
    public void checkOut() {
        checkedOut = true;
    }

    public void returnBook() {
        checkedOut = false;
    }

    // String representation of the book
    @Override
    public String toString() {
        return title + " by " + author;
    }
}

