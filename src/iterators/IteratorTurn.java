package iterators;

import cubes.primitives.Turn;

import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class IteratorTurn
implements Iterator<Turn> {

    protected final Field[] turns = Turn.class.getFields();
    private int index = -1;

    public IteratorTurn() {}

    @Override public boolean hasNext() {
        return index + 1 < turns.length;
    }
    @Override public Turn next() {
        if (++index >= turns.length) throw new NoSuchElementException("End of iterator-face reached");
        try { return (Turn) turns[index].get(this);
            // Catch never reached, because all enum object-fields are public
        } catch (IllegalAccessException ignored) { return null; }
    }
}
