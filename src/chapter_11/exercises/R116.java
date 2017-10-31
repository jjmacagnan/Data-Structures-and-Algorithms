package chapter_11.exercises;

import chapter_7.code.positional_list.Position;
import chapter_11.code.TreeMap;

/*
 * Created by Jasiel on 01/07/2017.
 */
/*Our implementation of the treeSearch utility, from Code Fragment 11.3, relies
on recursion. For a large unbalanced tree, it is possible that Java’s call stack will
reach its limit due to the recursive depth. Give an alternative implementation of
that method that does not rely on the use of recursion.*/
public class R116 {

    public static void main(String[] args) {
        TreeMap treeMap = new TreeMap();

        treeMap.put(1, "a");
        treeMap.put(2, "b");
        treeMap.put(3, "c");
        treeMap.put(4, "d");
        treeMap.put(5, "e");


        Position position = treeMap.treeSearchIterative(treeMap.root(), 1);
        System.out.println(position.getElement());

    }
}
