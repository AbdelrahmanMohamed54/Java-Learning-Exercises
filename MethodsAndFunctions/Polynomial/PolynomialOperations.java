package MethodsAndFunctions.Polynomial;

import java.util.Scanner;

public class PolynomialOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the coefficients of the first polynomial (space-separated): ");
        double[] coefficients1 = readCoefficients(scanner);

        System.out.print("Enter the coefficients of the second polynomial (space-separated): ");
        double[] coefficients2 = readCoefficients(scanner);

        Polynomial polynomial1 = new Polynomial(coefficients1);
        Polynomial polynomial2 = new Polynomial(coefficients2);

        System.out.print("Enter the value of x to evaluate the polynomials: ");
        double xValue = scanner.nextDouble();

        System.out.println("Result of evaluating polynomial 1: " + polynomial1.evaluate(xValue));
        System.out.println("Result of evaluating polynomial 2: " + polynomial2.evaluate(xValue));

        Polynomial sum = polynomial1.add(polynomial2);
        Polynomial difference = polynomial1.subtract(polynomial2);

        System.out.println("Sum of polynomials: " + sum.toString());
        System.out.println("Difference of polynomials: " + difference.toString());

        scanner.close();
    }

    private static double[] readCoefficients(Scanner scanner) {
        String[] coefficientsStr = scanner.nextLine().split(" ");
        double[] coefficients = new double[coefficientsStr.length];

        for (int i = 0; i < coefficientsStr.length; i++) {
            coefficients[i] = Double.parseDouble(coefficientsStr[i]);
        }

        return coefficients;
    }
}
