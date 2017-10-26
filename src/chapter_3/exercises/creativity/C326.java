package chapter_3.exercises.creativity;

import chapter_3.code.DoublyLinkedList;

/*Give an algorithm for concatenating two doubly linked lists L and M, with header
and trailer sentinel nodes, into a single list L′.*/
public class C326 {

    public static void main(String[] args) {
        DoublyLinkedList list1 = new DoublyLinkedList();
        DoublyLinkedList list2 = new DoublyLinkedList();
        DoublyLinkedList list3;

        list1.addLast(3);
        list1.addFirst(1);
        list1.addFirst(4);
        list1.addLast("a");

        System.out.println("Lista 1: " + list1.toString());

        list2.addFirst("b");
        list2.addFirst("c");
        list2.addLast(0);
        list2.addLast(5);

        System.out.println("Lista 2: " + list2.toString());

        list3 = DoublyLinkedList.concatenarListas(list1, list2);

        System.out.println("Lista 3: " + list3.toString());
    }
}
