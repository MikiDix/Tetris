package tetris;

import java.util.Scanner;

public class TetrisMain {

    //defim el numero de peces
    final static int PECES = 4;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        //definim les variables 
        int columnes, files, meitat = 0, peca;
        String[][] taulell, moviments;

        //demanem les files i les columnes per fer la matriu
        System.out.println("Quantes columnes vols que tingui el taulell?");
        columnes = s.nextInt();
        System.out.println("Quantes files vols que tingui el taulell?");
        files = s.nextInt();

        taulell = TetrisFuncions.CrearTaulell(files, columnes);
        moviments = TetrisFuncions.CrearMoviments(columnes);

        //fem el bucle fins que ComprovarFinal sigui true 
        while (TetrisFuncions.ComprovarFinal(taulell, meitat) == false) {

            if (columnes % 2 == 0) {
                meitat = columnes / 2;
            } else {
                meitat = (columnes + 1) / 2;
            }

            peca = (int) (Math.random() * PECES + 1);
            TetrisFuncions.ImprimirPeca(peca, moviments, taulell, files, columnes, meitat);
            meitat = TetrisFuncions.MourePeca(peca, moviments, taulell, meitat, files, columnes);
            taulell = TetrisFuncions.BaixarPeca(peca, meitat, files, columnes, taulell);
            TetrisFuncions.BorrarLinia(taulell, files, columnes);
            moviments = TetrisFuncions.CrearMoviments(columnes);
        }

    }

}
