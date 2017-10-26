package chapter_9.PriorityQueue;

import java.util.Comparator;

/*
 * Created by jjmacagnan on 31/05/2017.
 */
public abstract class AbstractPriorityQueue<K, V> implements PriorityQueue<K, V> {

    protected static class PQEntry<K, V> implements Entry<K, V> {
        private K k;
        private V v;

        public PQEntry(K key, V value) {
            k = key;
            v = value;
        }
        @Override
        public K getKey() {
            return k;
        }

        @Override
        public V getValue() {
            return v;
        }

        public void setKey(K key) {
            this.k = key;
        }

        public void setValue(V value) {
            this.v = value;
        }
    }

    private Comparator<K> comp;

   protected AbstractPriorityQueue(Comparator<K> c) {
       comp = c;
   }

   protected AbstractPriorityQueue() {
       this(new DefaultComparator<K>());
   }

   protected int compare(Entry<K, V> a, Entry<K, V> b) {
       return comp.compare(a.getKey(), b.getKey());
   }

   protected boolean checkkey(K key) throws IllegalStateException {
       try {
           return (comp.compare(key, key) == 0);
       } catch (ClassCastException e) {
           throw new IllegalStateException("Incompatible key");
       }
   }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }
}
