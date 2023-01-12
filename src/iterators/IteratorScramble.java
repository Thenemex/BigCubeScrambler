package iterators;

import cubes.primitives.Move;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A simple iterator on an Object Array
 */
public class IteratorScramble
implements Iterator<Move> {

    private final Move[] moves;
    private int index = -1;

    public IteratorScramble(Move ... moves) {
        this.moves = new Move[moves.length];
        System.arraycopy(moves, 0, this.moves, 0, moves.length);
    }

    @Override public boolean hasNext() {
        return index + 1 < moves.length;
    }
    @Override public Move next() {
        if (++index >= moves.length) throw new NoSuchElementException("End of iterator-scramble reached");
        return moves[index];
    }
}
