package ListsAndMaps;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListManager {
    private static List<String> itemList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            displayMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addItem(scanner);
                    break;
                case 2:
                    displayItems();
                    break;
                case 3:
                    removeItem(scanner);
                    break;
                case 4:
                    clearList();
                    break;
                case 5:
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice != 5);

        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("\nList Manager Menu:");
        System.out.println("1. Add Item");
        System.out.println("2. Display Items");
        System.out.println("3. Remove Item");
        System.out.println("4. Clear List");
        System.out.println("5. Exit");
    }

    private static void addItem(Scanner scanner) {
        System.out.print("Enter the item to add: ");
        String item = scanner.nextLine();
        itemList.add(item);
        System.out.println(item + " added to the list.");
    }

    private static void displayItems() {
        System.out.println("\nItems in the List:");
        if (itemList.isEmpty()) {
            System.out.println("The list is empty.");
        } else {
            for (String item : itemList) {
                System.out.println(item);
            }
        }
    }

    private static void removeItem(Scanner scanner) {
        displayItems();
        System.out.print("Enter the index of the item to remove: ");
        int index = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (index >= 0 && index < itemList.size()) {
            String removedItem = itemList.remove(index);
            System.out.println(removedItem + " removed from the list.");
        } else {
            System.out.println("Invalid index. No item removed.");
        }
    }

    private static void clearList() {
        itemList.clear();
        System.out.println("The list has been cleared.");
    }
}
