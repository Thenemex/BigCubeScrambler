import cubes.RegularBigCube;

public class Client {
    public static void main(String[] args) {
        RegularBigCube cube = new RegularBigCube(7);
        System.out.println(cube);
        System.out.println(cube.getScramble());
    }
}
