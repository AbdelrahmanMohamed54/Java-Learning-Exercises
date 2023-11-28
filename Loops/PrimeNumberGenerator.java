package Loops;

import java.util.Scanner;

public class PrimeNumberGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the limit for prime numbers: ");
        int limit = scanner.nextInt();

        System.out.println("Prime Numbers up to " + limit + ":");
        for (int i = 2; i <= limit; i++) {
            if (isPrime(i)) {
                System.out.print(i + " ");
            }
        }

        scanner.close();
    }

    private static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
