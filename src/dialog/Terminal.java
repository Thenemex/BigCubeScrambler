package dialog;

import exceptions.cubes.IncorrectNumberOfSlicesException;

import java.util.Scanner;

/**
 * A class responsive for all the input/output on the terminal
 * @author MD
 */
public class Terminal {

    private final Scanner sc = new Scanner(System.in);
    protected final String initialQuestion = "A regular big cube is in the form \"NxNxN\", with N >= 8.\n - Type a number of slices : ";
    protected final String errorIntFormat = "Error : The string you typed is not a number";
    protected final String again = ". Type again : ";

    /**
     * Default constructor
     */
    public Terminal() {}

    /**
     * Print the question and ask the user to type a number
     * @return The number typed
     */
    public int askNumber() {
        System.out.print(initialQuestion);
        do try {
            int number = Integer.parseInt(sc.nextLine());
            if (number < 8) throw new IncorrectNumberOfSlicesException();
            return number;
        } catch (NumberFormatException nfe) {
            System.out.print(errorIntFormat + again);
        } catch (IncorrectNumberOfSlicesException inose) {
            System.out.print(inose.getMessage() + again);
        } while (true);
    }

    /**
     * Print the object to the terminal
     * @param o The object
     */
    public void print(Object o) {
        System.out.println("\n" + o);
    }
}
