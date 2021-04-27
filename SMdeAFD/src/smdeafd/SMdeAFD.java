package smdeafd;

import java.io.IOException;

public class SMdeAFD {

    public static void main(String[] args) throws IOException {
        Arquivo arquivo = new Arquivo();
        AFD afd = arquivo.instanciarArquivo();
        arquivo.lerArquivo(afd);
        afd.exibe();
        ValidaAFD validacao = new ValidaAFD();
        boolean validado = validacao.validar(afd);
        if (validado) {
            System.out.println("VALIDO");
            MinimizaAFD minimizacao = new MinimizaAFD();
            AFD minimizado = minimizacao.minimizar(afd);
            minimizado.exibe();
        } else {
            System.err.println("NÃO VALIDO");
        }
    }

}
