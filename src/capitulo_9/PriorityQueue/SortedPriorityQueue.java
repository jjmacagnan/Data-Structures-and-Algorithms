package capitulo_9.PriorityQueue;

import capitulo_7.iterators.LinkedPositionalList;
import capitulo_7.positional_list.Position;
import capitulo_7.positional_list.PositionalList;

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

        while (walk != null && compare(newest, walk.getElement()) < 0)
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
}
