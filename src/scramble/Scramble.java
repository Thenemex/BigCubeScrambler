package scramble;

import cubes.primitives.Move;
import iterators.IteratorScramble;
import singletons.Factory;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

/**
 * A scramble generator
 */
public class Scramble
implements Iterable<Move>{

    private final int halfSlices;
    private final boolean isEvenLayered;
    private final Move[] moves;
    private final HashSet<Move> prevMoves;

    /**
     * Default constructor with the number of slices of the cube
     * @param nbSlices The number of slices
     */
    public Scramble(int nbSlices) {
        this.halfSlices = nbSlices / 2;
        this.isEvenLayered = (nbSlices % 2) == 0;
        this.moves = new Move[Factory.i().getScrambleLength(nbSlices)];
        this.prevMoves = new HashSet<>(nbSlices / 2 ,1);
    }

    /**
     * Fill the scramble with random moves
     */
    public void generate() {
        Arrays.fill(moves, null); // Clearing the array of moves
        prevMoves.clear(); // Clearing the array of prev-moves
        Move move;
        for (int i = 0; i < moves.length; i++) {
            do move = new Move(halfSlices, isEvenLayered);
            while (isIncorrect(move));
            moves[i] = move;
        }
    }

    /**
     * Shows if the scramble has been generated or not
     * @return True if the scramble is generated
     */
    public boolean isNotGenerated() {
        return moves[0] == null;
    }
    /**
     * Shows if the move is incorrect in the current context compared to the previous moves
     * Contains the main condition for moves in the scramble
     * @param move The move
     * @return True if the move is incorrect
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
