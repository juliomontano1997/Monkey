package checker;

public class CheckerErrors extends RuntimeException {
    public CheckerErrors(String message) {
        super(message);
    }
}
