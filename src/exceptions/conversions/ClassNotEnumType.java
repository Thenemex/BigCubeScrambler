package exceptions.conversions;

import exceptions.BigCubeScramblerException;

/**
 * Exception thrown when the incorrect class is given to IteratorEnum
 */
public class ClassNotEnumType
extends BigCubeScramblerException {

    /**
     * Default constructeur with the error message
     */
    public ClassNotEnumType() {
        super("Class does not match the Enum type");
    }
}
