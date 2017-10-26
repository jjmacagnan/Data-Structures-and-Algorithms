package capitulo_4;

import java.util.Arrays;

/*
 * Created by jjmacagnan on 23/04/17.
 */
/*C-4.36 Describe an efficient algorithm for finding the ten largest elements in an array of
size n. What is the running time of your algorithm?*/
public class C436 {

    public static void main(String[] args) {
        int[] arrayA = {8,4,56,12, 7, 45, 345, 34, 87, 98, 3, 9, 13, 14, 23};
        int[] maiores = new int[10];
        Arrays.sort(arrayA);

        int j = 0;
        for (int i = arrayA.length-1; i > (arrayA.length-11); i--) {
            maiores[j] = arrayA[i];
            j++;
        }

        for (int a : maiores) {
            System.out.print("," + a);
        }
    }
}
