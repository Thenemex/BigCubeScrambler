import cubes.RegularBigCube;
import dialog.Terminal;

public class Main {
    public static void main(String[] args) {
        Terminal t = new Terminal();
        RegularBigCube cube = new RegularBigCube(t.askNumber());
        t.print(cube);
    }
}
