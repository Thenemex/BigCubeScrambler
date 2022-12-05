package scramble;

import cubes.RegularBigCube;
import cubes.primitives.Move;
import singletons.Factory;

/**
 * A scramble generator
 */
public class Scramble {

    protected final RegularBigCube cube;
    protected Move[] moves;

    /**
     * Default constructor with the cube it's linked to
     * Also generate the scrambler on instanciation
     * @param cube The cube
     */
    public Scramble(RegularBigCube cube) {
        this.cube = cube;
        this.moves = new Move[Factory.i().getScrambleLength(cube.getNbSlices() / 2)];
    }
}
