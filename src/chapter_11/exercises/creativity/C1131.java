package chapter_11.exercises.creativity;

import chapter_11.code.AVLTreeMap;

import java.util.Iterator;

/*C-11.31 Implement a putIfAbsent method, as originally described in Exercise C-10.33,
for the TreeMap class.*/

public class C1131 {

    public static void main(String[] args) {

        AVLTreeMap avltree = new AVLTreeMap();

        avltree.putIfAbsent(1, "A");
        avltree.putIfAbsent(2, "B");
        avltree.putIfAbsent(3, "C");
        avltree.putIfAbsent(0, "D");
        avltree.toString(avltree.root());


        avltree.remove(2);

        avltree.toString(avltree.root());
    }
}
