package chapter_11.exercises.creativity;

import chapter_11.code.AVLTreeMap;
import chapter_11.code.TreeMap;

/*C-11.36 Repeat the previous problem using an AVL tree, achieving a running time of
O(s logn). Why doesn’t the solution to the previous problem trivially result in an
O(s + logn) algorithm for AVL trees?*/

/* Pelo fato de que algoritmo submap possui complexidade O(s + h) */

public class C1136 {

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
