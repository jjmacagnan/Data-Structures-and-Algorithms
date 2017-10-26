package capitulo_4;

import java.util.Arrays;

/*C-4.42 Describe an algorithm for finding both the minimum and maximum of n numbers
using fewer than 3n/2 comparisons.*/
public class C442 {

    public static void main(String[] args) {
        int[] arrayA = {8, 4, 56, 12, 7, 45, 345, 34, 87, 98, 3, 9, 13, 14, 23, -90};
        int max;
        int min;

        Arrays.sort(arrayA);

        max = arrayA[arrayA.length-1];
        min = arrayA[0];

        System.out.println("Max: " + max);
        System.out.println("Min: " + min);

    }
}
