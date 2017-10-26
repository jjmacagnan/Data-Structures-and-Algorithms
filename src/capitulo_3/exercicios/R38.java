package capitulo_3.exercicios;

import capitulo_3.codigos.DoublyLinkedList;

/*Describe a method for finding the middle node of a doubly linked list with header
and trailer sentinels by “link hopping,” and without relying on explicit knowledge
of the size of the list. In the case of an even number of nodes, report the node
slightly left of center as the “middle.” What is the running time of this method?*/

/*R-3.8 Descreva um método para encontrar o nó central de uma lista duplamente encadeada
com sentinelas de cabeçalho e trailer por "link hopping", e sem confiar no conhecimento
explícito do tamanho da lista. No caso de um número par de nós,
informe o nó ligeiramente à esquerda do centro como o "meio".
Qual é o tempo de execução desse método?*/

public class R38 {

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();

        list.addFirst(1);
        list.addLast(3);
        list.addFirst(4);
        list.addLast(2);
        list.addLast(0);
        list.addLast(45);

        System.out.println(list.toString());
        list.encontraNoMeioDaLista();

    }
}
