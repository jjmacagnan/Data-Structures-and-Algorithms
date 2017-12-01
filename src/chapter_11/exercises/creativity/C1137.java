package chapter_11.exercises.creativity;

import chapter_11.code.AVLTreeMap;

/*C-11.37 Suppose we wish to support a new method countRange(k1, k2) that determines
how many keys of a sorted map fall in the specified range. We could clearly
implement this in O(s + h) time by adapting our approach to subMap. Describe how to modify the search-tree structure to support O(h) worst-case time
for countRange.*/

public class C1137 {

    public static void main(String[] args) {
        AVLTreeMap treeMap = new AVLTreeMap();

        treeMap.put(4, "a");
        treeMap.put(2, "b");
        treeMap.put(5, "c");
        treeMap.put(6, "d");
        treeMap.put(1, "e");

        int j = treeMap.countRange(1, 5);

        System.out.println(treeMap.toString());
        System.out.println(j);

    }
}
