package smdeafd;

// Validar AFD: Cada estado deve ter uma saída para cada simbolo do alfabeto.
public class ValidaAFD {

    public boolean validar(AFD afd) {
        String[][] transicoes = afd.getTransicoes();
        for (int i = 0; i < transicoes[0].length; i++) {
            for (int j = 0; j < transicoes.length; j++) {
                if (transicoes[j][i] == null) {
                    return false;
                }
            }
        }
        return true;
    }
}
