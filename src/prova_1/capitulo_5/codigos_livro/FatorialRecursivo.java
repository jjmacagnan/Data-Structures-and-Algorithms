package prova_1.capitulo_5.codigos_livro;

import java.util.Scanner;

/*
 * Created by jjmacagnan on 23/04/17.
 */
public class FatorialRecursivo {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite um numero para calcular o fatorial");
        int n = scanner.nextInt();

        System.out.println("Fatorial de " + n + " = " +fatorial(n));

    }

    public static long fatorial(int n) throws IllegalArgumentException {
        if (n < 0) {
            throw new IllegalArgumentException();
        } else if (n == 0) {
            return 1;
        } else {
            return n * fatorial(n - 1);
        }

    }
}
