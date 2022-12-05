package cubes.primitives;

import iterators.IteratorTurns;

import java.util.Iterator;

public enum Turn {
    ANTICLOCKWISE(0, "\'"),
    CLOCKWISE(1, ""),
    DOUBLE(2, "2");

    private final String print;

    Turn(int turns, String print) {
        this.print = print;
    }

    @Override public String toString() {
        return print;
    }

    public static Iterator<Turn> getIterator() {
        return new IteratorTurns();
    }
}
