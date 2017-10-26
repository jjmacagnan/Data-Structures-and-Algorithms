package capitulo_12;

import capitulo_6.codigos.queue.LinkedQueue;
import capitulo_6.codigos.queue.Queue;

import java.util.Arrays;
import java.util.Comparator;

/*
 * Created by Jasiel on 09/07/2017.
 */
public class MergeSort<K> {


    /*Code Fragment 12.1: An implementation of the merge operation for a Java array.*/
    public static <K> void merge(K[] S1, K[] S2, K[] S, Comparator<K> comp) {
        int i = 0, j = 0;
        while (i + j < S.length) {
            if (j == S2.length || (i < S1.length && comp.compare(S1[i], S2[j]) < 0))
                S[i + j] = S1[i++];
            else
                S[i + j] = S2[j++];
        }
    }


    /*Code Fragment 12.2: An implementation of the recursive merge-sort algorithm for
a Java array (using the merge method defined in Code Fragment 12.1).*/
    public static <K> void mergeSort(K[] S, Comparator<K> comp) {
        int n = S.length;
        if (n < 2)
            return;

        int mid = n / 2;
        K[] S1 = Arrays.copyOfRange(S, 0, mid);
        K[] S2 = Arrays.copyOfRange(S, mid, n);

        mergeSort(S1, comp);
        mergeSort(S2, comp);

        merge(S1, S2, S, comp);
    }

    /* Merge contents of sorted queues S1 and S2 into empty queue S. */
    public static <K> void merge(Queue<K> S1, Queue<K> S2, Queue<K> S, Comparator<K> comp) {
        while (!S1.isEmpty() && !S2.isEmpty()) {
            if (comp.compare(S1.first(), S2.first()) < 0)
                S.enqueue(S1.dequeue());
            else
                S.enqueue(S2.dequeue());
        }
        while (!S1.isEmpty())
            S.enqueue(S1.dequeue());
        while (!S2.isEmpty())
            S.enqueue(S2.dequeue());
    }

    /*Code Fragment 12.3: An implementation of merge-sort using a basic queue*/
    public static <K> void mergeSort(Queue<K> S, Comparator<K> comp) {
        int n = S.size();
        if (n < 2)
            return;

        Queue<K> S1 = new LinkedQueue<>();
        Queue<K> S2 = new LinkedQueue<>();
        while (S1.size() < n / 2)
            S1.enqueue(S.dequeue());
        while (S1.size() < n / 2)
            S2.enqueue(S.dequeue());

        mergeSort(S1, comp);
        mergeSort(S2, comp);

        merge(S1, S2, S, comp);
    }

    /*Merges in[start..start+inc−1] and in[start+inc..start+2∗inc−1] into out.*/
    public static <K> void merge(K[] in, K[] out, Comparator<K> comp, int start, int inc) {
        int end1 = Math.min(start + inc, in.length);
        int end2 = Math.min(start + 2 * inc, in.length);
        int x = start;
        int y = start + inc;
        int z = start;
        while (x < end1 && y < end2) {
            if (comp.compare(in[x], in[y]) < 0)
                out[z++] = in[x++];
            else
                out[z++] = in[y++];
        }
        if (x < end1)
            System.arraycopy(in, x, out, z, end1 - x);
        else if (y < end2)
            System.arraycopy(in, y, out, z, end2 - y);
    }

    /*Code Fragment 12.4: An implementation of the nonrecursive merge-sort algorithm.*/
    public static <K> void mergeSortBottonUp(K[] orig, Comparator<K> comp) {
        int n = orig.length;
        K[] src = orig;
        K[] dest = (K[]) new Object[n];
        K[] temp;
        for (int i = 1; i < n; i *= 2) {
            for (int j = 0; j < n; j += 2 * i) {
                merge(src, dest, comp, j, i);
            }
            temp = src;
            src = dest;
            dest = temp;
        }
        if (orig != src)
            System.arraycopy(src, 0, orig, 0, n);
    }


}
