package chapter_11.exercises.creativity;

import chapter_11.code.RBTreeMap;

/*C-11.48 Let T be a red-black tree storing n entries, and let k be the key of an entry in T.
Show how to construct from T , in O(logn) time, two red-black trees T ′ and T ′′,
such that T ′ contains all the keys of T less than k, and T ′′ contains all the keys of
T greater than k. This operation destroys T.*/

public class C1148 {

    public static void main(String[] args) {

        RBTreeMap treeMap = new RBTreeMap();


        treeMap.put(1, "A");
        treeMap.put(2, "B");
        treeMap.put(3, "C");
        treeMap.put(4, "D");
        treeMap.put(5, "E");
        treeMap.put(6, "F");
        treeMap.put(7, "G");


        RBTreeMap rbLess = new RBTreeMap();
        RBTreeMap rbGreater = new RBTreeMap();

        treeMap.separate(2, rbLess, rbGreater, treeMap.root());

        treeMap = null;

        rbLess.toString(rbLess.root());
        rbGreater.toString(rbGreater.root());

    }
}