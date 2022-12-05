package scramble;

import cubes.RegularBigCube;
import cubes.primitives.Move;
import singletons.Factory;

import java.util.Arrays;

/**
 * A scramble generator
 */
public class Scramble {

    protected final RegularBigCube cube;
    protected final Move[] moves;

    /**
     * Default constructor with the cube it's linked to
     * Also generate the scramble on instanciation
     * @param cube The cube
     */
    public Scramble(RegularBigCube cube) {
        this.cube = cube;
        this.moves = new Move[Factory.i().getScrambleLength(cube.getHalfSlices())];
        generate();
    }

    /**
     * Fill the scramble with random moves
     */
    public void generate() {
        Arrays.setAll(moves, i -> new Move(cube.getHalfSlices()));
    }

    @Override public String toString() {
        return Arrays.toString(moves);
    }
}
