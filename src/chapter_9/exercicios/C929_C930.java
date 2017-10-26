package chapter_9.exercicios;

import chapter_7.code.positional_list.PositionalList;
import chapter_9.PriorityQueue.AbstractPriorityQueue;
import chapter_9.PriorityQueue.Entry;
import chapter_9.PriorityQueue.PriorityQueue;

import java.util.ArrayList;
import java.util.Comparator;

/*
 * Created by jjmacagnan on 17/06/2017.
 */
/*C-9.29 Give an alternative implementation of the HeapPriorityQueue’s upheap method
that uses recursion (and no loop).*/
/*C-9.30 Give an implementation of the HeapPriorityQueue’s downheap method that uses
recursion (and no loop).*/
public class C929_C930<K, V> extends AbstractPriorityQueue<K, V> {

    protected ArrayList<Entry<K, V>> heap = new ArrayList<>();

    public C929_C930() {
        super();
    }

    public C929_C930(Comparator<K> comp) {
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
        int p = parent(j);
        if (compare(heap.get(j), heap.get(p)) >= 0){
            return;
        } else {
            swap(j, p);
            j = p;
            upheap(j);
        }
    }

    protected void downheap(int j) {
        int leftIndex = left(j);
        int smallChildIndex = leftIndex;
        if (compare(heap.get(smallChildIndex), heap.get(j)) >= 0)
            return;
        else {
            if (hasRight(j)) {
                int rightIndex = right(j);
                if (compare(heap.get(leftIndex), heap.get(rightIndex)) > 0) {
                    smallChildIndex = rightIndex;
                }
            }
            swap(j, smallChildIndex);
            j = smallChildIndex;
            downheap(j);
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

    //Java Implementation of a Bottom-Up Heap Construction
    //Creates a priority queue initialized with the given key-value pairs.
    public C929_C930(K[] keys, V[] values) {
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
}
