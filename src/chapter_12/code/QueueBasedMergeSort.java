package chapter_12.code;

import chapter_6.code.queue.LinkedQueue;
import chapter_6.code.queue.Queue;

import java.util.Comparator;

public class QueueBasedMergeSort {

    /** Merge contents of sorted queues S1 and S2 into empty queue S. */
    public static <K> void merge(Queue<K> S1, Queue<K> S2, Queue<K> S, Comparator<K> comp) {

        while (!S1.isEmpty() && !S2.isEmpty()) {
            if (comp.compare(S1.first(), S2.first()) < 0)
                S.enqueue(S1.dequeue());                            // take next element from S1
            else
                S.enqueue(S2.dequeue());                            // take next element from S2

        }
        while (!S1.isEmpty())
            S.enqueue(S1.dequeue());                                // move any elements that remain in S1
        while (!S2.isEmpty())
            S.enqueue(S2.dequeue());                                // move any elements that remain in S2
    }

    /** Merge-sort contents of queue. */
    public static <K> void mergeSort(Queue<K> S, Comparator<K> comp) {
        int n = S.size();

        if (n < 2)                                                  // queue is trivially sorted
            return;

        // divide
        Queue<K> S1 = new LinkedQueue<>();                          // (or any queue implementation)
        Queue<K> S2 = new LinkedQueue<>();

        while (S1.size() < n/2)
            S1.enqueue(S.dequeue());                                // move the first n/2 elements to S1
        while (!S.isEmpty())
            S2.enqueue(S.dequeue());                                // move remaining elements to S2

        // conquer (with recursion)
        mergeSort(S1, comp);                                        // sort first half
        mergeSort(S2, comp);                                        // sort second half

        // merge results
        merge(S1, S2, S, comp);                                     // merge sorted halves back into original
    }

}
