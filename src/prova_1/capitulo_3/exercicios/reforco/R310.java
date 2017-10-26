package prova_1.capitulo_3.exercicios.reforco;

import prova_1.capitulo_3.codigos_livro.CircularlyLinkedList;
import prova_1.capitulo_3.codigos_livro.SinglyLinkedList;

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
