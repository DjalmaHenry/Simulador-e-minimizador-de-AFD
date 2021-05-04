package smdeafd;

// Minimiza AFD: Eliminar estados inalcançáveis a partir do estado inicial.
// Minimiza AFD: Separar estados finais e não finais.
// Minimiza AFD: Validar novos grupos formados.
// Minimiza AFD: Criar um novo AFD.
public class MinimizaAFD {

    public AFD minimizar(AFD afd) {
        afd = eliminaInalcancaveis(afd);
    }

    public static AFD eliminaInalcancaveis(AFD afd) {

        //acha estados alcançaveis
        String[] estados = afd.getEstados();
        boolean[] alcancavel = new boolean[estados.length];
        String[][] transicoes = afd.getTransicoes();
        for (int i = 0; i < transicoes[0].length; i++) {
            for (int j = 0; j < transicoes.length; j++) {
                for (int z = 0; z < estados.length; z++) {
                    if (transicoes[j][i].compareTo(estados[z]) == 0) {
                        alcancavel[z] = true;
                    }
                }
            }
        }

        //conta quantidade de estados inalcançaveis
        int contInalcancavel = 0;
        for (int z = 0; z < alcancavel.length; z++) {
            if (alcancavel[z] == false) {
                contInalcancavel++;
            }
        }

        //elimina transições dos estados inalcançaveis
        String[] alfabeto = afd.getAlfabeto();
        String[][] novasTransicoes = new String[alfabeto.length][estados.length - contInalcancavel];
        int k = 0;
        for (int i = 0; i < transicoes[0].length; i++) {
            for (int j = 0; j < transicoes.length; j++) {
                if (alcancavel[i] == false) {
                    i++;
                } else {
                    novasTransicoes[j][k] = transicoes[j][i];
                }
            }
            k++;
        }

        //elimina estados inalcançaveis
        String[] novosEstados = new String[estados.length - contInalcancavel];
        boolean[] finais = afd.getFinais();
        boolean[] novosFinais = new boolean[estados.length - contInalcancavel];
        int j = 0;
        for (int i = 0; i < estados.length; i++) {
            if (alcancavel[i] == false) {
                i++;
            } else {
                novosEstados[j] = estados[i];
                novosFinais[j] = finais[i];
            }
            j++;
        }

        //criando novo AFD sem os estados inalcançaveis
        String estadoInicial = afd.getEstadoInicial();
        AFD novoAFD = new AFD(alfabeto, estadoInicial, novosEstados, novosFinais, novasTransicoes);
        return novoAFD;
    }
}
