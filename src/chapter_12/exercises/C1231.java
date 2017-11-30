package chapter_12.exercises;

import chapter_12.code.QuickSort.QuickSortRandomizedInPlace;
import chapter_9.code.PriorityQueue.DefaultComparator;

import java.util.Comparator;

public class C1231<K> {

    public static void main(String[] args) {
        C1231 c1231 = new C1231();

        Comparator comp = new DefaultComparator();

        Object[] array = c1231.getArray();

        QuickSortRandomizedInPlace.quickSortInplace(array, comp, 0, 2);

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ",");
        }
    }

    public K[] getArray() {
        K[] array = (K[]) new Object[3];

        array[0] = (K) "C";
        array[1] = (K) "K";
        array[2] = (K) "A";

        return array;
    }


}
