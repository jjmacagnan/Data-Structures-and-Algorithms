package prova_1.capitulo_3.exercicios.reforco;

import prova_1.capitulo_3.codigos_livro.SinglyLinkedList;

/*R-3.6 Dê um algoritmo que encontre o penúltimo nó numa lista simplesmente encadeada
em que o último nó é indicado por uma referência next nula.*/
public class R36 {

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        list.addFirst(1);
        list.addLast(3);
        list.addFirst(4);
        list.addLast(2);
        list.addLast(0);
        list.addLast(6);

        System.out.println(list.toString());
        System.out.println("Elemento do penultimo nó: " + list.achaPenultimo().getElement());

    }
}
