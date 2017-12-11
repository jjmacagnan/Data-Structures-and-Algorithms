package chapter_12.exercises;

import chapter_9.code.PriorityQueue.DefaultComparator;

import java.util.Arrays;
import java.util.Comparator;

public class R127 {

    /**
     * Merge contents of arrays S1 and S2 into properly sized array S.
     */
    public static <K> void merge(K[] S1, K[] S2, K[] S, Comparator<K> comp) {
        int i = 0, j = 0;

        while (i + j < S.length)
            if (j == S2.length || (i < S1.length && comp.compare(S1[i], S2[j]) < 0 ))
                S[i + j] = S1[i++];                             // copy ith element of S1 and increment i
            else
                S[i + j] = S2[j++];                             // copy jth element of S2 and increment j

    }


    public static void main(String[] args) {
        Comparator comp = new DefaultComparator();
        Object[] array1 = {0, 1, 2, 3, 4};
        Object[] array2 = {4, 5, 6, 7, 8};
        Object[] arrayResult = {};

        R127.merge(array1, array2,arrayResult, comp);

    }
}
