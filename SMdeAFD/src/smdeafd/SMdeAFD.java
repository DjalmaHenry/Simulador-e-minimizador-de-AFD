package smdeafd;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SMdeAFD {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        String arquivo = "C:\\Users\\djalm\\Documents\\GitHub\\Simulador-e-minimizador-de-AFD\\AFD\\dados.txt";
        BufferedReader buffer = new BufferedReader(new FileReader(arquivo));
        String linha = buffer.readLine();
        while (linha != null) {
            System.out.println(linha);
            linha = buffer.readLine();
        }
    }

}
