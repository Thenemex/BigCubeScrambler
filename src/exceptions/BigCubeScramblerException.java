package exceptions;

/**
 * Exception responsive for all the exceptions thrown in the application
 */
public class BigCubeScramblerException
extends RuntimeException {

    /**
     * Default constructeur with the error message
     * @param message The message
     */
    protected BigCubeScramblerException(String message) {
        super(message);
    }
}
