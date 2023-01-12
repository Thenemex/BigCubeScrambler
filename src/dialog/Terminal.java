package dialog;

import exceptions.cubes.IncorrectNumberOfSlicesException;
import exceptions.files.FileException;
import singletons.Factory;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * A class responsive for all the input/output on the terminal
 * @author MD
 */
public class Terminal {

    private final Scanner sc = new Scanner(System.in);

    /**
     * Default constructor
     */
    public Terminal() {}

    /**
     * Print the question and ask the user to type a number of slices
     * @return The number of slices typed
     */
    public int askNbSlices() {
        String again = ". Type again : ";
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
     * Print the question and ask the user to type a filename
     * @return The file's name
     */
    public String askFileName() {
        System.out.print(" - Type a filename to write the scramble to : ");
        return sc.nextLine();
    }

    /**
     * Print the object to the terminal
     * @param o The object
     */
    public void print(Object o) {
        System.out.println("\n" + o);
    }

    /**
     * Write the text to the file
     * @param text The text
     * @param fileName The file's name
     * @throws FileException Problems with the file
     */
    public void writeTo(String text, String fileName) throws FileException {
        File file = new File(Factory.i().getOutputDir() + fileName);
        if (file.exists()) throw new FileException("The file already exists");
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(text);
            writer.newLine();
            writer.close();
        } catch (IOException ioe) {
            throw new FileException(ioe.getMessage());
        } System.out.println("Success !");
    }
}
