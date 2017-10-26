package capitulo_5.codigos;

/*
 * Created by jjmacagnan on 23/04/17.
 */
public class SomaBinaria {

    public static void main(String[] args) {
        int vetor[] = {1,2,5,6,7,34,12,34,16,76};

        System.out.println(somaBinaria(vetor, 0, vetor.length-1));
    }

    public static int somaBinaria(int[] vetor, int inf, int sup) {
        if (inf > sup) {
            return 0;
        } else if (inf == sup) {
            return vetor[inf];
        } else {
            int meio = (inf + sup) / 2;
            return somaBinaria(vetor, inf, meio) + somaBinaria(vetor, meio+1, sup);
        }
    }
}
