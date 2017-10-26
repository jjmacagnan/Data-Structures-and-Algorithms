package capitulo_5.codigos;

/*
 * Created by jjmacagnan on 23/04/17.
 */
public class InverteArray {

    public static void main(String[] args) {
        int vetor[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        inverte(vetor, 0, vetor.length-1);

        for (int vet : vetor) {
            System.out.print(" - " + vet);
        }
    }

    public static void inverte(int[] vetor, int inf, int sup) {
        if (inf > sup) {
            return;
        }

        int temp = vetor[inf];
        vetor[inf] = vetor[sup];
        vetor[sup] = temp;
        inverte(vetor, inf+1, sup-1);
    }
}
