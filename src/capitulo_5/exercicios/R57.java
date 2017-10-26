package capitulo_5.exercicios;

/*Describe a recursive algorithm for computing the n th Harmonic number, defined
as Hn = ∑n k=1 1/k.*/

/*Descreva um algoritmo recursivo para computador o  nth numero Harmônico, definido como Hn = ∑n k=1 1/k.*/
public class R57 {

    public static void main(String[] args) {
        System.out.println(harmonicNumber(5));
    }

    public static double harmonicNumber(int n) {
        if (n == 1) {
            return 1/n;
        } else {
            return (double) 1/n + harmonicNumber(n-1);
        }
    }
}
