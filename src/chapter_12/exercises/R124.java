package chapter_12.exercises;


import chapter_10.code.sets_multses_multmaps.HashMultmap;
import chapter_12.code.MergeSort.ArrayBasedMergeSort;
import chapter_9.code.PriorityQueue.DefaultComparator;

import java.util.*;

public class R124<K> {

    public static void main(String[] args) {


        Comparator comparator = new DefaultComparator();

        HashMultmap map = new HashMultmap();

        map.put(1, "A");
        map.put(1, "B");
        map.put(2, "C");
        map.put(3, "D");

        Iterator it = map.entries().iterator();

        R124 r124 = new R124();

        ArrayBasedMergeSort.mergeSort(r124.getArray(it,map), comparator);
    }

    public K[] getArray(Iterator it, HashMultmap map) {

        K[] array = (K[]) new Object[map.size()];
        int i =0;

        while(it.hasNext()) {
            array[i] = (K) it.next();
            i++;
        }

        return  array;

    }
}
