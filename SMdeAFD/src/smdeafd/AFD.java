package smdeafd;

public class AFD {

    private String[] alfabeto;
    private String estadoInicial;
    private String[] estados;
    private boolean[] finais;
    private String[][] transicoes;

    public AFD(int alfabeto, int estados) {
        this.alfabeto = new String[alfabeto];
        this.estados = new String[estados];
        this.finais = new boolean[estados];
        this.transicoes = new String[alfabeto][estados];
    }

    public String[] getAlfabeto() {
        return alfabeto;
    }

    public String getEstadoInicial() {
        return estadoInicial;
    }

    public String[] getEstados() {
        return estados;
    }

    public boolean[] getFinais() {
        return finais;
    }

    public String[][] getTransicoes() {
        return transicoes;
    }

    public void setAlfabeto(String[] alfabeto) {
        this.alfabeto = alfabeto;
    }

    public void setEstadoInicial(String estadoInicial) {
        this.estadoInicial = estadoInicial;
    }

    public void setEstados(String[] estados) {
        this.estados = estados;
    }

    public void setFinais(int posicao) {
        this.finais[posicao] = true;
    }

    public void setTransicoes(String[][] transicoes) {
        this.transicoes = transicoes;
    }

    public void exibe() {
        System.out.println("ALFABETO:");
        for (int i = 0; i < alfabeto.length; i++) {
            System.out.println(alfabeto[i]);
        }
        System.out.println("ESTADOS:");
        for (int i = 0; i < estados.length; i++) {
            System.out.println(estados[i]);
        }
        System.out.println("ESTADO INICIAL:");
        System.out.println(estadoInicial);
        System.out.println("ESTADOS FINAIS:");
        for (int i = 0; i < estados.length; i++) {
            if (finais[i] == true) {
                System.out.println(estados[i]);
            }
        }
        System.out.println("TRANSIÇÕES:");

        for (int i = 0; i < transicoes[0].length; i++) {
            for (int j = 0; j < transicoes.length; j++) {
                System.out.println(alfabeto[j] + ":" + estados[i] + "-" + transicoes[j][i]);
            }
        }
    }
}
