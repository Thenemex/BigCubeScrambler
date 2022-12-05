package cubes;

import exceptions.cubes.IncorrectNumberOfSlicesException;
import scramble.Scramble;

/**
 * A regular big cube of the factor NxNxN, with n >= 5 the number of slices.
 * @author MD
 */
public class RegularBigCube {

    private final int nbSlices;
    protected Scramble scramble;

    /**
     * Constructor with the number of slices of the cube
     * @param nbSlices The slices
     * @throws IncorrectNumberOfSlicesException nSlices must be equals or higher than 5
     */
    public RegularBigCube(int nbSlices) {
        if (nbSlices < 5) throw new IncorrectNumberOfSlicesException();
        this.nbSlices = nbSlices;
        this.scramble = new Scramble(this);
    }

    /**
     * Getter for the number of slices
     * @return The slices
     */
    public int getNbSlices() {
        return nbSlices;
    }
}
