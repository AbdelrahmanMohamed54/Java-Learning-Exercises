package ListsAndMaps;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SimpleDictionary {
    private static Map<String, String> dictionary = new HashMap<>();

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
                    addWord(scanner);
                    break;
                case 2:
                    translateWord(scanner);
                    break;
                case 3:
                    displayDictionary();
                    break;
                case 4:
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice != 4);

        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("\nSimple Dictionary Menu:");
        System.out.println("1. Add Word");
        System.out.println("2. Translate Word");
        System.out.println("3. Display Dictionary");
        System.out.println("4. Exit");
    }

    private static void addWord(Scanner scanner) {
        System.out.print("Enter the word to add: ");
        String word = scanner.nextLine();
        System.out.print("Enter the translation: ");
        String translation = scanner.nextLine();
        dictionary.put(word, translation);
        System.out.println("Word added to the dictionary.");
    }

    private static void translateWord(Scanner scanner) {
        System.out.print("Enter the word to translate: ");
        String word = scanner.nextLine();
        String translation = dictionary.get(word);
        if (translation != null) {
            System.out.println("Translation: " + translation);
        } else {
            System.out.println("Word not found in the dictionary.");
        }
    }

    private static void displayDictionary() {
        System.out.println("\nWords in the Dictionary:");
        if (dictionary.isEmpty()) {
            System.out.println("The dictionary is empty.");
        } else {
            for (Map.Entry<String, String> entry : dictionary.entrySet()) {
                System.out.println(entry.getKey() + " - " + entry.getValue());
            }
        }
    }
}
