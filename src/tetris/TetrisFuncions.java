/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tetris;

public class TetrisFuncions {

    final static String PARET = "|";
    final static String TERRA = "_";
    final static String BUIDA = " ";
    final static String PLENA = "X";

    static String[][] CrearTaulell(int files, int columnes) {

        String[][] taulell = new String[files + 6][columnes + 2];

        for (int i = 0; i < files + 6; i++) {
            for (int j = 0; j < columnes + 2; j++) {
                if (i == files + 5 || i == 4) {
                    taulell[i][j] = TERRA;
                } else if (j == 0 || j == columnes + 1) {
                    taulell[i][j] = PARET;
                } else {
                    taulell[i][j] = BUIDA;
                }
            }
        }
        return taulell;
    }

    static void MostrarTaulell(String[][] taulell, int files, int columnes) {
        for (int i = 0; i < files + 6; i++) {
            for (int j = 0; j < columnes + 2; j++) {
                System.out.print(taulell[i][j]);
            }
            System.out.println();
        }
    }

}
