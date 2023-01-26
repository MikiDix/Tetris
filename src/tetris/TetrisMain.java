package tetris;

import java.util.Scanner;

public class TetrisMain {

    //defim el numero de peces
    final static int PECES = 4;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        //definim les variables 
        int columnes = 0, files = 0, meitat = 0, peca;
        String[][] taulell, moviments;

        //demanem les files i les columnes per fer la matriu
        while (columnes < 5) {
            System.out.println("Quantes columnes vols que tingui el taulell?");
            columnes = s.nextInt();
        }
        while (files < 4) {
            System.out.println("Quantes files vols que tingui el taulell?");
            files = s.nextInt();
        }
        taulell = TetrisFuncions.CrearTaulell(files, columnes);
        moviments = TetrisFuncions.CrearMoviments(columnes);

        //fem el bucle fins que ComprovarFinal sigui true 
        while (TetrisFuncions.ComprovarFinal(taulell, meitat) == false) {

            //agafem les columnes i les dividim en 2 per centrar la peça
            //en cas de que sigui imparell, sumem 1 a les columnes i dividim entre 2
            if (columnes % 2 == 0) {
                meitat = columnes / 2;
            } else {
                meitat = (columnes + 1) / 2;
            }

            //generem la peça de forma aleatoria 
            peca = (int) (Math.random() * PECES + 1);
            //imprimir la peça 
            TetrisFuncions.ImprimirPeca(peca, moviments, taulell, files, columnes, meitat);
            //moure la peça
            meitat = TetrisFuncions.MourePeca(peca, moviments, taulell, meitat, files, columnes);
            //baixar la peça ja moguda 
            taulell = TetrisFuncions.BaixarPeca(peca, meitat, files, columnes, taulell);
            //borrar la linea si ja esta plena
            TetrisFuncions.BorrarLinia(taulell, files, columnes);
            //detecta la posicio final de la peça 
            moviments = TetrisFuncions.CrearMoviments(columnes);
        }

    }

}
