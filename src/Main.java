import cubes.RegularBigCube;
import dialog.Terminal;
import exceptions.files.FileException;

public class Main {
    public static void main(String[] args) {
        Terminal t = new Terminal();
        RegularBigCube cube = new RegularBigCube(t.askNbSlices());
        try {
            t.writeTo(cube.toString(), t.askFileName());
        } catch (FileException fe) {
            t.print(fe.getMessage());
        }
    }
}
