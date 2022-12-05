package exceptions.conversions;

import exceptions.BigCubeScramblerException;

/**
 * Exception thrown when attempting to convert an incorrect match to an object
 * @author MD
 */
public class InvalidConversionException
extends BigCubeScramblerException {

    /**
     * Default constructeur with the error message
     */
    public InvalidConversionException() {
        super("The value of the match is incorrect");
    }
}
