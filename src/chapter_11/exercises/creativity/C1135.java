package chapter_11.exercises.creativity;

import chapter_11.code.AVLTreeMap;

/*C-11.35 Consider a sorted map that is implemented with a standard binary search tree T.
Describe how to perform an operation removeSubMap(k1, k2) that removes all
the entries whose keys fall within subMap(k1, k2), in worst-case time O(s + h),
where s is the number of entries removed and h is the height of T.*/

/*Tempo de execução será O(n log n)*/

public class C1135 {

    public static void main(String[] args) {
        AVLTreeMap treeMap = new AVLTreeMap();

        treeMap.put(4, "a");
        treeMap.put(2, "b");
        treeMap.put(5, "c");
        treeMap.put(6, "d");
        treeMap.put(1, "e");

        treeMap.removeSubMap(0, 7);

        System.out.println(treeMap.toString());

    }
}
