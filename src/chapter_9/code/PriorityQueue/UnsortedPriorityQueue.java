package chapter_9.code.PriorityQueue;


import chapter_7.code.iterators.LinkedPositionalList;
import chapter_7.code.positional_list.Position;
import chapter_7.code.positional_list.PositionalList;

import java.util.Comparator;

/*
 * Created by jjmacagnan on 02/06/2017.
 */
public class UnsortedPriorityQueue<K, V> extends AbstractPriorityQueue<K, V> {
    private PositionalList<Entry<K, V>> list = new LinkedPositionalList<>();

    public UnsortedPriorityQueue() {
        super();
    }

    public UnsortedPriorityQueue(Comparator<K> comp) {
        super(comp);
    }

    private Position<Entry<K, V>> findMin() {
        Position<Entry<K, V>> small = list.first();
        for (Position<Entry<K, V>> walk : list.positions())
            if (compare(walk.getElement(), small.getElement()) < 0)
                small = walk; // found an even smaller key
        return small;
    }

    @Override
    public Entry<K, V> insert(K key, V value) throws IllegalStateException {
        checkkey(key);

        Entry<K, V> newest = new PQEntry<>(key, value);
        list.addLast(newest);

        return newest;
    }

    @Override
    public Entry<K, V> min() {
        if (list.isEmpty())
            return null;
        return findMin().getElement();
    }

    @Override
    public Entry<K, V> removeMin() {
        if (list.isEmpty())
            return null;
        return list.remove(findMin());
    }

    @Override
    public int size() {
        return list.size();
    }
}
