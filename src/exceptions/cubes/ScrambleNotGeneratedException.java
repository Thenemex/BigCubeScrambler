package exceptions.cubes;

import exceptions.BigCubeScramblerException;

/**
 * Exception thrown when attempting to perform an action with the scramble, that isn't generated yet
 */
public class ScrambleNotGeneratedException
extends BigCubeScramblerException {

    /**
     * Default constructeur with the error message
     */
    public ScrambleNotGeneratedException() {
        super("The scramble isn't generated");
    }
}
