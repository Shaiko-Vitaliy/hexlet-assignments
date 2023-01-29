package exercise;

// BEGIN
public class NegativeRadiusException extends Exception {
    private final String errorMessage;

    public NegativeRadiusException(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
// END
