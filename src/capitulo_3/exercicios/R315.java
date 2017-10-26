package capitulo_3.exercicios;

import capitulo_3.codigos.CircularlyLinkedList;

/*Implement the equals() method for the CircularlyLinkedList class, assuming that
two lists are equal if they have the same sequence of elements,
with corresponding elements currently at the front of the list.*/

/*R-3.15 Implemente o método equals() para a classe CircularlyLinkedList,
assumindo que duas listas são iguais se elas possuem a mesma sequência de elementos,
com elementos correspondentes atualmente na parte da frente da lista.*/
public class R315 {

    public static void main (String[] args) {
        CircularlyLinkedList list = new CircularlyLinkedList();
        CircularlyLinkedList list1 = new CircularlyLinkedList();

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
