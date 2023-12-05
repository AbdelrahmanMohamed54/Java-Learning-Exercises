package ExceptionHandling.FileExceptionHandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class FileHandlingExample {
    public static void main(String[] args) {
        try {
            int[] numbers = readDataFromFile("data.txt");

            double average = calculateAverage(numbers);
            System.out.println("Average of numbers: " + average);

            int max = findMax(numbers);
            System.out.println("Maximum value: " + max);

            int divisor = getDivisorFromUser();
            double result = divideMaxByDivisor(max, divisor);
            System.out.println("Result of division: " + result);

        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found.");
        } catch (InputMismatchException e) {
            System.out.println("Error: Data in the file is not in the expected format (integer).");
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (DivideByZeroException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static int[] readDataFromFile(String filename) throws FileNotFoundException, InputMismatchException {
        Scanner fileScanner = new Scanner(new File(filename));
        int count = fileScanner.nextInt();
        int[] numbers = new int[count];

        for (int i = 0; i < count; i++) {
            numbers[i] = fileScanner.nextInt();
        }

        fileScanner.close();
        return numbers;
    }

    private static double calculateAverage(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return (double) sum / numbers.length;
    }

    private static int findMax(int[] numbers) {
        int max = Integer.MIN_VALUE;
        for (int number : numbers) {
            if (number > max) {
                max = number;
            }
        }
        return max;
    }

    private static int getDivisorFromUser() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter divisor: ");
            return scanner.nextInt();
        }
    }    

    private static double divideMaxByDivisor(int max, int divisor) throws DivideByZeroException {
        if (divisor == 0) {
            throw new DivideByZeroException("Cannot divide by zero.");
        }
        return (double) max / divisor;
    }
}
