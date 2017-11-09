package chapter_9.exercises.creativity;

import chapter_9.code.PriorityQueue.AbstractPriorityQueue;
import chapter_9.code.PriorityQueue.Entry;

import java.lang.reflect.Array;

/* Reimplement the SortedPriorityQueue using a Java array. Make sure to maintain
removeMin’s O(1) performance.*/

public class C928<K,V> extends AbstractPriorityQueue<K,V> {

    private Entry<K, V> data[];
    private int size = 0;
    int f = 0;


    public C928() {
        data = (Entry<K, V>[]) new Object[10];
    }

    @Override
    public int size() {
        return data.length;
    }

    private int findIndex(K key) {
        int n = size();
        for(int i = 0; i< n; i++) {
            if(data[i].getKey().equals(key)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Entry<K, V> insert(K key, V value) throws IllegalStateException {
        checkkey(key);
        Entry<K, V> newEntry = new PQEntry<>(key, value);

        int indexKey = findIndex(key);
        int indexToInsert=0;

        if(indexKey == -1) {
            int i = 0;
            while(i < size()-1) {

                if(compare(newEntry, data[i-1]) > 0){

                    for(int j=size()-1;j>= i;j--) {
                        data[j+1] = data[j];
                    }
                    data[i] = newEntry;
                    size++;
                    break;
                }
            }
        }

        return null;
    }

    @Override
    public Entry<K, V> min() {
        return data[0];
    }

    @Override
    public Entry<K, V> removeMin() {
        Entry<K,V> temp = data[f];
        data[f] = null;
        f++;
        return temp;
    }

    public static void main(String args[]) {

        C928<Integer, String> r928 = new C928<>();

        r928.insert(1, "Star wars");
        r928.insert(2, "Vaca loca");

        System.out.println(r928.min().getValue());


    }
}
