package prova_1.capitulo_5.exercicios;

import java.util.Scanner;

/*
 * Created by jjmacagnan on 23/04/17.
 */
/*C-5.18 Write a short recursive Java method that determines if a string s is a palindrome, that is, it is equal to its reverse.
Examples of palindromes include 'racecar' and 'gohangasalamiimalasagnahog'. */
public class C518 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String palavraInfomada;
        String palavra = "gohangasalamiimalasagnahog";

        System.out.println(palavra);
        char[] vetor = palavra.toCharArray();
        boolean r = verificaPalindromo(vetor, 0, palavra.length()-1);
        System.out.println(r);

        System.out.println("Digite uma palavra");
        palavraInfomada = scanner.next();

        if (!palavraInfomada.isEmpty()) {
            System.out.println(palavraInfomada);
            vetor = palavraInfomada.toCharArray();
            r = verificaPalindromo(vetor, 0, palavraInfomada.length()-1);
            System.out.println(r);
        }
    }

    public static boolean verificaPalindromo(char[] vetor, int inferior, int superior) {
        if (inferior > superior) {
            return true;
        } else if (vetor[inferior] != vetor[superior]) {
            return false;
        } else {
            return verificaPalindromo(vetor, inferior+1, superior-1);
        }
    }
}
