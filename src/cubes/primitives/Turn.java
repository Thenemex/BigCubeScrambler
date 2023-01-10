package cubes.primitives;

import exceptions.conversions.InvalidConversionException;
import iterators.IteratorEnum;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * An Enum for all the turns possibles on a given slice
 */
public enum Turn {
    ANTICLOCKWISE("'"),
    CLOCKWISE(""),
    DOUBLE("2");

    private final String print;

    /**
     * Private constructor
     * @param print The printed code
     */
    Turn(String print) {
        this.print = print;
    }

    /**
     * Return the turn linked to the number
     * @param match The number in [0..2]
     * @return The turn
     * @throws InvalidConversionException The number is incorrect
     */
    public static Turn toTurn(int match) {
        Iterator<Object> ite = new IteratorEnum(Turn.class);
        try { for (Turn turn = (Turn) ite.next();; turn = (Turn) ite.next())
                  if (match-- == 0) return turn;
        } catch (NoSuchElementException nsee) {
            throw new InvalidConversionException();
        }
    }

    @Override public String toString() {
        return print;
    }
}
