package cubes.primitives;

import iterators.IteratorFaces;

import java.util.Iterator;

public enum Face {
    U("U"),
    F("F"),
    R("R"),
    B("B"),
    L("L"),
    D("D");

    private String print;

    Face(String print) {
        this.print = print;
    }

    @Override public String toString() {
        return print;
    }

    public static Iterator<Face> getIterator() {
        return new IteratorFaces();
    }

}
