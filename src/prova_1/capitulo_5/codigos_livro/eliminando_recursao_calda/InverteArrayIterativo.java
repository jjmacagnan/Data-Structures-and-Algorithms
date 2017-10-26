package prova_1.capitulo_5.codigos_livro.eliminando_recursao_calda;

/*
 * Created by jjmacagnan on 23/04/17.
 */
public class InverteArrayIterativo {

    public static void main(String[] args) {
        int vetor[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        inverteArrayIterativo(vetor);

        for (int vet : vetor) {
            System.out.print(" - " + vet);
        }

        inverteArrayIterativo(vetor);
        System.out.println();

        for (int vet : vetor) {
            System.out.print(" - " + vet);
        }
    }

    public static void inverteArrayIterativo(int[] vetor) {
        int inferior = 0;
        int superior = vetor.length-1;

        while (inferior < superior) {
            int temp = vetor[inferior];
            vetor[inferior++] = vetor[superior];
            vetor[superior--] = temp;
        }
    }

}
