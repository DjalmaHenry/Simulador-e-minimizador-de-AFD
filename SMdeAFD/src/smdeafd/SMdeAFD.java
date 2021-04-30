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
        System.out.println("================================");
        if (validado) {
            System.out.println("AUTOMATO VALIDO!");
            MinimizaAFD minimizacao = new MinimizaAFD();
            AFD minimizado = minimizacao.minimizar(afd);
            minimizado.exibe();
            System.out.println("Minimização realizada com sucesso!");
            arquivo.saidaArquivo(afd);
            System.out.println("Automato minimizado guardado em saida.txt");
        } else {
            System.err.println("AUTOMATO NÃO VALIDO!");
            System.err.println("Não foi possivel executar a minimização.");
        }
    }

}
