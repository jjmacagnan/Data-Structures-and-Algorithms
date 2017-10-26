package chapter_9.PriorityQueue;

import java.util.Comparator;

/**
 * @Author JJMacagnan on 31/05/2017.
 */
public class DefaultComparator<E> implements Comparator<E> {
    @Override
    public int compare(E a, E b) {
        return ((Comparable<E>) a).compareTo(b);
    }
}
