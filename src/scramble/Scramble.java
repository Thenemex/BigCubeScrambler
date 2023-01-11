package scramble;

import cubes.RegularBigCube;
import cubes.primitives.Move;
import iterators.IteratorScramble;
import singletons.Factory;

import java.util.HashSet;
import java.util.Iterator;

/**
 * A scramble generator
 */
public class Scramble
implements Iterable<Move>{

    private final int halfSlices;
    private final Move[] moves;
    private final HashSet<Move> prevMoves;

    /**
     * Default constructor with the cube it's linked to
     * Also generate the scramble on instanciation
     * @param cube The cube
     */
    public Scramble(RegularBigCube cube) {
        this.halfSlices = cube.getNbSlices() / 2;
        this.moves = new Move[Factory.i().getScrambleLength(cube.getNbSlices())];
        this.prevMoves = new HashSet<>(cube.getNbSlices() / 2 ,1);
        generate();
    }

    /**
     * Fill the scramble with random moves
     */
    private void generate() {
        Move move = new Move(halfSlices);
        moves[0] = move;
        prevMoves.clear();
        prevMoves.add(move);
        for (int i = 1; i < moves.length; i++) {
            do move = new Move(halfSlices);
            while (isIncorrect(move));
            moves[i] = move;
        }
    }

    /**
     * Shows if the move is incorrect in the current context compared to the previous moves
     * Contains the main condition for moves in the scramble
     * @param move The move
     * @return True if the move is incorrect
     * ToDo Improve to all slices possibilities
     */
    private boolean isIncorrect(Move move) {
        boolean sameAll = false, sameFace = true;
        for (Move m : prevMoves) {
            sameAll |= move.equals(m);
            sameFace &= move.isSameFaceOnly(m);
        }
        // same Face and same Slice -> incorrect
        if (sameAll) return true;
        // same Face but different Slice -> correct
        if (sameFace) {
            prevMoves.add(move);
            return false;
        }
        prevMoves.clear();
        prevMoves.add(move);
        return false;
    }

    @Override public Iterator<Move> iterator() {
        return new IteratorScramble(moves);
    }
    @Override public String toString() {
        StringBuilder sb = new StringBuilder(5 * moves.length);
        for (Move m : this)
            sb.append(" ").append(m);
        sb.replace(0, 1, "");
        return sb.toString();
    }


}
