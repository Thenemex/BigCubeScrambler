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
    private Move prevMove;

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
        Move move = new Move(cube.getHalfSlices());
        moves[0] = move;
        prevMove = moves[0];
        for (int i = 1; i < moves.length; i++) {
            do move = new Move(cube.getHalfSlices());
            while (isIncorrect(move));
            moves[i] = move;
            prevMove = move;
        }
    }

    /**
     * Shows if the move is incorrect in the current context
     * Contains the main condition for moves in the scramble
     * @param move The move
     * @return True if the move is incorrect
     * ToDo Improve to all slices possibilities
     */
    public boolean isIncorrect(Move move) {
        return move.getFace().equals(prevMove.getFace())
                && move.getSlice() == prevMove.getSlice();
    }

    @Override public String toString() {
        return Arrays.toString(moves);
    }
}
