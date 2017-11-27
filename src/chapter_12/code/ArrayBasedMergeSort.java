package chapter_12.code;

import java.util.Arrays;
import java.util.Comparator;

public class ArrayBasedMergeSort<K> {


    /**
     * Merge contents of arrays S1 and S2 into properly sized array S.
     */
    public static <K> void merge(K[] S1, K[] S2, K[] S, Comparator<K> comp) {
        int i = 0, j = 0;

        while (i + j < S.length)
            if (j == S2.length || (i < S1.length && comp.compare(S1[i], S2[j]) < 0))
                S[i + j] = S1[i++];                             // copy ith element of S1 and increment i
            else
                S[i + j] = S2[j++];                             // copy jth element of S2 and increment j

    }

    /** Merge-sort contents of array S. */
    public static <K> void mergeSort(K[] S, Comparator<K> comp) {
        int n = S.length;

        if (n < 2)                                              // array is trivially sorted
            return;

        // divide
        int mid = n / 2;
        K[] S1 = Arrays.copyOfRange(S, 0, mid);             // copy of first half
        K[] S2 = Arrays.copyOfRange(S, mid, n);                  // copy of second half

        // conquer (with recursion)
        mergeSort(S1, comp);                                    // sort copy of first half
        mergeSort(S2, comp);                                    // sort copy of second half

        // merge results
        merge(S1, S2, S, comp);                                 // merge sorted halves back into original
    }
}
