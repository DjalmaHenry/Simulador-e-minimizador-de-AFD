package smdeafd;

// Minimiza AFD: Eliminar estados inalcançáveis a partir do estado inicial.[Feito]
import java.util.Arrays;
// Minimiza AFD: Separar estados finais e não finais. [Feito]
// Minimiza AFD: Validar novos grupos formados.
// Minimiza AFD: Criar um novo AFD. 

public class MinimizaAFD {

    public AFD minimizar(AFD afd) {
        // Minimiza AFD: Eliminar estados inalcançáveis a partir do estado inicial.
        String[][] transicoesLimpas = afd.getTransicoes();
        System.out.println(Arrays.toString(afd.getAlfabeto()));
        String[] estadosX = null;
        for (int i = 0; i < afd.getAlfabeto().length; i++) {
            for (int j = 0; j < afd.getEstados().length; j++) {
                System.out.print("Transiçao[ " + i + "][q" + j + "]");
                String name = transicoesLimpas[i][j];
                System.out.println(name);
            }
        }

        int multi = afd.getAlfabeto().length * afd.getEstados().length;
        String[] tamanhos = new String[multi];
        int cont = 0;
        for (int i = 0; i < afd.getAlfabeto().length; i++) {

            for (int j = 0; j < afd.getEstados().length; j++) {
                tamanhos[cont] = transicoesLimpas[i][j];
                cont++;

            }
        }

        int[] estadosQ = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] estadosNumber = new int[estadosQ.length];
        System.out.println("AA" + estadosNumber[2]);
        for (int i = 0; i < tamanhos.length; i++) {
            tamanhos[i] = tamanhos[i].substring(1);
            //System.out.println(tamanhos[i]);
            switch (tamanhos[i]) {
                case "0":
                    estadosNumber[0] = estadosNumber[0] + 1;
                    break;
                case "1":
                    estadosNumber[1] = estadosNumber[1] + 1;
                    break;
                case "2":
                    estadosNumber[2] = estadosNumber[2] + 1;
                    break;
                case "3":
                    estadosNumber[3] = estadosNumber[3] + 1;
                    break;
                case "4":
                    estadosNumber[4] = estadosNumber[4] + 1;
                    break;
                case "5":
                    estadosNumber[5] = estadosNumber[5] + 1;
                    break;
                case "6":
                    estadosNumber[6] = estadosNumber[6] + 1;
                    break;
                case "7":
                    estadosNumber[7] = estadosNumber[7] + 1;
                    break;
                case "8":
                    estadosNumber[8] = estadosNumber[8] + 1;
                    break;
                case "9":
                    estadosNumber[9] = estadosNumber[9] + 1;
                    break;
                case "10":
                    estadosNumber[10] = estadosNumber[10] + 1;
                    break;
            }
        }

        //contador de grupos de numeros
        int contEstadosPossiveis = 0;
        for (int estadosNumber1 : estadosNumber) {
            if (estadosNumber1 != 0) {
                contEstadosPossiveis++;
            }
        }

        System.out.println("abc" + contEstadosPossiveis);

        //criação do novo afd sem os estados inalcançaveis
        AFD afdLimpo = new AFD(afd.getAlfabeto().length, contEstadosPossiveis);
        // Minimiza AFD: Separar estados finais e não finais.
        separarEstados(afdLimpo);

        return null;
    }

// Funcão que separa estados finais e não finais.
    public void separarEstados(AFD afd) {
        String[] estadosFinais = new String[afd.getEstados().length];
        String[] estadosNaoFinais = new String[afd.getEstados().length];
        String[] alfabeto = afd.getAlfabeto();
        for (int i = 0; i < afd.getEstados().length; i++) {
            if (afd.getFinais()[i]) {
                estadosFinais[i] = afd.getEstados()[i];
            } else {
                estadosNaoFinais[i] = afd.getEstados()[i];
            }
        }
        AFD afdEstadosFinais = new AFD(alfabeto, estadosFinais);
        AFD afdEstadosNaoFinais = new AFD(alfabeto, estadosNaoFinais);
        // Minimiza AFD: Validar novos grupos formados.
        //   validarGrupos(afdEstadosFinais, afdEstadosNaoFinais);
    }
    //Função que valida novos grupos formados

//    public AFD validarGrupos(AFD afdEstadosFinais, AFD afdEstadosNaoFinais) {
//
//        
//        AFD AFDMinimizado = null;
//            for (int i = 0; i < afdEstadosFinais.getEstados(); i++) {
//                if (afd.getFinais()[i]) {
//                    estadosFinais[i] = afd.getEstados()[i];
//                } else {
//                    estadosNaoFinais[i] = afd.getEstados()[i];
//                }
//        }
//
//        return AFDMinimizado;
//    }
//
//// CLASSE AFD
//    public boolean comparaTransicoesEstados(AFD a) {
//        //  
//        for (int i = 0; i < a.getTransicoes().length; i++) {
//            for (int j = 0; j < a.getTransicoes()[i].length; j++) {
////                if () { //compara se o afd com as mesmas transições vão pra estados do mesmo tipo(final ou nao final)
////
////                }else{
////                    
////                }
//            }
//        }
//        return false;
//    }

}
