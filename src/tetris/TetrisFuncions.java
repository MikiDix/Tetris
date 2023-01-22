package tetris;

import java.util.Scanner;

public class TetrisFuncions {

    final static String PARET = "|";
    final static String TERRA = "_";
    final static String BUIDA = " ";
    final static String PLENA = "X";

    static String[][] CrearTaulell(int files, int columnes) {

        String[][] taulell = new String[files + 6][columnes + 2];

        for (int i = 0; i <= files; i++) {
            for (int j = 0; j <= columnes + 1; j++) {
                if (i == files) {
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

    static String[][] CrearMoviments(int columnes) {

        String[][] moviments = new String[5][columnes + 2];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j <= columnes + 1; j++) {
                if (i == 4) {
                    moviments[i][j] = TERRA;
                } else if (j == 0 || j == columnes + 1) {
                    moviments[i][j] = PARET;
                } else {
                    moviments[i][j] = BUIDA;
                }
            }
        }

        return moviments;
    }

    static void MostrarMoviments(String[][] taulell, String[][] moviments, int files, int columnes) {

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j <= columnes + 1; j++) {
                System.out.print(moviments[i][j]);
            }
            System.out.println();
        }
    }

    static void MostrarTaulell(String[][] taulell, String[][] moviments, int files, int columnes) {

        for (int i = 0; i <= files; i++) {
            for (int j = 0; j <= columnes + 1; j++) {
                System.out.print(taulell[i][j]);
            }
            System.out.println();
        }
    }

    static void ImprimirPeca(int peca, String[][] moviments, int columnes) {

        int meitat;

        if (columnes % 2 == 0) {
            meitat = columnes / 2;
        } else {
            meitat = (columnes + 1) / 2;
        }

        switch (peca) {
            case 1:
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j <= columnes + 1; j++) {
                        if ((i == 2 && j == meitat) || (i == 2 && j == meitat + 1) || (i == 3 && j == meitat) || (i == 3 && j == meitat + 1)) {
                            moviments[i][j] = PLENA;
                        }
                    }
                }
                break;
            case 2:
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j <= columnes + 1; j++) {
                        if ((i == 2 && j == meitat) || (i == 3 && j == meitat) || (i == 3 && j == meitat + 1) || (i == 3 && j == meitat + 2)) {
                            moviments[i][j] = PLENA;
                        }
                    }
                }
                break;

            case 3:
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j <= columnes + 1; j++) {
                        if ((i == 2 && j == meitat + 1) || (i == 3 && j == meitat) || (i == 3 && j == meitat + 1 || (i == 1 && j == meitat + 1))) {
                            moviments[i][j] = PLENA;
                        }
                    }
                }
                break;

            case 4:
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j <= columnes + 1; j++) {
                        if ((i == 0 && j == meitat) || (i == 1 && j == meitat) || (i == 2 && j == meitat) || (i == 3 && j == meitat)) {
                            moviments[i][j] = PLENA;
                        }
                    }
                }
                break;
        }

        MourePeca(peca, moviments, meitat);

    }

    static void MourePeca(int peca, String[][] moviments, int meitat) {

        Scanner s = new Scanner(System.in);
        String resposta;

        do {
            System.out.println("Vols moure la peça? (Dreta='a' i Esquerra='d'");
            System.out.println("Per baixar la peça: 's'");
            resposta = s.nextLine();

            switch (resposta) {
                case "a":

            }
        } while (resposta != "s");
        BaixarPeca(moviments);
    }

    static String[][] BaixarPeca(String[][] moviments) {

        return moviments;
    }

}
