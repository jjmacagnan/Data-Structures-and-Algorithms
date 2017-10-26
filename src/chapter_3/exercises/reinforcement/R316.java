package chapter_3.exercises.reinforcement;

import chapter_3.code.DoublyLinkedList;

/*Implement the equals() method for the DoublyLinkedList class.*/

/*R-3.16 Implemente o método equals() para a classe DoublyLinkedList.*/
public class R316 {

    public static void main (String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        DoublyLinkedList list1 = new DoublyLinkedList();

        list.addFirst(1);
        list.addLast(3);
        list.addFirst(4);
        list.addLast(2);
        list.addLast(0);
        list.addLast(45);

        list1.addFirst(1);
        list1.addLast(3);
        list1.addFirst(4);
        list1.addLast(2);
        list1.addLast(0);
        list1.addLast(45);

        if (list.equals(list1)){
            System.out.println("Listas com valores iguais");
        } else {
            System.out.println("Listas com valores diferentes");
        }
    }
}
