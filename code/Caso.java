import java.io.*;
import java.util.*;

public class Caso{
    private String linha;
    private ArrayList<String[]> lista = new ArrayList<>();

    public Caso(int caso){
        switch (caso){
        case 0:
            try(BufferedReader data = new BufferedReader(new FileReader("casos\\caso0050.txt"))){
                while((linha = data.readLine()) != null){
                    String[] itensLinha = linha.replaceAll("\\D+"," ").split(" ");
                    lista.add(itensLinha);
                }
            }catch(Exception e){
                System.out.println(e);
            }
            break;
        case 1:
            try(BufferedReader data = new BufferedReader(new FileReader("casos\\caso0100.txt"))){
                while((linha = data.readLine()) != null){
                    String[] itensLinha = linha.replaceAll("\\D+"," ").split(" ");
                    lista.add(itensLinha);
                }
            }catch(Exception e){
                System.out.println(e);
            }
            break;
        case 2:
            try(BufferedReader data = new BufferedReader(new FileReader("casos\\caso0200.txt"))){
                while((linha = data.readLine()) != null){
                    String[] itensLinha = linha.replaceAll("\\D+"," ").split(" ");
                    lista.add(itensLinha);
                }
            }catch(Exception e){
                System.out.println(e);
            }
            break;
        case 3:
            try(BufferedReader data = new BufferedReader(new FileReader("casos\\caso0400.txt"))){
                while((linha = data.readLine()) != null){
                    String[] itensLinha = linha.replaceAll("\\D+"," ").split(" ");
                    lista.add(itensLinha);
                }
            }catch(Exception e){
                System.out.println(e);
            }
            break;
        case 4:
            try(BufferedReader data = new BufferedReader(new FileReader("casos\\caso0600.txt"))){
                while((linha = data.readLine()) != null){
                    String[] itensLinha = linha.replaceAll("\\D+"," ").split(" ");
                    lista.add(itensLinha);
                }
            }catch(Exception e){
                System.out.println(e);
            }
            break;
        case 5:
            try(BufferedReader data = new BufferedReader(new FileReader("casos\\caso0800.txt"))){
                while((linha = data.readLine()) != null){
                    String[] itensLinha = linha.replaceAll("\\D+"," ").split(" ");
                    lista.add(itensLinha);
                }
            }catch(Exception e){
                System.out.println(e);
            }
            break;
        case 6:
            try(BufferedReader data = new BufferedReader(new FileReader("casos\\caso0900.txt"))){
                while((linha = data.readLine()) != null){
                    String[] itensLinha = linha.replaceAll("\\D+"," ").split(" ");
                    lista.add(itensLinha);
                }
            }catch(Exception e){
                System.out.println(e);
            }
            break;
        case 7:
            try(BufferedReader data = new BufferedReader(new FileReader("casos\\caso1000.txt"))){
                while((linha = data.readLine()) != null){
                    String[] itensLinha = linha.replaceAll("\\D+"," ").split(" ");
                    lista.add(itensLinha);
                }
            }catch(Exception e){
                System.out.println(e);
            }
            break;
        }
    }

    public ArrayList<ArrayList<Integer>> getComandosAux(){
        ArrayList<ArrayList<Integer>> linhas = new ArrayList<>();
        for(int i = 0; i < lista.size(); i++){
            String[] str = lista.get(i);
            ArrayList<Integer> comandos = new ArrayList<>();
            for(int j = 0; j < str.length; j++){
                if(str[j]!=""){
                   comandos.add(Integer.parseInt(str[j]));
                }
            }
            linhas.add(comandos);
        }
        return linhas;
    }

    public ArrayList<ArrayList<Integer>> getComandos(){
        ArrayList<ArrayList<Integer>> linhasAux = getComandosAux();
        ArrayList<ArrayList<Integer>> linhas = new ArrayList<>();
        for(int i = 1; i < linhasAux.size(); i++){
            int par = 0;
            for(int j = 4; j < linhasAux.get(i).size(); j++){
                if(linhasAux.get(i).get(j) != 0){
                    if(linhasAux.get(i).get(j) % 2 == 0){
                        par++;
                    }
                }
            }
            ArrayList<Integer> macaco = new ArrayList<>();
            for(int j = 0; j < 4; j++){
                macaco.add(linhasAux.get(i).get(j));
            }
            macaco.add(par);
            macaco.add(macaco.get(3)-par);
            linhas.add(macaco);
        }
        return linhas;
    }
}