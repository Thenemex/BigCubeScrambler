package cubes;

import exceptions.cubes.IncorrectNumberOfSlicesException;
import exceptions.files.FileException;
import scramble.Scramble;
import singletons.Factory;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * A regular big cube of the factor NxNxN, with n >= 8 the number of slices.
 * @author MD
 */
public class RegularBigCube {

    private final int nbSlices;
    private final Scramble scramble;

    /**
     * Constructor with the number of slices of the cube
     * @param nbSlices The slices
     * @throws IncorrectNumberOfSlicesException nSlices must be equals or higher than 8
     */
    public RegularBigCube(int nbSlices) {
        if (nbSlices < 8) throw new IncorrectNumberOfSlicesException();
        this.nbSlices = nbSlices;
        this.scramble = new Scramble(this);
    }

    /**
     * Getter for the number of slice of the cube
     * @return The number of slices
     */
    public int getNbSlices() {
        return nbSlices;
    }
    /**
     * Returns the general expression of the cube (NxNxN)
     * @return The expression
     */
    public String getExpression() {
        return nbSlices + "x" + nbSlices + "x" + nbSlices + "\n";
    }

    /**
     * Write the scramble to the file
     * NB: No ".txt" needed, only the short filename
     * @param nbScrambles The number of scrambles
     * @param fileName The file's name
     * @throws FileException Problems with the file
     */
    public void writeScramble(int nbScrambles, String fileName) throws FileException {
        File file = new File(Factory.i().getOutputDir() + fileName + ".txt");
        if (file.exists()) throw new FileException("The file already exists");
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(getExpression());
            writer.write(toString());
            writer.newLine();
            writer.close();
        } catch (IOException ioe) {
            throw new FileException(ioe.getMessage());
        }
    }

    @Override public String toString() {
        return scramble.toString();
    }
}
