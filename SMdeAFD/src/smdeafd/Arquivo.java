package smdeafd;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Arquivo {

    Scanner in = new Scanner(System.in);
    private int tamAlfabeto;
    private int qtdEstados;
    private int qtdEstadosFinais;

    public AFD instanciarArquivo() throws FileNotFoundException, IOException {
        String arquivo = "C:\\Users\\djalm\\Documents\\GitHub\\Simulador-e-minimizador-de-AFD\\AFD\\dados.txt";
        BufferedReader buffer = new BufferedReader(new FileReader(arquivo));
        String linha = buffer.readLine();
        this.tamAlfabeto = Integer.parseInt(linha);
        linha = buffer.readLine();
        this.qtdEstados = Integer.parseInt(linha);
        linha = buffer.readLine();
        this.qtdEstadosFinais = Integer.parseInt(linha);
        buffer.readLine();
        AFD afd = new AFD(tamAlfabeto, qtdEstados);
        return afd;
    }

    public void lerArquivo(AFD afd) throws FileNotFoundException, IOException {
        String arquivo = "C:\\Users\\djalm\\Documents\\GitHub\\Simulador-e-minimizador-de-AFD\\AFD\\dados.txt";
        BufferedReader buffer = new BufferedReader(new FileReader(arquivo));

        //achando onde parou
        String linha = buffer.readLine();
        while (linha.charAt(0) != '.') {
            linha = buffer.readLine();
        }

        //leitura do alfabeto
        linha = buffer.readLine();
        String[] alfabeto = new String[this.tamAlfabeto];
        for (int i = 0; linha.charAt(0) != '.'; i++) {
            alfabeto[i] = linha;
            linha = buffer.readLine();
        }
        afd.setAlfabeto(alfabeto);

        //leitura dos estados
        linha = buffer.readLine();
        String[] estados = new String[qtdEstados];
        for (int i = 0; linha.charAt(0) != '.'; i++) {
            estados[i] = linha;
            linha = buffer.readLine();
        }
        afd.setEstados(estados);

        //leitura do estado inicial
        linha = buffer.readLine();
        afd.setEstadoInicial(linha);
        buffer.readLine();

        //leitura dos estados finais
        linha = buffer.readLine();
        String[] estadosFinais = new String[this.qtdEstadosFinais];
        for (int i = 0; linha.charAt(0) != '.'; i++) {
            estadosFinais[i] = linha;
            linha = buffer.readLine();
        }

        //reconhecendo estados finais
        for (int i = 0; i < this.qtdEstados; i++) {
            for (int j = 0; j < this.qtdEstadosFinais; j++) {
                if (estados[i].compareTo(estadosFinais[j]) == 0) {
                    afd.setFinais(i);
                }
            }
        }

        //leitura das transições
        linha = buffer.readLine();
        String[][] transicoes = new String[this.tamAlfabeto][qtdEstados];
        for (int i = 0; linha.charAt(0) != '.'; i++) {

            //leitura do alfabeto da transição
            int contSimbolo = 0;
            for (int j = 0; linha.charAt(j) != ':'; j++) {
                contSimbolo++;
            }
            String simbolo = linha.substring(0, contSimbolo);
            int qtdAlfabeto = 0;
            //encontrando posição no vetor de alfabeto
            while (alfabeto[qtdAlfabeto].compareTo(simbolo) != 0) {
                qtdAlfabeto++;
            }

            //leitura do estado inicial
            int contInicio = 0;
            for (int j = 0; linha.charAt(j) != '-'; j++) {
                contInicio++;
            }
            String estadoInicio = linha.substring((contSimbolo + 1), contInicio);
            int qtdEstadoInicio = 0;
            //encontrando posição no vetor de estados
            while (estados[qtdEstadoInicio].compareTo(estadoInicio) != 0) {
                qtdEstadoInicio++;
            }

            //leitura do estado destino
            int contDestino = 0;
            for (int j = 0; linha.charAt(j) != ';'; j++) {
                contDestino++;
            }
            String estadoDestino = linha.substring((contInicio + 1), contDestino);

            //criando transição
            transicoes[qtdAlfabeto][qtdEstadoInicio] = estadoDestino;
            linha = buffer.readLine();
        }
        //setando transições
        afd.setTransicoes(transicoes);
    }

    public void saidaArquivo(AFD afd) throws IOException {
        String arquivo = "C:\\Users\\djalm\\Documents\\GitHub\\Simulador-e-minimizador-de-AFD\\AFD\\saida.txt";
        FileWriter saida = new FileWriter(arquivo);

        //saida da quantidade de simbolos, estados e estados finais
        String[] alfabeto = afd.getAlfabeto();
        int tam = alfabeto.length;
        String tamString = "" + tam;
        saida.write(tamString);
        saida.write("\n");
        String[] estados = afd.getEstados();
        tam = estados.length;
        tamString = "" + tam;
        saida.write(tamString);
        saida.write("\n");
        boolean[] finais = afd.getFinais();
        tam = 0;
        for (int i = 0; i < estados.length; i++) {
            if (finais[i] == true) {
                tam++;
            }
        }
        tamString = "" + tam;
        saida.write(tamString);
        saida.write("\n");

        saida.write(".");
        saida.write("\n");

        //saída do alfabeto
        for (int i = 0; i < alfabeto.length; i++) {
            saida.write(alfabeto[i]);
            saida.write("\n");
        }

        saida.write(".");
        saida.write("\n");

        //saída dos estados
        for (int i = 0; i < estados.length; i++) {
            saida.write(estados[i]);
            saida.write("\n");
        }

        saida.write(".");
        saida.write("\n");

        //saída do estado inicial
        String estadoInicial = afd.getEstadoInicial();
        saida.write(estadoInicial);
        saida.write("\n");

        saida.write(".");
        saida.write("\n");

        //saida dos estados finais
        for (int i = 0; i < estados.length; i++) {
            if (finais[i] == true) {
                saida.write(estados[i]);
                saida.write("\n");
            }
        }

        saida.write(".");
        saida.write("\n");

        String[][] transicoes = afd.getTransicoes();
        for (int i = 0; i < transicoes[0].length; i++) {
            for (int j = 0; j < transicoes.length; j++) {
                saida.write(alfabeto[j] + ":" + estados[i] + "-" + transicoes[j][i] + ";");
                saida.write("\n");
            }
        }

        saida.write(".");
        saida.flush();
    }

}
