package chapter_10.code.maps;

import chapter_9.code.PriorityQueue.Entry;

/*
 * Created by jjmacagnan on 05/06/2017.
 */
public interface Map<K, V> {
    int size();
    V get(K key);
    V put(K key, V value);
    Iterable<K> keySet();
    Iterable<V> values();
    Iterable<Entry<K, V>> entrySet();
}
