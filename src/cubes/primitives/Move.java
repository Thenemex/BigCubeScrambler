package cubes.primitives;

import singletons.Factory;

import java.util.Objects;

/**
 * A move on a regular cube
 * @author MD
 */
public class Move {

    private final int slice;
    private final Face face;
    private final String expression;

    /**
     * Default constructeur with random states
     * @param nbHalfSlices The half-slices of the cube
     * @param isEvenLayered True if the number of layers of the cube are even
     */
    public Move(int nbHalfSlices, boolean isEvenLayered) {
        this.slice = Factory.i().getRandomInt(1, nbHalfSlices);
        if (slice == nbHalfSlices && isEvenLayered) this.face = Factory.i().makeRandomFRUFace();
        else this.face = Factory.i().makeRandomFace();
        Turn turn = Factory.i().makeRandomTurn();
        expression = (slice == 1) ? "" + face + turn : (slice == 2) ? face + "w" + turn : "" + slice + face + "w" + turn;
    }

    /**
     * Getter for the face
     * @return The face
     */
    private Face getFace() {
        return face;
    }
    /**
     * Getter for the slice number
     * @return The slice
     */
    private int getSlice() {
        return slice;
    }

    /**
     * Shows if a move got the same face but different slice from another move
     * @param move The another move
     * @return True if Face are equal and Slice not equal.
     */
    public boolean isSameFaceOnly(Move move) {
        return getFace() == move.getFace() && getSlice() != move.getSlice();
    }

    /**
     * Shows if a Move got the same Face and Slice with the argument
     * (Regardless of the Turn in the expression
     * @param o Another move
     * @return True if Face and Slice are the sames
     */
    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Move)) return false;
        Move move = (Move) o;
        return getSlice() == move.getSlice() && getFace() == move.getFace();
    }
    @Override public int hashCode() {
        return Objects.hash(getFace(), getSlice());
    }
    @Override public String toString() {
        return expression;
    }
}
