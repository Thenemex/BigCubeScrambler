package exceptions.conversions;

import exceptions.BigCubeScramblerException;

public class ClassNotEnumType
extends BigCubeScramblerException {

    /**
     * Default constructeur with the error message
     */
    public ClassNotEnumType() {
        super("Class does not match the Enum type");
    }
}
