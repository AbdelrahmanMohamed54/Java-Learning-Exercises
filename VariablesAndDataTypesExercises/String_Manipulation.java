package VariablesAndDataTypesExercises;
public class String_Manipulation {
    public static void main(String[] args) {
        // Declare strings
        String firstName = "John";
        String lastName = "Doe";

        // Concatenate strings
        String fullName = firstName + " " + lastName;

        // Explore string manipulation
        int length = fullName.length();
        String upperCaseFullName = fullName.toUpperCase();
        String lowerCaseFullName = fullName.toLowerCase();
        char firstChar = fullName.charAt(0);

        // Print the results
        System.out.println("Full Name: " + fullName);
        System.out.println("Length: " + length);
        System.out.println("Upper Case: " + upperCaseFullName);
        System.out.println("Lower Case: " + lowerCaseFullName);
        System.out.println("First Character: " + firstChar);
    }
}


// In the code above I explored string Manipulation by concatinating strings using +