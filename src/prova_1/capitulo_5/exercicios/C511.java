package prova_1.capitulo_5.exercicios;

/*C-5.11 Descreva um algoritmo recursivo  para computar a parte inteira
de um logaritmo de n na base 2 com somente adição e divisão por inteiros. */
public class C511 {

    public static void main(String args[]) {
        System.out.println("Parte inteira do Log base 2: " + calcLog(8));
    }

    public static int calcLog(int n) {
        if (n == 1)
            return 0;
        else if (n == 2)
            return 1;
        else return calcLog(2) + calcLog(n/2);
    }
}
