package chapter_3.exercises.creativity;

/*
 * Created by jjmacagnan on 22/04/17.
 */
public class C318 {

    public static void main(String[] args) {
        C318 c318 = new C318();
        int[] vetor = {3,4,3,3,3,3};

        c318.encontraCincoRepetidos(vetor);
    }

    public void encontraCincoRepetidos(int[] vetor) {

        for (int i = 0; i < vetor.length; i++) {
            for (int j = 0 ; j < i; j++) {
                if (vetor[i] == vetor[j]) {
                    System.out.println("Valores repetidos " + vetor[i] + " indice " + i);
                }
            }
        }


    }
}
