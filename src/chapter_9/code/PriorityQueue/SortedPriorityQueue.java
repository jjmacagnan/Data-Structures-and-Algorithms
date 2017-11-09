package chapter_9.code.PriorityQueue;

import chapter_7.code.iterators.LinkedPositionalList;
import chapter_7.code.positional_list.Position;
import chapter_7.code.positional_list.PositionalList;

import java.util.Comparator;

/*
 * Created by jjmacagnan on 02/06/2017.
 */
public class SortedPriorityQueue<K, V> extends AbstractPriorityQueue<K, V> {

    private PositionalList<Entry<K, V>> list = new LinkedPositionalList<>();

    public SortedPriorityQueue(){
        super();
    }

    public SortedPriorityQueue(Comparator<K> comp) {
        super(comp);
    }

    @Override
    public Entry<K, V> insert(K key, V value) throws IllegalStateException {
        checkkey(key);
        Entry<K, V> newest = new PQEntry<>(key, value);
        Position<Entry<K, V>> walk = list.last();

        while (walk != null && walk.getElement()  != null && compare(newest, walk.getElement()) < 0)
            walk = list.before(walk);

        if (walk == null)
            list.addFirst(newest);
        else
            list.addAfter(walk, newest);
        return newest;
    }

    @Override
    public Entry<K, V> min() {
        if (list.isEmpty())
            return null;
        return list.first().getElement();
    }

    @Override
    public Entry<K, V> removeMin() {
        if (list.isEmpty())
            return null;
        return list.remove(list.first());
    }

    @Override
    public int size() {
        return list.size();
    }

    public static void main(String[] args) {
        SortedPriorityQueue pq = new SortedPriorityQueue();

        pq.insert(1, "A");
        pq.insert(2, "AB");
        pq.insert(3, "C");
        pq.insert(2, "G");

        Entry pqEntry;

        while (!pq.isEmpty()) {
            pqEntry = pq.removeMin();
            System.out.println("Key: " + pqEntry.getKey() + " Value: " + pqEntry.getValue());
        }



    }
}
