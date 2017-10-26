package chapter_5.exercises.creativity;

import chapter_3.code.SinglyLinkedList;

/*Describe in detail an algorithm for reversing a singly linked list L using only a
constant amount of additional space.*/
public class C525 {

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        list.addFirst(1);
        list.addLast(2);
        list.addFirst(3);
        list.addFirst(4);
        list.addFirst(5);

        System.out.println("Lista original: " + list.toString());

        list.reverse();
        System.out.println("Lista invertida: " + list.toString());



    }



}
