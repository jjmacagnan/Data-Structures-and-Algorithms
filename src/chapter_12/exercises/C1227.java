package chapter_12.exercises;

import chapter_7.code.iterators.LinkedPositionalList;

public class C1227 {

    public static void main(String[] args) {


        LinkedPositionalList positionalList = new LinkedPositionalList();
        positionalList.addFirst(5);
        positionalList.addFirst(1);
        positionalList.addFirst(8);
        System.out.println(positionalList.toString());
        positionalList.sort();
        System.out.println(positionalList.toString());

    }

}

