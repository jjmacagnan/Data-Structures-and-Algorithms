package capitulo_5.exercicios;

/*Describe a recursive algorithm for finding the maximum element in an array, A,
of n elements. What is your running time and space usage?*/

/*R-5.1 Descreva um algoritmo recursivo para achar o maior elemento de um array, A,
que  contém n elementos. Qual é o tempo do algoritmo e sua utilização de disco? */
public class R51 {

    public static void main(String[] args) {
        int array[] = {7890,67,1090,4, 23,-4, 567};

        int max = findMax(array, 0, array.length-1);
        System.out.println("Max: " + max);
    }

    public static int findMax(int[] array, int max, int i){

        if (array[i] > max) {
            max = array[i];
        }
        if (i == 0) {
           return max;
        } else {
            return findMax(array, max, i-1);
        }

    }
}
