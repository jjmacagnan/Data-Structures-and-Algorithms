package prova_1.capitulo_3.exercicios.criatividade;

import prova_1.capitulo_3.codigos_livro.CircularlyLinkedList;

/*Suppose you are given two circularly linked lists, L and M. Describe an algorithm
for telling if L and M store the same sequence of elements (but perhaps with
different starting points).*/
public class C329 {

    public static void main(String[] args) {
        CircularlyLinkedList list = new CircularlyLinkedList();
        CircularlyLinkedList list2 = new CircularlyLinkedList();

        list.addFirst("a");
        list.addFirst("b");
        list.addFirst("c");


        list2.addFirst("c");
        list2.addFirst("a");
        list2.addFirst("b");

        System.out.println("Lista 1: " + list.toString());
        System.out.println("Lista 2: " + list2.toString());

        if (list.isEqualContents(list,list2)) {
            System.out.println("Listas iguais");
        } else {
            System.out.println("Listas diferentes");
        }
    }
}
