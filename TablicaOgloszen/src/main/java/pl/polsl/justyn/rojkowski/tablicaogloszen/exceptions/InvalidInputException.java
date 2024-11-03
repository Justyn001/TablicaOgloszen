package pl.polsl.justyn.rojkowski.tablicaogloszen.exceptions;

/**
 * Custom exception to handle invalid inputs (e.g., invalid index).
 *
 * @version 1.0
 * @author Justyn Rojkowski
 */
public class InvalidInputException extends Exception {

    /**
     * Constructs an InvalidInputException with a custom message.
     *
     * @param message the error message
     */
    public InvalidInputException(String message) {
        super(message);
    }
}