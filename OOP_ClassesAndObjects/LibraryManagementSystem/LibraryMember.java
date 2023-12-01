package OOP_ClassesAndObjects.LibraryManagementSystem;

import java.util.ArrayList;
import java.util.List;

// Represents a Library Member who can borrow and return books
public class LibraryMember {
    private String name;
    private List<Book> borrowedBooks;

    // Constructor to initialize the library member
    public LibraryMember(String name) {
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }

    // Method to borrow a book
    public void borrowBook(Book book) {
        borrowedBooks.add(book);
        book.checkOut();
    }

    // Method to return a book
    public void returnBook(Book book) {
        borrowedBooks.remove(book);
        book.returnBook();
    }

    // Getter method for the list of borrowed books
    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    // String representation of the library member
    @Override
    public String toString() {
        return name;
    }
}

