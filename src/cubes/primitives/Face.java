package cubes.primitives;

import exceptions.conversions.InvalidConversionException;
import iterators.IteratorEnum;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * An enum for all the faces of a regular cube
 */
public enum Face {
    U("U"),
    F("F"),
    R("R"),
    B("B"),
    L("L"),
    D("D");

    private final String print;

    /**
     * Private constructor
     * @param print The printed code
     */
    Face(String print) {
        this.print = print;
    }

    /**
     * Return the face linked to the number
     * @param match The number in [1..6]
     * @return The face
     * @throws InvalidConversionException The number is incorrect
     */
    public static Face toFace(int match) {
        Iterator<Object> ite = new IteratorEnum(Face.class);
        try { for (Face face = (Face) ite.next();; face = (Face) ite.next())
                  if (match-- == 1) return face;
        } catch (NoSuchElementException nsee) {
            throw new InvalidConversionException();
        }
    }

    @Override public String toString() {
        return print;
    }
}
