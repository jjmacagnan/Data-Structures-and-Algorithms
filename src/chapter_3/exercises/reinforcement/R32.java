package chapter_3.exercises.reinforcement;

import java.util.Arrays;
import java.util.Random;

/*
 * Created by Jasiel on 28/08/2017.
 */

/*Write a Java method that repeatedly selects and removes a random entry from an
array until the array holds no more entries.*/

/*R-3.2 Escreva um método Java que seleciona e remove repetidamente uma entrada aleatória
de um vetor até que o mesmo não contenha mais entradas.*/

public class R32 {

    public static void main(String[] args) {
        int data[] = new int[10];
        Random rand = new Random(); // a pseudo-random number generator
        rand.setSeed(System.currentTimeMillis()); // use current time as a seed
        // fill the data array with pseudo-random numbers from 0 to 99, inclusive
        for (int i = 0; i < data.length; i++)
            data[i] = rand.nextInt(100); // the next pseudo-random number

        System.out.println("data = " + Arrays.toString(data));

        removeElements(data);
    }

    private static void removeElements(int[] array) {
        Random r = new Random();
        while (array.length > 0) {
            int index = r.nextInt(array.length);
            System.out.println("INDEX = " + index + ", ELEMENT = " + array[index]);
            int[] array1 = new int[array.length - 1];
            System.arraycopy(array, 0, array1, 0, index);
            System.arraycopy(array, index + 1, array1, index, array.length - 1 - index);
            array = array1;
        }
    }





}
