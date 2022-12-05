package exceptions.cubes;

import exceptions.BigCubeScramblerException;

/**
 * Exception thrown when attempting to instanciate a BigCube with not enough slices
 * @author MD
 */
public class IncorrectNumberOfSlicesException
extends BigCubeScramblerException {

    /**
     * Default constructeur with the error message
     */
    public IncorrectNumberOfSlicesException() {
        super("Error : The minimum number of slices is 5");
    }
}
