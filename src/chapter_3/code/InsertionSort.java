package chapter_3.code;

/*
 * Created by jjmacagnan on 22/04/17.
 */
public class InsertionSort {

    public static void main(String[] args) {
        char[] vetor = new char[10];
        vetor[0] = 'b';
        vetor[1] = 'c';
        vetor[2] = 'd';
        vetor[3] = 'a';
        vetor[4] = 'e';
        vetor[5] = 'h';
        vetor[6] = 'g';
        vetor[7] = 'f';
        vetor[8] = 'q';
        vetor[9] = 'm';
        insertionSort(vetor);
        for (char c : vetor) {
            System.out.println(c);
        }
    }

    public static void insertionSort(char[] vetor) {
        int tamanho = vetor.length;
        //percorre todo o vetor
        for (int i  = 0; i < tamanho; i++) {
            int j = i;
            char atual = vetor[i];
            //compara a posicao atual com os indices que estao para trás
            // se um item for mairo que o atual, empurra ele para frente.
            while (j > 0 && atual < vetor[j-1]) {
                vetor[j] = vetor[j-1];
                j--;

            }
            vetor[j] = atual;
        }
    }
}
