package chapter_10.code.maps.sorted_maps;

import chapter_10.code.maps.AbstractMap;
import chapter_9.code.PriorityQueue.DefaultComparator;
import chapter_9.code.PriorityQueue.Entry;

import java.util.Comparator;

/*
 * Created by jjmacagnan on 17/06/2017.
 */
public abstract class AbstractSortedMap<K,V>
        extends AbstractMap<K,V> implements SortedMap<K,V> {

    // instance variable for an AbstractSortedMap
    /** The comparator defining the ordering of keys in the map. */
    private Comparator<K> comp;

    /**
     * Initializes the comparator for the map.
     * @param c comparator defining the order of keys in the map
     */
    protected AbstractSortedMap(Comparator<K> c) {
        comp = c;
    }

    /** Initializes the map with a default comparator. */
    protected AbstractSortedMap() {
        this(new DefaultComparator<>());    // default comparator uses natural ordering
    }

    /** Method for comparing two entries according to key */
    protected int compare(Entry<K,V> a, Entry<K,V> b) {
        return comp.compare(a.getKey(), b.getKey());
    }

    /** Method for comparing a key and an entry's key */
    protected int compare(K a, Entry<K,V> b) {
        return comp.compare(a, b.getKey());
    }

    /** Method for comparing a key and an entry's key */
    protected int compare(Entry<K,V> a, K b) {
        return comp.compare(a.getKey(), b);
    }

    /** Method for comparing two keys */
    protected int compare(K a, K b) {
        return comp.compare(a, b);
    }

    /** Determines whether a key is valid. */
    protected boolean checkKey(K key) throws IllegalArgumentException {
        try {
            return (comp.compare(key,key)==0);   // see if key can be compared to itself
        } catch (ClassCastException e) {
            throw new IllegalArgumentException("Incompatible key");
        }
    }
}
