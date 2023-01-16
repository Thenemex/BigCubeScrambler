package exceptions.cubes;

import exceptions.BigCubeScramblerException;

/**
 * Exception thrown when attempting to instanciate a BigCube with not enough slices
 * @author MD
 */
public class IncorrectNumberOfScramblesException
extends BigCubeScramblerException {

    /**
     * Default constructeur with the error message
     */
    public IncorrectNumberOfScramblesException() {
        super("Error : The number of scrambles must be between 1 and 100");
    }
}
