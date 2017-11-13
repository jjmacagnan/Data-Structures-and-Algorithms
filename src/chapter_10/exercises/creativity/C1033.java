package chapter_10.exercises.creativity;

import chapter_10.code.maps.UnsortedTableMap;
import chapter_9.code.PriorityQueue.Entry;

import java.util.Iterator;

public class C1033 {

    public static void main(String args[]) {

        UnsortedTableMap map = new UnsortedTableMap();

        map.putIfAbsent(3, "B");
        map.putIfAbsent(2, "A");
        map.putIfAbsent(1, "C");

         Iterable iterable = map.entrySet();

         Iterator it = iterable.iterator();

         while(it.hasNext()) {
             Entry entry = (Entry) it.next();
             System.out.println(entry.getValue());
         }

         System.out.println(map.get(1));

    }

}
