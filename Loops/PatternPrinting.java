package Loops;

import java.util.Scanner;

public class PatternPrinting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the height of the pyramid: ");
        int height = scanner.nextInt();

        System.out.println("Pyramid Pattern:");
        for (int i = 1; i <= height; i++) {
            // Print spaces
            for (int j = 1; j <= height - i; j++) {
                System.out.print(" ");
            }

            // Print increasing numbers
            for (int k = i; k <= 2 * i - 1; k++) {
                System.out.print(k);
            }

            // Print decreasing numbers
            for (int l = 2 * i - 2; l >= i; l--) {
                System.out.print(l);
            }

            System.out.println();
        }

        scanner.close();
    }
}
