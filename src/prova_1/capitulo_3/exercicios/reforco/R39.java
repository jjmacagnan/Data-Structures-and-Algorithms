package prova_1.capitulo_3.exercicios.reforco;

import prova_1.capitulo_3.codigos_livro.SinglyLinkedList;

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
