package prova_1.capitulo_5.exercicios;

import java.util.Scanner;

/*R-5.2 Explique como modificar o algoritmo de busca binária de forma que ele retorne o index do alvo em sequência ou −1
(se o alvo não for achado). */
public class R52 {

    public static void main(String[] args) {
        int[] vetor = {0, 10, 20, 30, 40, 50, 60, 70, 80, 90};

        System.out.println("Entre com um numero para busca");
        Scanner scanner = new Scanner(System.in);

        int valor  = scanner.nextInt();
        System.out.println("indice do alvo é: " + binarySearch(vetor, valor, 0, vetor.length-1));

    }

    public static int binarySearch(int[] data, int target, int low, int high) {
        if (low > high)
            return -1;
        else {
            int mid = (low + high) / 2;
            if (target == data[mid])
                return mid;
            else if (target < data[mid])
                return binarySearch(data, target, low, mid - 1);
            else
                return binarySearch(data, target, mid + 1, high);
        }
    }
}
