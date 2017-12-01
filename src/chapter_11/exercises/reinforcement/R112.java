package chapter_11.exercises.reinforcement;

/*R-11.2 Insert, into an empty binary search tree, entries with keys 30, 40, 24, 58, 48, 26,
11, 13 (in this order). Draw the tree after each insertion.*/

import chapter_11.code.TreeMap;

public class R112 {

    public static void main(String[] args) {
        TreeMap treeMap = new TreeMap();

        treeMap.put(30, null);
        treeMap.put(40, null);
        treeMap.put(24, null);
        treeMap.put(58, null);
        treeMap.put(48, null);
        treeMap.put(26, null);
        treeMap.put(13, null);

        System.out.println(treeMap.toString());
    }
}
