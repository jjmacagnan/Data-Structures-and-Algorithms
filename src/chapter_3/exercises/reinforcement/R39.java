package chapter_3.exercises.reinforcement;

import chapter_3.code.SinglyLinkedList;

/*Give an implementation of the size() method for the SingularlyLinkedList class,
assuming that we did not maintain size as an instance variable.*/

/*R-3.9 Dê uma implementação do método size() para a classe SingularlyLinkedList,
assumindo que o tamanho não é mantido com uma variável de instância.*/
public class R39 {

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        list.addLast("A");
        list.addFirst("B");
        list.addFirst("C");

        System.out.println("Tamanho da lista: " + list.sizeNotInstance());
    }
}
