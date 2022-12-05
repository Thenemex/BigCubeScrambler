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
    private final Random rd = new Random();
    private Move prevMove; // ToDo No repetitive moves

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

    /**
     * Returns a random face
     * @return A face
     */
    public Face makeRdFace() {
        return Face.toFace(getRdInt(1,6));
    }
    /**
     * Returns a random turn
     * @return A turn
     */
    public Turn makeRdTurn() {
        return Turn.toTurn(getRdInt(0,2));
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
        return rd.nextInt(b + 1 - a) + a;
    }

}
