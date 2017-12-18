package chapter_11.exercises.reinforcement;

import chapter_11.code.TreeMap;

/*R-11.4 Dr. Amongus claims that the order in which a fixed set of entries is inserted into
a binary search tree does not matter—the same tree results every time. Give a
small example that proves he is wrong.*/

public class R114 {

    public static void main(String[] args) {
        TreeMap treeMap = new TreeMap();

        treeMap.put(48, null);
        treeMap.put(30, null);
        treeMap.put(40, null);
        treeMap.put(13, null);
        treeMap.put(24, null);
        treeMap.put(58, null);
        treeMap.put(26, null);

        treeMap.toString(treeMap.root());
    }
}
