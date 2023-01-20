package tetris;

import java.util.Scanner;

public class TetrisMain {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        boolean repetir = true;
        int columnes, files;
        String[][] taulell;

        while (repetir == true) {
            System.out.println("Quantes columnes vols que tingui el taulell?");
            columnes = s.nextInt();
            System.out.println("Quantes files vols que tingui el taulell?");
            files = s.nextInt();

            taulell = TetrisFuncions.CrearTaulell(files, columnes);
            TetrisFuncions.MostrarTaulell(taulell, files, columnes);
        }

    }

}
