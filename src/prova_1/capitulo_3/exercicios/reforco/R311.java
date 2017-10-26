package prova_1.capitulo_3.exercicios.reforco;

import prova_1.capitulo_3.codigos_livro.DoublyLinkedList;
import prova_1.capitulo_3.exercicios.criatividade.C331_DoublyLinkedListOneSentinel;

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
