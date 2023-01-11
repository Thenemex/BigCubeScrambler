package singletons;

import cubes.primitives.Face;
import cubes.primitives.Turn;
import exceptions.cubes.IncorrectNumberOfSlicesException;

import java.io.File;
import java.util.Random;

/**
 * A singleton making random object's states for the application
 */
public class Factory {

    private static final Factory instance = new Factory();
    private final Random rd = new Random();

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
     * @throws IncorrectNumberOfSlicesException nbSlices must be equal or higher than 8
     */
    public int getScrambleLength(int nbSlices) {
        if (nbSlices < 8) throw new IncorrectNumberOfSlicesException();
        return 100 + (nbSlices - 8) * 10;
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

    /**
     * Create the output folder if it doesn't exist
     * @return The folder's name
     */
    public String getOutputDir() {
        String out = "output/";
        new File(out).mkdirs();
        return out;
    }

}
