package prova_1.capitulo_5.exercicios;

/*
 * Created by jjmacagnan on 23/04/17.
 */
public class LimitStack {

    public static void main(String[] args) {
        int n = 100000;

        System.out.println(somatorio2(n, 0));
        System.out.println(somatorio1(n));
    }

    public static int somatorio1(int n) {
        if (n == 1) {
            return 1;
        }

        return n + somatorio1(n - 1);
    }

    public static int somatorio2(int n, int soma) {
        if (n == 1) {
            return 1;
        }

        soma = n -1 + soma;
        return somatorio2(n - 1, soma);
    }
}
