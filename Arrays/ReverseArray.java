package Arrays;

import java.util.Scanner;

public class ReverseArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();

        int[] array = new int[size];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < size; i++) {
            System.out.print("Element " + (i + 1) + ": ");
            array[i] = scanner.nextInt();
        }

        // Reverse the array without using built-in functions
        for (int i = 0, j = size - 1; i < j; i++, j--) {
            // Swap elements at positions i and j
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }

        System.out.println("Reversed array:");
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }

        scanner.close();
    }
}
