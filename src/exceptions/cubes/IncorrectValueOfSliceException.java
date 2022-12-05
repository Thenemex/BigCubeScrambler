package exceptions.cubes;

import exceptions.BigCubeScramblerException;

/**
 * Exception thrown when attempting to instanciate a slice with an incorrect number
 * @author MD
 */
public class IncorrectValueOfSliceException
extends BigCubeScramblerException {

    /**
     * Default constructeur with the error message
     */
    public IncorrectValueOfSliceException() {
        super("Error : The minimum value of slice is 1");
    }
}
