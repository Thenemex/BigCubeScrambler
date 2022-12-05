package singletons;

import cubes.primitives.Face;
import cubes.primitives.Move;
import cubes.primitives.Turn;

import java.util.Random;

/**
 * A singleton making random object's states for the application
 */
public class Factory {

    protected static final Factory instance = new Factory();
    Random rd = new Random();
    private Move prevMove;

    /**
     * Default private constructor
     */
    private Factory() {}

    /**
     * Getter for the single instance of the factory
     * @return The singleton
     */
    public static Factory i() {
        return instance;
    }

    public Face makeRdFace() {
        int rand = getRdInt(1, 6);
        // ToDo
    }
    /**
     * Return a random number in [0..2]
     * 0 equals to -1/', 1 to 1/ , and 2 to 2/2.
     * @return A random turn
     */
    public Turn makeRdTurn() {
        int rand = getRdInt(0,2);
        if (rand == 0) return Turn.ANTICLOCKWISE;
        if (rand == 1) return Turn.CLOCKWISE;
        return Turn.DOUBLE;
    }

    /**
     * Return the scramble's length for the given slices number
     * @param nbSlices The slices
     * @return The scramble's length
     */
    public int getScrambleLength(int nbSlices) {
        if (nbSlices == 5) return 60;
        return 80 + (nbSlices - 6) * 10;
    }

    /**
     * Generate a random number in [a..b]
     * @param a lower bound (inclusive)
     * @param b Upper bound (inclusive)
     * @return The random number
     */
    public int getRdInt(int a, int b) {
        return rd.nextInt(a + 1 - b) + a;
    }

}
