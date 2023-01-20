/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tetris;



public class TetrisFuncions {
    
    final static String PARET = "|";
    final static String TERRA = "_";
    final static String BUIDA ="";
    
    static String[][] CrearTaulell(int columnes, int files){
        
        String[][] taulell = new String[columnes+2][files+6];
        
        for(int i=0; i<columnes+2; i++){
            for(int j=0; j<files+6; j++){
                if(i==0 || i==columnes+2){
                    taulell[i][j].equals(PARET);
                }
                else if(j==files+6 || j==4){
                    taulell[i][j].equals(TERRA);
                }
                else{
                    taulell[i][j].equals(BUIDA);
                }
            }
        }
        
        return taulell;
    }
    
    static void MostrarTaulell(String[][] taulell){
        for(int i=0; i<columnes+2; i++){
            for (int j=0; j<files+6; j++){
                System.out.println(taulell[i][j]);
            }
            System.out.println("");
        }
    }
    
    
}
