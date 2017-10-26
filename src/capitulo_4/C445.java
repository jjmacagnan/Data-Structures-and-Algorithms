package capitulo_4;

/*C-4.45 An array A contains n − 1 unique integers in the range [0,n − 1], that is, there is
one number from this range that is not in A. Design an O(n)-time algorithm for
finding that number. You are only allowed to use O(1) additional space besides
the array A itself.*/
public class C445 {

    public static void main(String[] args) {
        int[] array = {10,11,13,12,14,15,16,17,45};
        int soma = 0;
        int soma1 = 0;

        for (int i = 0; i < array.length; i++) {
            soma += array[i];
        }

        for (int i = 0; i < array.length-1; i++) {
            soma1 += array[i];
        }

        System.out.println("Soma com todas os valores do array: " + soma);
        System.out.println("Soma n-1: " + soma1);
        int valor = soma-soma1;
        System.out.println("Valor que esta faltando: " + valor);
    }
}
