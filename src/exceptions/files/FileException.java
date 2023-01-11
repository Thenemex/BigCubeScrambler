package exceptions.files;

import exceptions.BigCubeScramblerException;

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
