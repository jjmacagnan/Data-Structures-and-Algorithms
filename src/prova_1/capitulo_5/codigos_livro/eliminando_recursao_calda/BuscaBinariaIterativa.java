package prova_1.capitulo_5.codigos_livro.eliminando_recursao_calda;

import java.util.Scanner;

/*
 * Created by jjmacagnan on 23/04/17.
 */
public class BuscaBinariaIterativa {

    public static void main(String[] args) {
        int[] vetor = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        System.out.println("Entre com um numero para busca");
        Scanner scanner = new Scanner(System.in);

        int valor  = scanner.nextInt();
        System.out.println(buscaBinariaIterativa(vetor, valor));
    }

    public static boolean buscaBinariaIterativa(int[] vetor, int valor) {
        int inferior = 0;
        int superior = vetor.length - 1;

        while (inferior <= superior) {
            int meio = (inferior + superior) / 2;
            if (valor == vetor[meio]) {
                return true;
            } else if (valor < vetor[meio]) {
                superior = meio - 1;
            } else {
                inferior = meio + 1;
            }
        }
        return false;
    }
}
