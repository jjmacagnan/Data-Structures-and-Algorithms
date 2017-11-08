package chapter_9.code.Heap;

import chapter_7.code.positional_list.PositionalList;
import chapter_9.code.PriorityQueue.AbstractPriorityQueue;
import chapter_9.code.PriorityQueue.Entry;
import chapter_9.code.PriorityQueue.PriorityQueue;

import java.util.ArrayList;
import java.util.Comparator;

/*
 * Created by jjmacagnan on 02/06/2017.
 */
public class HeapPriorityQueue<K, V> extends AbstractPriorityQueue<K, V> {

    protected ArrayList<Entry<K, V>> heap = new ArrayList<>();

    public HeapPriorityQueue() {
        super();
    }

    public HeapPriorityQueue(Comparator<K> comp) {
        super(comp);
    }

    protected int parent(int j) {
        return (j - 1) / 2;
    }

    protected int left(int j) {
        return 2 * j + 1;
    }

    protected int right(int j) {
        return 2 * j + 2;
    }

    protected boolean hasLeft(int j) {
        return left(j) < heap.size();
    }

    protected boolean hasRight(int j) {
        return right(j) < heap.size();
    }

    protected void swap(int i, int j) {
        Entry<K, V> temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    protected void upheap(int j) {
        while (j > 0) {
            int p = parent(j);
            if (compare(heap.get(j), heap.get(p)) >= 0)
                break;
            swap(j, p);
            j = p;
        }
    }

    protected void downheap(int j) {
        while (hasLeft(j)) {
            int leftIndex = left(j);
            int smallChildIndex = leftIndex;
            if (hasRight(j)) {
                int rightIndex = right(j);
                if (compare(heap.get(leftIndex), heap.get(rightIndex)) > 0) {
                    smallChildIndex = rightIndex;
                }
            }
            if (compare(heap.get(smallChildIndex), heap.get(j)) >= 0)
                break;
            swap(j, smallChildIndex);
            j = smallChildIndex;
        }
    }


    @Override
    public int size() {
        return heap.size();
    }

    @Override
    public Entry<K, V> insert(K key, V value) throws IllegalStateException {
        checkkey(key);
        Entry<K, V> newest = new PQEntry<>(key, value);
        heap.add(newest);
        upheap(heap.size() - 1);
        return newest;
    }

    @Override
    public Entry<K, V> min() {
        if (heap.isEmpty())
            return null;
        return heap.get(0);
    }

    public Entry<K, V> max() {
        if (heap.isEmpty())
            return null;
        return heap.get(heap.size()-1);
    }

    @Override
    public Entry<K, V> removeMin() {
        if (heap.isEmpty())
            return null;
        Entry<K, V> answer = heap.get(0);
        swap(0, heap.size() - 1);
        heap.remove(heap.size() - 1);
        downheap(0);
        return answer;
    }

    public Entry<K, V> removeMax() {
        if (heap.isEmpty())
            return null;
        Entry<K, V> answer = heap.get(heap.size()-1);
        heap.remove(heap.size() - 1);
        return answer;
    }

    //Java Implementation of a Bottom-Up Heap Construction
    //Creates a priority queue initialized with the given key-value pairs.
    public HeapPriorityQueue(K[] keys, V[] values) {
        super();
        for (int j = 0; j < Math.min(keys.length, values.length); j++)
            heap.add(new PQEntry<>(keys[j], values[j]));
        heapfy();
    }

    /*Performs a bottom-up construction of the heap in linear time*/
    protected void heapfy() {
        int startIndex = parent(size()-1);
        for (int j = startIndex; j >= 0; j--)
            downheap(j);
    }

    /*Sorting with a Priority Queue*/
    /* Sorts sequence S, using initially empty priority queue P to produce the order*/
    public static <E> void pqSort(PositionalList<E> S, PriorityQueue<E, ?> P) {
        int n = S.size();
        for (int j = 0; j < n; j++) {
            E element = S.remove(S.first());
            P.insert(element, null);
        }
        for (int j = 0; j < n; j++) {
            E element = P.removeMin().getKey();
            S.addLast(element);
        }
    }


    public void combine(HeapPriorityQueue<K,V> t1, HeapPriorityQueue<K,V> t2) {
        while(t1.size() != 0) {
            Entry<K,V> temp = t1.removeMin();
            insert(temp.getKey(), temp.getValue());
        }

        while(t2.size() != 0) {
            Entry<K,V> temp = t2.removeMin();
            insert(temp.getKey(), temp.getValue());
        }
    }































}
