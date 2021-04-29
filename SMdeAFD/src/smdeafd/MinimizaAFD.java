package smdeafd;

// Minimiza AFD: Eliminar estados inalcançáveis a partir do estado inicial.

import java.util.Arrays;

// Minimiza AFD: Separar estados finais e não finais.
// Minimiza AFD: Validar novos grupos formados.
// Minimiza AFD: Criar um novo AFD.
public class MinimizaAFD {
    public AFD minimizar(AFD afd){
        // Minimiza AFD: Eliminar estados inalcançáveis a partir do estado inicial.
        String[][] transicoesLimpas = afd.getTransicoes();
        System.out.println(Arrays.toString(afd.getAlfabeto()));
        String[] estadosX = null;
        for (int i = 0; i < afd.getAlfabeto().length; i++) {
          //  System.out.println(i + "teste");
            for (int j = 0; j < afd.getEstados().length; j++) {
             //   System.out.println(j+"jjjj");
                System.out.print("Transiçao[ "+i+"][q"+j+"]" );
               // estadosX[j] = transicoesLimpas[i][j];
             //   System.out.println(estadosX[j]+"kkk");
                String name = transicoesLimpas[i][j]; 
               // estadosX[] = name;
                System.out.println(name);
            }
        }
        int multi = afd.getAlfabeto().length * afd.getEstados().length;
        String[] tamanhos = new String[multi];
        int cont = 0;
        for (int i = 0; i < afd.getAlfabeto().length; i++) {
            
            for (int j = 0; j < afd.getEstados().length; j++) {
                tamanhos[cont]= transicoesLimpas[i][j];
                cont++;    
            }
        }
        for (int i = 0; i <multi; i++) {
            System.out.println(tamanhos[i].charAt(1)); 

        }

   
        System.out.println(multi);
     //   int[] estadosX = new int[multi];
      //  AFD afdx = new AFD(afd.getAlfabeto().length, estadosX);
        
        // Minimiza AFD: Separar estados finais e não finais.
            //        2 - separa os finais e não-finais
            //verifica todos os estados
            //se estado == final
            //	AFDFinal[] = estado
            //se não
            //	AFDNaoFinal[] = estado
            
            
        //q0 false q1 true [X] q2 false
        //AFD afdLimpo = new AFD(afd.getAlfabeto().length, 2);
        //for (int i = 0; i < ; i++) {
            
        //}
    return null;
    }
    
    public AFD eliminarInalcancaveis(AFD afd){
        //achar 
        //remover
        return null;
    }
}
