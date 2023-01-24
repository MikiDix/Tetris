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

    static void MostrarMoviments(String[][] moviments, int files, int columnes) {

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j <= columnes + 1; j++) {
                System.out.print(moviments[i][j]);
            }
            System.out.println();
        }
    }

    static void MostrarTaulell(String[][] taulell, int files, int columnes) {

        for (int i = 0; i <= files; i++) {
            for (int j = 0; j <= columnes + 1; j++) {
                System.out.print(taulell[i][j]);
            }
            System.out.println();
        }
    }

    static void ImprimirPeca(int peca, String[][] moviments, String[][] taulell, int files, int columnes, int meitat) {

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

        TetrisFuncions.MostrarMoviments(moviments, files, columnes);
        TetrisFuncions.MostrarTaulell(taulell, files, columnes);

    }

    static int MourePeca(int peca, String[][] moviments, String[][] taulell, int meitat, int files, int columnes) {

        Scanner s = new Scanner(System.in);
        String resposta;

        do {
            System.out.println("Vols moure la peça? (Dreta='a' i Esquerra='d'");
            System.out.println("Per baixar la peça: 's'");
            resposta = s.nextLine();

            if ("a".equals(resposta)) {
                meitat--;
                moviments = CrearMoviments(columnes);
                ImprimirPeca(peca, moviments, taulell, files, columnes, meitat);
            } else if ("d".equals(resposta)) {
                meitat++;
                moviments = CrearMoviments(columnes);
                ImprimirPeca(peca, moviments, taulell, files, columnes, meitat);
            }

        } while (!"s".equals(resposta));
        
        return meitat;

    }

    static String[][] BaixarPeca(int peca, int meitat, int files, int columnes, String[][] taulell) {

        int fila = 0;

        switch (peca) {
            case 1:
                for (int i = 0; taulell[i + 1][meitat].equals(BUIDA) && taulell[i + 1][meitat + 1].equals(BUIDA); i++) {
                    fila = i;
                }
                for (int i = 0; i < files; i++) {
                    for (int j = 1; j <= columnes; j++) {
                        if ((i == fila && j == meitat) || (i == fila && j == meitat + 1) || (i == fila - 1 && j == meitat) || (i == fila - 1 && j == meitat + 1)) {
                            taulell[i][j] = PLENA;
                        }
                    }
                }
                break;
            case 2:
                for (int i = 0; taulell[i + 1][meitat].equals(BUIDA) && taulell[i + 1][meitat + 1].equals(BUIDA) && taulell[i + 1][meitat + 2].equals(BUIDA); i++) {
                    fila = i;
                }
                for (int i = 0; i < files; i++) {
                    for (int j = 1; j <= columnes; j++) {
                        if ((i == fila && j == meitat) || (i == fila && j == meitat + 1) || (i == fila && j == meitat + 2) || (i == fila - 1 && j == meitat)) {
                            taulell[i][j] = PLENA;
                        }
                    }
                }
                break;
            case 3:
                for (int i = 0; taulell[i + 1][meitat].equals(BUIDA) && taulell[i + 1][meitat + 1].equals(BUIDA); i++) {
                    fila = i;
                }
                for (int i = 0; i < files; i++) {
                    for (int j = 1; j <= columnes; j++) {
                        if ((i == fila && j == meitat) || (i == fila && j == meitat + 1) || (i == fila - 1 && j == meitat + 1) || (i == fila - 2 && j == meitat + 1)) {
                            taulell[i][j] = PLENA;
                        }
                    }
                }
                break;
            case 4:
                for (int i = 0; taulell[i + 1][meitat].equals(BUIDA); i++) {
                    fila = i;
                }
                for (int i = 0; i < files; i++) {
                    for (int j = 1; j <= columnes; j++) {
                        if ((i == fila && j == meitat) || (i == fila - 1 && j == meitat) || (i == fila - 2 && j == meitat) || (i == fila - 3 && j == meitat)) {
                            taulell[i][j] = PLENA;
                        }
                    }
                }
                break;

        }
        return taulell;
    }

    static void BorrarLinia(String[][] taulell, int files, int columnes) {

        int contador = 0, fila = 0;

        for (int i = 0; i <= files; i++) {
            for (int j = 1; j <= columnes; j++) {
                if (taulell[i][j].equals(PLENA)) {
                    contador++;
                    if (contador == columnes) {
                        for (int k = 1; k <= columnes; k++) {
                            taulell[i][k] = BUIDA;
                            fila = i;
                        }
                        for (int t = 1; t < fila; t++) {
                            for (int k = 0; k <= columnes + 1; k++) {
                                taulell[t - 1][k] = taulell[t][k];
                            }
                        }
                    }
                }
            }

        }

    }

    static boolean ComprovarFinal(String[][] taulell, int meitat) {

        boolean comprovacio = false;

        if (taulell[0][meitat].equals(PLENA)) {
            comprovacio = true;
        }

        return comprovacio;
    }

}
