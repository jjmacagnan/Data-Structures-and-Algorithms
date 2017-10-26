package prova_1.capitulo_5.exercicios;

/*
 * Created by jjmacagnan on 23/04/17.
 */
/*C-5.13 Give a recursive algorithm to compute the product of two positive integers, m and n, using only addition and subtraction. */
public class C513 {

    public static void main(String[] args) {
        System.out.println(produto(4 ,7));
    }

    private static  int produto(int a, int b) {
        if (b == 1) {
            return a;
        } else if (a == 1) {
            return b;
        }else {
            return a + produto(a, b-1);
        }
    }
}
