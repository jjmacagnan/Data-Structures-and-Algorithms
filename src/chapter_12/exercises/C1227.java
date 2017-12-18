package chapter_12.exercises;

import chapter_7.code.iterators.LinkedPositionalList;

/*C-12.27 Augment the PositionalList class (see Section 7.3) to support a method named
sort that sorts the elements of a list by relinking existing nodes; you are not to
create any new nodes. You may use your choice of sorting algorithm.*/

public class C1227 {

    public static void main(String[] args) {


        LinkedPositionalList positionalList = new LinkedPositionalList();
        positionalList.addFirst(5);
        positionalList.addFirst(1);
        positionalList.addFirst(8);
        System.out.println(positionalList.toString());
        positionalList.sort();
    }

}

