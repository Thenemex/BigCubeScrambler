package exceptions;

/**
 * Exception responsive for all the exceptions thrown in the application
 * @author MD
 */
public class BigCubeScramblerException
extends RuntimeException {

    /**
     * Default constructeur with the error message
     * @param message The message
     */
    public BigCubeScramblerException(String message) {
        super(message);
    }
}
