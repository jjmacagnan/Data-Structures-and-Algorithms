package prova_1.capitulo_3.exercicios.criatividade;

import java.util.Arrays;

/*
 * Created by jjmacagnan on 22/04/17.
 */
/*Let A be an array of size n ≥ 2 containing integers from 1 to n − 1 inclusive, one
of which is repeated. Describe an algorithm for finding the integer in A that is
repeated.*/
public class C317 {

    public static void main(String[] args) {
        C317 c317 = new C317();
        int[] vetor = {4,2,3,2,4,4,5,5};

        System.out.println(c317.encontrarRepetido(vetor));
    }

    public int encontrarRepetido(int[] vetor) {
       for (int i = 0; i < vetor.length; i++) {
           for (int j = 0 ; j < i; j++) {
               if (i != j) {
                   if (vetor[i] == vetor[j]) {
                       return vetor[i];
                   }
               }
           }
       }
       return -1;
    }
}
