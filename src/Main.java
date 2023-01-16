import cubes.RegularBigCube;
import dialog.DialogTerminal;
import exceptions.files.FileException;

/**
 * Client class for the application
 */
public class Main {
    public static void main(String[] args) {
        DialogTerminal t = new DialogTerminal();
        RegularBigCube cube = new RegularBigCube(t.askNbSlices());
        try {
            cube.scramble();
            cube.writeScramble(t.askNbScrambles(), t.askFileName());
            t.print("Success");
        } catch (FileException fe) {
            t.print(fe.getMessage());
        }
        t.print("");
    }
}
