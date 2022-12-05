package cubes.primitives;

import exceptions.conversions.InvalidConversionException;

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

    @Override public String toString() {
        return print;
    }

    /**
     * Return the turn linked to the number
     * @param match The number in [0..2]
     * @return The turn
     * @throws InvalidConversionException The number is incorrect
     */
    public static Turn toTurn(int match) {
        switch (match) {
            case 0 : return ANTICLOCKWISE;
            case 1 : return CLOCKWISE;
            case 2 : return DOUBLE;
            default: throw new InvalidConversionException();
        }
    }
}
