import java.util.*;

public class App{

    /*
        x,0 = n° do macaco
        x,1 = macaco alvo se for par
        x,2 = macaco alvo se for impar
        x,3 = quantidade de cocos total
        x,4 = quantidade de cocos pares
        x,5 = quantidade de cocos impares
    */

    public static void main(String[]args){
        Caso caso = new Caso(0);
        ArrayList<ArrayList<Integer>> linhas = caso.getComandos();
        int rodadas = linhas.size()*100;

        partida(linhas, rodadas);
        int[] vencedor = macacoVencedor(linhas);

        System.out.println("\nO macaco vencedor e o macaco numero "+vencedor[0]
                            +", com "+vencedor[1]+" cocos!\n");
    }

    public static void partida(ArrayList<ArrayList<Integer>> linhas, int rodadas){ // O(n²)
        for(int i = 0; i < rodadas; i++){
            for(int j = 0; j < linhas.size(); j++){
                if(linhas.get(j).get(3) != 0){
                    if(linhas.get(j).get(4) != 0){
                        int macacoAlvo = linhas.get(j).get(1);
                        linhas.get(macacoAlvo).set(3, linhas.get(macacoAlvo).get(3) // aumentando o numero de cocos no total
                                                            +linhas.get(j).get(4));
                        linhas.get(macacoAlvo).set(4, linhas.get(macacoAlvo).get(4) // aumentando o numero de cocos pares
                                                            +linhas.get(j).get(4));                                    
                        linhas.get(j).set(4, 0); // zerando o numero de cocos pares
                    }
                    if(linhas.get(j).get(5) != 0){
                        int macacoAlvo = linhas.get(j).get(2);
                        linhas.get(macacoAlvo).set(3, linhas.get(macacoAlvo).get(3) // aumentando o numero de cocos no total
                                                            +linhas.get(j).get(5));
                        linhas.get(macacoAlvo).set(5, linhas.get(macacoAlvo).get(5) // aumentando o numero de cocos pares
                                                            +linhas.get(j).get(5));  
                        linhas.get(j).set(5, 0); // zerando o numero de cocos impares
                    }
                    linhas.get(j).set(3, 0); // zerando o numero de cocos totais
                }
            }
        }
    }

    public static int[] macacoVencedor(ArrayList<ArrayList<Integer>> linhas){
        int macacoV = linhas.get(0).get(0);
        int qtddCocos = linhas.get(0).get(3);
        int[] vencedor = new int[2];
        for(int i = 1; i < linhas.size(); i++){
            if(linhas.get(i).get(3) > qtddCocos){
                macacoV = linhas.get(i).get(0);
                qtddCocos = linhas.get(i).get(3);
            }
        }
        vencedor[0] = macacoV;
        vencedor[1] = qtddCocos;
        return vencedor;
    }
}