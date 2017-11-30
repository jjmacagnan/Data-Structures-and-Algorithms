package chapter_11.exercises;

import chapter_11.code.TreeMap;

/*R-11.1 If we insert the entries (1,A), (2,B), (3,C), (4,D), and (5,E), in this order, into
an initially empty binary search tree, what will it look like?*/

public class R11 {

    public static void main(String[] args) {
        TreeMap treeMap = new TreeMap();

        treeMap.put(1, "a");
        treeMap.put(2, "b");
        treeMap.put(3, "c");
        treeMap.put(4, "d");
        treeMap.put(5, "e");

        System.out.println(treeMap.toString());
    }
}
