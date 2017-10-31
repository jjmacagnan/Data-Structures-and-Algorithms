package chapter_9.code.PriorityQueue;

/*
 * Created by jjmacagnan on 31/05/2017.
 */
public interface PriorityQueue<K, V> {
    int size();
    boolean isEmpty();
    Entry<K, V> insert(K key, V value) throws IllegalStateException;
    Entry<K, V> min();
    Entry<K, V> removeMin();
}
