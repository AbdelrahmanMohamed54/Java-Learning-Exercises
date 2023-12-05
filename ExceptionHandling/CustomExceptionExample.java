package ExceptionHandling;


class CustomException extends Exception {
    public CustomException(String message) {
        super(message);
    }
}

public class CustomExceptionExample {
    public static void main(String[] args) {
        try {
            validateInput(5);
            validateInput(-3); // This will throw CustomException
        } catch (CustomException e) {
            System.out.println("Custom Exception caught: " + e.getMessage());
        }
    }

    private static void validateInput(int value) throws CustomException {
        if (value < 0) {
            throw new CustomException("Input must be a non-negative number.");
        }
    }
}
