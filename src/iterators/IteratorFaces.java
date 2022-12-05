package iterators;

import cubes.primitives.Face;
import cubes.primitives.Turn;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IteratorFaces
implements Iterator<Face> {

    private final Face[] faces =  new Face[] {Face.U, Face.F, Face.R, Face.B, Face.L, Face.D};
    private int index = -1;

    public IteratorFaces() {}

    @Override public boolean hasNext() {
        return index + 1 >= faces.length;
    }
    @Override public Face next() {
        if (++index >= faces.length) throw new NoSuchElementException("End of iterator reached");
        return faces[index];
    }
}
