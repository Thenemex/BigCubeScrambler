package iterators;

import cubes.primitives.Face;

import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class IteratorFace
implements Iterator<Face> {

    protected final Field[] faces = Face.class.getFields();
    private int index = -1;

    public IteratorFace() {}

    @Override public boolean hasNext() {
        return index + 1 < faces.length;
    }
    @Override public Face next() {
        if (++index >= faces.length) throw new NoSuchElementException("End of iterator-face reached");
        try { return (Face) faces[index].get(this);
        // Catch never reached, because all enum object-fields are public
        } catch (IllegalAccessException ignored) { return null; }
    }
}
