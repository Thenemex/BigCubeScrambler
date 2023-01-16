package cubes;

import exceptions.cubes.IncorrectNumberOfSlicesException;
import exceptions.cubes.ScrambleNotGeneratedException;
import exceptions.files.FileException;
import scramble.Scramble;
import singletons.Factory;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * A regular big cube of the factor NxNxN, with n >= 8 the number of slices.
 */
public class RegularBigCube {

    private final int nbSlices;
    private final Scramble scramble;

    /**
     * Constructor with the number of slices of the cube
     * NB : The scramble isn't generated after init
     * @param nbSlices The slices
     * @throws IncorrectNumberOfSlicesException nSlices must be equals or higher than 8
     */
    public RegularBigCube(int nbSlices) {
        if (nbSlices < 8) throw new IncorrectNumberOfSlicesException();
        this.nbSlices = nbSlices;
        this.scramble = new Scramble(nbSlices);
    }

    /**
     * Returns the general expression of the cube (NxNxN)
     * @return The expression
     */
    public String getExpression() {
        return nbSlices + "x" + nbSlices + "x" + nbSlices + "\n";
    }

    /**
     * Generate a new scramble
     */
    public void scramble() {
        scramble.generate();
    }

    /**
     * Write the scramble to the file
     * NB: No ".txt" needed, only the short filename
     * @param nbScrambles The number of scrambles
     * @param fileName The file's name
     * @throws FileException Problems with the file
     * @throws ScrambleNotGeneratedException The scramble isn't generated
     */
    public void writeScramble(int nbScrambles, String fileName) throws FileException {
        if (scramble.isNotGenerated()) throw new ScrambleNotGeneratedException();
        File file = new File(Factory.i().getOutputDir() + fileName + ".txt");
        if (file.exists()) throw new FileException("The file already exists");
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(getExpression());
            for (int i = 1; i <= nbScrambles; i++) {
                writer.write("(" + i + ".) :  ");
                writer.write(toString());
                writer.write("\n\n");
                scramble();
            }
            writer.close();
        } catch (IOException ioe) {
            throw new FileException("Problem with the filename's syntax");
        }
    }

    @Override public String toString() {
        if (scramble.isNotGenerated()) throw new ScrambleNotGeneratedException();
        return scramble.toString();
    }
}
