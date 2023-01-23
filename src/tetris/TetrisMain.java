package tetris;

import java.util.Scanner;

public class TetrisMain {

    final static int PECES = 4;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        boolean repetir = true;
        int columnes, files, meitat, peca;
        String[][] taulell, moviments;

        while (repetir == true && !TetrisFuncions.ComprovarFinal()) {
            System.out.println("Quantes columnes vols que tingui el taulell?");
            columnes = s.nextInt();
            System.out.println("Quantes files vols que tingui el taulell?");
            files = s.nextInt();

            taulell = TetrisFuncions.CrearTaulell(files, columnes);
            moviments = TetrisFuncions.CrearMoviments(columnes);

            if (columnes % 2 == 0) {
                meitat = columnes / 2;
            } else {
                meitat = (columnes + 1) / 2;
            }

            while (!TetrisFuncions.ComprovarFinal()) {
                peca = (int)(Math.random()*PECES+1);
                TetrisFuncions.ImprimirPeca(peca, moviments, taulell, files, columnes, meitat);
            }
        }

    }

}
