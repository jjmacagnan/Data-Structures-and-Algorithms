package chapter_7.exercises.reinforcement;

import chapter_7.code.positional_list.LinkedPositionalList;

/* R-7.11 Descreva uma implementação dos métodos da lista de posição addLast e addBefore
realizado usando apenas métodos no set {isEmpty, first, last, before, after, addAfter, addFirst}.*/
public class R711 {

    public static void main(String args[]) {
        LinkedPositionalList list = new LinkedPositionalList();

        list.addFirst("A");
        list.addLast("B");
        list.addLastAlt("C");

        list.addBefore(list.first(), 1);
        list.addBeforeAlt(list.last(), 2);
        list.addBeforeAlt(list.first(), "D");

        System.out.println(list.toString());
    }
}
