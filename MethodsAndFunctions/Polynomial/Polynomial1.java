package MethodsAndFunctions.Polynomial;

class Polynomial {
    private double[] coefficients;

    Polynomial(double[] coefficients) {
        this.coefficients = coefficients;
    }

    double evaluate(double x) {
        double result = 0.0;
        for (int i = 0; i < coefficients.length; i++) {
            result += coefficients[i] * Math.pow(x, i);
        }
        return result;
    }

    Polynomial add(Polynomial other) {
        int maxLength = Math.max(coefficients.length, other.coefficients.length);
        double[] resultCoefficients = new double[maxLength];

        for (int i = 0; i < coefficients.length; i++) {
            resultCoefficients[i] += coefficients[i];
        }

        for (int i = 0; i < other.coefficients.length; i++) {
            resultCoefficients[i] += other.coefficients[i];
        }

        return new Polynomial(resultCoefficients);
    }

    Polynomial subtract(Polynomial other) {
        int maxLength = Math.max(coefficients.length, other.coefficients.length);
        double[] resultCoefficients = new double[maxLength];

        for (int i = 0; i < coefficients.length; i++) {
            resultCoefficients[i] += coefficients[i];
        }

        for (int i = 0; i < other.coefficients.length; i++) {
            resultCoefficients[i] -= other.coefficients[i];
        }

        return new Polynomial(resultCoefficients);
    }
}


// When you compile and run PolynomialOperations.java, it should be able to access the Polynomial class.