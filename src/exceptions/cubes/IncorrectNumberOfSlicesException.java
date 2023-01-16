package exceptions.cubes;

import exceptions.BigCubeScramblerException;

/**
 * Exception thrown when attempting to instanciate a BigCube with not enough slices
 */
public class IncorrectNumberOfSlicesException
extends BigCubeScramblerException {

    /**
     * Default constructeur with the error message
     */
    public IncorrectNumberOfSlicesException() {
        super("Error : The number of slices must be between 8 and 10000");
    }
}
