package capitulo_1;

/*
 * Created by jjmacagnan on 22/04/17.
 */

/*C-1.14 Write a pseudocode description of a method that reverses an array of n integers,
so that the numbers are listed in the opposite order than they were before, and
compare this method to an equivalent Java method for doing the same thing.*/
public class C114 {

    private int vetorOriginal[] = {5,4,3,2,1};
    private int vetorInvertido[] = new int[5];

    public static void main(String args[]) {
        C114 ex1 = new C114();
        ex1.impirme(ex1.getVetorOriginal());
        ex1.inverteVetor(ex1.vetorOriginal, ex1.vetorInvertido);
        ex1.impirme(ex1.getVetorInvertido());
    };

    public void impirme(int vetor[]) {
        for(int aux : vetor) {
            System.out.println(aux);
            System.out.println("-");
        }
        System.out.println();
    }

    public void inverteVetor(int vetorOriginal[], int vetorParaReceberValores[]) {
        int aux = 0;
        for(int i = vetorOriginal.length; i > 0; i--) {
            vetorParaReceberValores[aux] = vetorOriginal[i-1];
            aux++;
        }
    }

    public int[] getVetorOriginal() {
        return vetorOriginal;
    }

    public int[] getVetorInvertido() {
        return vetorInvertido;
    }
}
