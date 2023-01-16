package exceptions.files;

import exceptions.BigCubeScramblerException;

/**
 * Exception thrown where there is a problem with the file input/output
 */
public class FileException
extends BigCubeScramblerException {

    /**
     * Default constructeur with the error message
     * @param message The message
     */
    public FileException(String message) {
        super(message);
    }
}
