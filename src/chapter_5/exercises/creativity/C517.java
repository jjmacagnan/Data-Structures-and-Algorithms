package chapter_5.exercises.creativity;

/*
 * Created by jjmacagnan on 23/04/17.
 */
/*C-5.17 Write a short recursive Java method that takes a character string s and outputs its reverse.
For example, the reverse of 'pots&pans' would be 'snap&stop'.*/
public class C517 {

    public static  void main(String[] args) {
        String s = "pots&pans";
        System.out.println(inverte(s.toCharArray(), s.length()));
    }

    public static String inverte(char[] vetor, int n) {
        if (n <= 0) {
            return " ";
        } else {
            return vetor[n-1] + inverte(vetor, n-1);
        }
    }
}
