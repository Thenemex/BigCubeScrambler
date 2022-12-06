package cubes.primitives;

import exceptions.conversions.InvalidConversionException;

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
        switch (match) {
            case 1 : return U;
            case 2 : return F;
            case 3 : return R;
            case 4 : return B;
            case 5 : return L;
            case 6 : return D;
            default: throw new InvalidConversionException();
        }
    }

    @Override public String toString() {
        return print;
    }
}
