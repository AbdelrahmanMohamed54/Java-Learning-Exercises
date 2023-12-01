package OOP_ClassesAndObjects.LibraryManagementSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Represents the main Library Management System
public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Book> availableBooks = new ArrayList<>();
        availableBooks.add(new Book("The Great Gatsby", "F. Scott Fitzgerald"));
        availableBooks.add(new Book("To Kill a Mockingbird", "Harper Lee"));
        availableBooks.add(new Book("1984", "George Orwell"));

        List<LibraryMember> libraryMembers = new ArrayList<>();
        libraryMembers.add(new LibraryMember("Alice"));
        libraryMembers.add(new LibraryMember("Bob"));

        boolean exit = false;

        while (!exit) {
            System.out.println("\nLibrary Management System Menu:");
            System.out.println("1. Display available books");
            System.out.println("2. Display library members");
            System.out.println("3. Borrow a book");
            System.out.println("4. Return a book");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    displayAvailableBooks(availableBooks);
                    break;
                case 2:
                    displayLibraryMembers(libraryMembers);
                    break;
                case 3:
                    borrowBook(availableBooks, libraryMembers, scanner);
                    break;
                case 4:
                    returnBook(availableBooks, libraryMembers, scanner);
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }

        scanner.close();
    }

    // Method to display available books
    private static void displayAvailableBooks(List<Book> availableBooks) {
        System.out.println("\nAvailable Books:");
        for (Book book : availableBooks) {
            System.out.println(book);
        }
    }

    // Method to display library members
    private static void displayLibraryMembers(List<LibraryMember> libraryMembers) {
        System.out.println("\nLibrary Members:");
        for (LibraryMember member : libraryMembers) {
            System.out.println(member);
        }
    }

    // Method to borrow a book
    private static void borrowBook(List<Book> availableBooks, List<LibraryMember> libraryMembers, Scanner scanner) {
        displayAvailableBooks(availableBooks);
        System.out.print("Enter the index of the book to borrow: ");
        int bookIndex = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        displayLibraryMembers(libraryMembers);
        System.out.print("Enter the index of the library member: ");
        int memberIndex = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (bookIndex >= 0 && bookIndex < availableBooks.size() && memberIndex >= 0 && memberIndex < libraryMembers.size()) {
            Book selectedBook = availableBooks.get(bookIndex);
            LibraryMember borrowingMember = libraryMembers.get(memberIndex);

            borrowingMember.borrowBook(selectedBook);
            availableBooks.remove(bookIndex);

            System.out.println(selectedBook.getTitle() + " has been borrowed by " + borrowingMember);
        } else {
            System.out.println("Invalid book or member index.");
        }
    }

    // Method to return a book
    private static void returnBook(List<Book> availableBooks, List<LibraryMember> libraryMembers, Scanner scanner) {
        displayLibraryMembers(libraryMembers);
        System.out.print("Enter the index of the library member returning the book: ");
        int memberIndex = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        LibraryMember returningMember = libraryMembers.get(memberIndex);

        List<Book> borrowedBooks = returningMember.getBorrowedBooks();
        if (!borrowedBooks.isEmpty()) {
            System.out.println("\nBooks borrowed by " + returningMember + ":");
            for (int i = 0; i < borrowedBooks.size(); i++) {
                System.out.println(i + ". " + borrowedBooks.get(i));
            }

            System.out.print("Enter the index of the book to return: ");
            int bookIndex = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (bookIndex >= 0 && bookIndex < borrowedBooks.size()) {
                Book returnedBook = borrowedBooks.get(bookIndex);
                returningMember.returnBook(returnedBook);
                availableBooks.add(returnedBook);

                System.out.println(returnedBook.getTitle() + " has been returned by " + returningMember);
            } else {
                System.out.println("Invalid book index.");
            }
        } else {
            System.out.println(returningMember + " has no borrowed books.");
        }
    }
}
