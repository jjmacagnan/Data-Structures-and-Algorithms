package capitulo_5.codigos;

import java.util.Scanner;

/*
 * Created by jjmacagnan on 23/04/17.
 */
public class BuscaBinaria {

    public static void main(String[] args) {
        int[] vetor = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        System.out.println("Entre com um numero para busca");
        Scanner scanner = new Scanner(System.in);

        int valor  = scanner.nextInt();
        System.out.println(buscaBinaria(vetor, 0, vetor.length-1, valor));

    }

    public static boolean buscaBinaria(int vetor[], int limiteInferior, int limiteSuperior, int valor) {
        System.out.println(limiteInferior+"--------"+limiteSuperior);
        if (limiteInferior > limiteSuperior) {
            return false;
        } else {
            int meio = (limiteInferior + limiteSuperior)/2;
            System.out.println(meio);
            if (vetor[meio] == valor) {
                return true;
            } else if (vetor[meio] < valor) {//busca na metda da direita
                return buscaBinaria(vetor, meio+1, limiteSuperior, valor);
            } else {
                return buscaBinaria(vetor, limiteInferior, meio-1, valor);
            }
        }
    }
}
