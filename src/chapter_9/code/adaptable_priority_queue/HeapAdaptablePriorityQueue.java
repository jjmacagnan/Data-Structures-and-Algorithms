package chapter_9.code.adaptable_priority_queue;

import chapter_9.code.Heap.HeapPriorityQueue;
import chapter_9.code.PriorityQueue.Entry;

import java.util.Comparator;

/*
 * Created by jjmacagnan on 03/06/2017.
 */
public class HeapAdaptablePriorityQueue<K, V> extends HeapPriorityQueue<K, V> implements AdaptablePriorityQueue<K, V> {

    protected static class AdaptablePQEntry<K, V> extends PQEntry<K, V> {
        private int index;
        public AdaptablePQEntry(K key, V value, int j) {
            super(key, value);
            index = j;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int j) {
            this.index = j;
        }
    }

    public HeapAdaptablePriorityQueue() {
        super();
    }

    public HeapAdaptablePriorityQueue(Comparator<K> comp) {
        super(comp);
    }

    protected AdaptablePQEntry<K, V> validate(Entry<K, V> entry) throws IllegalStateException {
        if (!(entry instanceof AdaptablePQEntry))
            throw new IllegalStateException("Invalid entry");
        AdaptablePQEntry<K, V> locator = (AdaptablePQEntry<K, V>) entry;
        int j = locator.getIndex();
        if (j >= heap.size() || heap.get(j) != locator)
            throw new IllegalStateException("Invalid entry");
        return locator;
    }

    protected void swap(int i, int j) {
        super.swap(i,j);
        ((AdaptablePQEntry<K, V>) heap.get(i)).setIndex(i);
        ((AdaptablePQEntry<K, V>) heap.get(j)).setIndex(j);
    }

    protected void bubble(int j) {
        if (j > 0 && compare(heap.get(j), heap.get(parent(j))) < 0)
            upheap(j);
        else downheap(j);
    }

    @Override
    public Entry<K, V> insert(K key, V value) throws IllegalStateException {
        checkkey(key);
        Entry<K, V> newest = new AdaptablePQEntry<>(key, value, heap.size());
        heap.add(newest);
        upheap(heap.size()-1);
        return newest;
    }

   @Override
    public void remove(Entry<K, V> entry)  throws IllegalArgumentException {
        AdaptablePQEntry<K, V> locator = validate(entry);
        int j = locator.getIndex();
        if (j == heap.size()-1)
            heap.remove(heap.size()-1);
        else {
            swap(j, heap.size()-1);
            heap.remove(heap.size()-1);
            bubble(j);
        }
    }

    @Override
    public void replaceKey(Entry<K, V> entry, K key)  throws IllegalArgumentException{
        AdaptablePQEntry<K, V> locator = validate(entry);
        checkkey(key);
        locator.setKey(key);
        bubble(locator.getIndex());
    }

    @Override
    public void replaceValue(Entry<K, V> entry, V value)  throws IllegalArgumentException {
        AdaptablePQEntry<K, V> locator = validate(entry);
        locator.setValue(value);
    }
}
