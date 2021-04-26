package smdeafd;

import java.io.IOException;

public class SMdeAFD {

    public static void main(String[] args) throws IOException {
        Arquivo arquivo = new Arquivo();
        AFD afd = arquivo.instanciarArquivo();
        arquivo.lerArquivo(afd);
        afd.exibe();
    }

}
