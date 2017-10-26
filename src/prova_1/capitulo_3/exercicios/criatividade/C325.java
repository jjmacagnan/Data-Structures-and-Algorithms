package prova_1.capitulo_3.exercicios.criatividade;

import prova_1.capitulo_3.codigos_livro.SinglyLinkedList;

/*C-3.25 Describe an algorithm for concatenating two singly linked lists L and M, into a
single list L′ that contains all the nodes of L followed by all the nodes of M.*/
public class C325 {

    public static void main(String[] args) {
        SinglyLinkedList list1 = new SinglyLinkedList();
        SinglyLinkedList list2 = new SinglyLinkedList();
        SinglyLinkedList list3;

        list1.addFirst(1);
        list1.addLast(2);
        list1.addFirst(3);
        list1.addLast(4);

        System.out.println("Lista 1: " + list1.toString());

        list2.addFirst(5);
        list2.addFirst(6);
        list2.addFirst(7);
        list2.addFirst(8);

        System.out.println("Lista 2: " + list2.toString());

        list3 = SinglyLinkedList.concatenarListas(list1, list2);

        System.out.println("Lista concatenda: " + list3.toString());
    }
}
