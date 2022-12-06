package cubes.primitives;

import singletons.Factory;

/**
 * A move on a regular cube
 * @author MD
 */
public class Move {

    protected final Face face;
    protected final int slice;
    private final String expression;

    /**
     * Default constructeur with random states
     * @param nbHalfSlices The half-slices of the cube
     */
    public Move(int nbHalfSlices) {
        this.face = Factory.i().makeRdFace();
        this.slice = Factory.i().getRdInt(1, nbHalfSlices);
        Turn turn = Factory.i().makeRdTurn();
        switch (slice) {
            case 1 : expression = "" + face + turn; break;
            case 2 : expression = face + "w" + turn; break;
            default: expression = "" + slice + face + "w" + turn; break;
        }
    }

    /**
     * Getter for the face
     * @return The face
     */
    public Face getFace() {
        return face;
    }
    /**
     * Getter for the slice number
     * @return The slice
     */
    public int getSlice() {
        return slice;
    }

    @Override public String toString() {
        return expression;
    }
}
