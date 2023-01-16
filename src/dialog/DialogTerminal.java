package dialog;

import exceptions.cubes.IncorrectNumberOfScramblesException;
import exceptions.cubes.IncorrectNumberOfSlicesException;

import java.util.Scanner;

/**
 * A class responsive for all the input/output on the terminal
 */
public class DialogTerminal {

    private final Scanner sc = new Scanner(System.in);
    private final String again = ". Type again : ";

    /**
     * Default constructor
     */
    public DialogTerminal() {}

    /**
     * Prints the question and ask the user to type a number of slices
     * NB : Contract, the output value is a correct number within [8..10000]
     * @return The number of slices typed
     */
    public int askNbSlices() {
        System.out.print("A regular big cube is in the form \"NxNxN\", with N >= 8.\n - Type a number of slices : ");
        do try {
                int number = Integer.parseInt(sc.nextLine());
                if (number < 8 || number > 10000) throw new IncorrectNumberOfSlicesException();
                return number;
            } catch (NumberFormatException nfe) {
                System.out.print("Error : The string you typed is not a number" + again);
            } catch (IncorrectNumberOfSlicesException inose) {
                System.out.print(inose.getMessage() + again);
        } while (true);
    }
    /**
     * Prints the question and ask the user to type a filename
     * @return The file's name
     */
    public String askFileName() {
        System.out.print(" - Type a filename to write the scramble(s) to (without the \".txt\") : ");
        return sc.nextLine();
    }
    /**
     * Prints the question and ask the user to type a number of scrambles
     * NB : Contract, the output value is a correct number within [1..100]
     * @return The number of scrambles
     */
    public int askNbScrambles() {
        System.out.print(" - Type the number of scrambles you want to generate : ");
        do try {
                int number = Integer.parseInt(sc.nextLine());
                if (number < 1 || number > 100) throw new IncorrectNumberOfScramblesException();
                return number;
            } catch (NumberFormatException nfe) {
                System.out.print("Error : The string you typed is not a number" + again);
            } catch (IncorrectNumberOfScramblesException inose) {
                System.out.print(inose.getMessage() + again);
        } while (true);
    }

    /**
     * Print the object to the terminal
     * @param o The object
     */
    public void print(Object o) {
        System.out.println(o);
    }
}
