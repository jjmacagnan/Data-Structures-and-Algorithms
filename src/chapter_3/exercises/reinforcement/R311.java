package chapter_3.exercises.reinforcement;

import chapter_3.code.DoublyLinkedList;

/*Give an implementation of the size() method for the DoublyLinkedList class,
assuming that we did not maintain size as an instance variable.*/

/*R-3.11 Dê uma implementação do método size() para a classe DoublyLinkedList,
assumindo que o tamanho não é mantido com uma variável de instância.
*/
public class R311 {

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();

        list.addLast("A");
        list.addFirst("B");
        list.addFirst("C");

        System.out.println("Tamanho da lista: " + list.sizeNotInstance());
    }
}
