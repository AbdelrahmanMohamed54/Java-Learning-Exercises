package Variables_And_Data_Types_Exercises;
public class Variable_And_Data_Type {
    public static void main(String[] args) {
        // Declare variables
        int intValue1 = 5;
        int intValue2 = 3;

        double doubleValue1 = 7.5;
        double doubleValue2 = 2.0;

        String stringValue1 = "Hello";
        String stringValue2 = "World";

        // Perform basic arithmetic operations
        int sum = intValue1 + intValue2;
        int difference = intValue1 - intValue2;
        double product = doubleValue1 * doubleValue2;
        double quotient = doubleValue1 / doubleValue2;

        // Print the results
        System.out.println("Sum: " + sum);
        System.out.println("Difference: " + difference);
        System.out.println("Product: " + product);
        System.out.println("Quotient: " + quotient);

        // Note: String concatenation can be done using the + operator
        String concatenatedString = stringValue1 + " " + stringValue2;
        System.out.println("Concatenated String: " + concatenatedString);
    }
}


// The above code declares variables of different data types and performs basic arithmetic operations on them.