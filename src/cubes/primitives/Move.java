package cubes.primitives;

import singletons.Factory;

/**
 * A move on a regular cube
 * @author MD
 */
public class Move {

    private final Face face;
    private final int slice;
    private final Turn turn;

    /**
     * Default constructeur with random states
     * @param nbSlices The number of slices of the cube
     */
    public Move(int nbSlices) {
        this.face = Factory.i().makeRdFace();
        this.slice = Factory.i().getRdInt(1, nbSlices);
        this.turn = Factory.i().makeRdTurn();
    }

    @Override public String toString() {
        return slice + "" + turn;
    }
}
