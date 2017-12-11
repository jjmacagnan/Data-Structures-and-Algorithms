package chapter_12.exercises;

import chapter_9.code.PriorityQueue.DefaultComparator;

import java.util.Comparator;

public class R127 {

    /**
     * Merge contents of arrays S1 and S2 into properly sized array S.
     */
    public static <K> void merge(K[] S1, K[] S2, K[] S, Comparator<K> comp) {
        int i = 0, j = 0;

        while (i + j != S.length) {
            if (j == S2.length || (i < S1.length && comp.compare(S1[i], S2[j]) < 0))
                if (j != 0) {
                    if (S[(i + j) - 1] != S1[i]) {
                        S[i + j] = S1[i];
                    }
                    i++;
                } else {
                    S[i + j] = S1[i++];
                }
            else if (j != 0) {
                if (S[(i + j) - 1] != S2[j]) {
                    S[i + j] = S2[j];
                }
                j++;
            } else {
                S[i + j] = S2[j++];
            }
        }
    }


    public static void main(String[] args) {
        Comparator comp = new DefaultComparator();
        Integer[] array1 = {0, 1, 2, 3, 4, 9};
        Integer[] array2 = {0, 1, 2, 3, 4, 20, 50};
        Integer[] arrayResult = new Integer[array1.length + array2.length];

        R127.merge(array1, array2, arrayResult, comp);

    }
}
