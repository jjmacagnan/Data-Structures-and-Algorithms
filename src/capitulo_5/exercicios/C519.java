package capitulo_5.exercicios;

import java.util.Scanner;

/*
 * Created by jjmacagnan on 23/04/17.
 */

/*C-5.19 Use recursion to write a Java method for determining if a string s has more vowels than consonants. */
public class C519 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite uma palvra para verificar se a mais vogais que consoantes");

        String string = scanner.next();
        boolean resposta = maisVolgal(string.toCharArray(), 0, 0);
        System.out.println(resposta);
    }

    public static boolean maisVolgal(char[] v, int cont, int vogais) {
        if (v.length-1 < cont) {
            if (vogais > v.length / 2) {
                return true;
            } else {
                return false;
            }
        }

        if (v[cont] == 'a' || v[cont] == 'e' || v[cont] == 'i' || v[cont] == 'o' || v[cont] == 'u') {
            vogais++;
        }

        return maisVolgal(v, cont+1, vogais);
    }
}
