package capitulo_3.exercicios;

import capitulo_3.codigos.CircularlyLinkedList;

/* Give an implementation of the size() method for the CircularlyLinkedList class,
assuming that we did not maintain size as an instance variable.*/

/*R-3.10 Dê uma implementação do método size() para a classe CircularlyLinkedList,
assumindo que o tamanho não é mantido com uma variável de instância.*/
public class R310 {

    public static void main(String[] args) {
        CircularlyLinkedList list = new CircularlyLinkedList();

        list.addLast("A");
        list.addFirst("B");
        list.addFirst("C");

        System.out.println("Tamanho da lista: " + list.sizeNotInstance());
    }
}
