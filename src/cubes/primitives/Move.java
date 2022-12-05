package cubes.primitives;

import exceptions.cubes.IncorrectNumberOfSlicesException;
import singletons.Factory;

/**
 * A move on a regular cube
 * @author MD
 */
public class Move {

    private final String expression;

    /**
     * Default constructeur with random states
     * @param nbSlices The number of slices of the cube
     * @throws IncorrectNumberOfSlicesException nbSlices must be equals or higher than 5
     */
    public Move(int nbSlices) {
        Face face = Factory.i().makeRdFace();
        int slice = Factory.i().getRdInt(1, nbSlices);
        Turn turn = Factory.i().makeRdTurn();
        switch (slice) {
            case 1 : expression = "" + face + turn; break;
            case 2 : expression = face + "w" + turn; break;
            default: expression = "" + slice + face + "w" + turn; break;
        }
    }

    @Override public String toString() {
        return expression;
    }
}
