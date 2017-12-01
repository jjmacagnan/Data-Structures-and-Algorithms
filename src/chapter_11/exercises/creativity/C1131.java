package chapter_11.exercises.creativity;

import chapter_11.code.AVLTreeMap;

import java.util.Iterator;

public class C1131 {

    public static void main(String[] args) {

        AVLTreeMap avltree = new AVLTreeMap();

        avltree.putIfAbsent(1, "A");
        avltree.putIfAbsent(2, "B");
        avltree.putIfAbsent(3, "C");


        avltree.remove(1);

        Iterator it = avltree.keySet().iterator();

        while(it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
