package iterators;

import cubes.primitives.Turn;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * An Iterator on all the turns
 */
public class IteratorTurns
implements Iterator<Turn> {

    private final Turn[] turns = new Turn[] {Turn.ANTICLOCKWISE, Turn.CLOCKWISE, Turn.DOUBLE};
    private int index = -1;

    public IteratorTurns() {}

    @Override public boolean hasNext() {
        return index + 1 >= turns.length;
    }
    @Override public Turn next() {
        if (++index >= turns.length) throw new NoSuchElementException("End of iterator reached");
        return turns[index];
    }
}
