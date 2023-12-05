package ControlFlow;

import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the score for Exam 1: ");
        int exam1 = scanner.nextInt();

        System.out.print("Enter the score for Exam 2: ");
        int exam2 = scanner.nextInt();

        System.out.print("Enter the score for Exam 3: ");
        int exam3 = scanner.nextInt();

        // Check for valid input
        if (exam1 < 0 || exam1 > 100 || exam2 < 0 || exam2 > 100 || exam3 < 0 || exam3 > 100) {
            System.out.println("Invalid input. Exam scores must be between 0 and 100.");
        } else {
            // Calculate average score
            double average = (exam1 + exam2 + exam3) / 3.0;

            // Determine grade
            char grade;
            if (average >= 90) {
                grade = 'A';
            } else if (average >= 80) {
                grade = 'B';
            } else if (average >= 70) {
                grade = 'C';
            } else if (average >= 60) {
                grade = 'D';
            } else {
                grade = 'F';
            }

            // Display results
            System.out.println("\nAverage Score: " + average);
            System.out.println("Grade: " + grade);
        }

        scanner.close();
    }
}
